package com.tyrannicodin.justenoughsearches.client.gui.list;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.TextComponent;
import net.objecthunter.exp4j.ExpressionBuilder;

import java.util.ArrayList;
import java.util.EmptyStackException;

public class ListContainer {
    private ArrayList<ListElement> ListItems = new ArrayList<ListElement>();
    private EquationListElement Equation;
    private int x;
    private int y;
    private int width;
    private int height;
    private String prevInput = "";

    public ListContainer(int pX, int pY, int pWidth, int pHeight) {
        x = pX;
        y = pY;
        width = pWidth;
        height = pHeight;
        Equation = new EquationListElement(x, y+1, width, height);
    }

    public void render(PoseStack pPoseStack, int pMouseX, int pMouseY, float pPartialTick, String Input) {
        if (Input == prevInput) {
            if (Input.startsWith("=")) {
                renderEquation(pPoseStack, pMouseX, pMouseY, pPartialTick, Equation.Result);
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
                ListItems.add(Equation);
                renderEquation(pPoseStack, pMouseX, pMouseY, pPartialTick, Result);
                Minecraft.getInstance().player.displayClientMessage(new TextComponent(Result + ""), true);
            } else {
                //JEI stuff goes here
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
                //JEI stuff
            }
        });
    }
}
