package com.tyrannicodin.justenoughsearches.client.gui;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.components.MultiLineLabel;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.TranslatableComponent;
import net.objecthunter.exp4j.ExpressionBuilder;
import java.util.EmptyStackException;

public class QuickSearch extends Screen {
    private String prevValue = "";
    private String prefix = "";

    private EditBox TInput;

    public QuickSearch(String pPrefix) {
        super(new TranslatableComponent("gui.justenoughsearches.quicksearch_title"));
        prefix = pPrefix;

    }

    @Override
    protected void init() {
        super.init();

        TInput = new EditBox(this.font, 10, 10, 150, 16, new TextComponent(prefix));
        TInput.setFocus(true);
        TInput.setVisible(true);
        this.addRenderableWidget(TInput);
    }

    @Override
    public void tick() {
        String tiValue = TInput.getValue();
        if (tiValue != prevValue && tiValue.startsWith("=")) {
            prevValue = tiValue;
            Double Result;
            try {
                Result = new ExpressionBuilder(tiValue.replace("=", "")).build().evaluate();
            } catch (IllegalArgumentException exception) {
                Result = 0.0;
            } catch (EmptyStackException exception) {
                Result = 0.0;
            }
            Minecraft.getInstance().player.displayClientMessage(new TextComponent(Result + ""), true);
        }
    }

    @Override
    public void render(PoseStack stack, int mouseX, int mouseY, float pPartialTick) {
        drawString(stack, this.font, new TranslatableComponent("gui.justenoughsearches.quicksearch_title"), 16, 0, 0xFFFFFF);

        super.render(stack, mouseX, mouseY, pPartialTick);
    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }

    @Override
    public boolean shouldCloseOnEsc() {
        return true;
    }
}
