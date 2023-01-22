package com.tyrannicodin.justenoughsearches.client.gui.list;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.world.item.ItemStack;
import net.objecthunter.exp4j.ExpressionBuilder;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

public class ListContainer {
    private final ArrayList<ListElement> ListItems = new ArrayList<>();
    private final EquationListElement equation;
    private final int x;
    private final int y;
    private final int width;
    private final int height;
    private final int bottomPadding;
    private final int elementPadding;

    private String prevInput = "";

    public ListContainer(int pX, int pY, int pWidth, int pHeight, int pBottomPadding, int pElementPadding) {
        x = pX;
        y = pY;
        width = pWidth;
        height = pHeight;
        bottomPadding = pBottomPadding;
        elementPadding = pElementPadding;

        equation = new EquationListElement(x, y, width, height);
    }

    public void render(PoseStack pPoseStack, int pMouseX, int pMouseY, float pPartialTick, String Input) {
        if (Input == prevInput) {
            if (Input.startsWith("=")) {
                renderEquation(pPoseStack, pMouseX, pMouseY, pPartialTick, equation.Result);
            } else {
                renderItems(pPoseStack, pMouseX, pMouseY, pPartialTick);
            }
        } else {
            ListItems.clear();
            prevInput = Input;
            if (Input.startsWith("=")) {
                double Result;
                try {
                    Result = new ExpressionBuilder(Input.replace("=", "")).build().evaluate();
                } catch (IllegalArgumentException | EmptyStackException exception) {
                    Result = 0.0;
                }
                ListItems.add(equation);
                renderEquation(pPoseStack, pMouseX, pMouseY, pPartialTick, Result);
                //Minecraft.getInstance().player.displayClientMessage(new TextComponent(Result + ""), true);
            } else {
                if (SearchHandler.getInstance() != null) {
                    List<ItemStack> results = SearchHandler.searchItems(Input);
                    int maxHeight = Minecraft.getInstance().screen.height;
                    results.forEach(Item -> {
                        if (y+((height+elementPadding)*(ListItems.size()+1)+bottomPadding) < maxHeight) {
                            ListItems.add(new ItemListElement(x, y+((height+elementPadding)*ListItems.size()), width, height, Item));
                        }
                    });
                    renderItems(pPoseStack, pMouseX, pMouseY, pPartialTick);
                }
            }
        }
    }

    private void renderEquation(PoseStack pPoseStack, int pMouseX, int pMouseY, float pPartialTick, double Result) {
        ListItems.get(0).Result = Result;
        ListItems.get(0).render(pPoseStack, pMouseX, pMouseY, pPartialTick);
    }

    private void renderItems(PoseStack pPoseStack, int pMouseX, int pMouseY, float pPartialTick) {
        ListItems.forEach(Item -> {
            if (!Item.isEquation()) {
                Item.render(pPoseStack, pMouseX, pMouseY, pPartialTick);
            }
        });
    }
}
