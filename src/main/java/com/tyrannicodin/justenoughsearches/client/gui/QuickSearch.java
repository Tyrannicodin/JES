package com.tyrannicodin.justenoughsearches.client.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.TextComponent;
import net.objecthunter.exp4j.ExpressionBuilder;

public class QuickSearch extends Screen {
    private EditBox TInput;
    public QuickSearch() {
        super(new TextComponent("Quick search"));
    }

    @Override
    protected void init() {
        super.init();
        this.TInput = new EditBox(this.font, 10, 10, 150, 16, new TextComponent(""));
        TInput.setVisible(true);
        this.addRenderableWidget(TInput);
    }

    @Override
    public void tick() {
        if (TInput.getValue().startsWith("=")) {
            Double result;
            try {
                result = new ExpressionBuilder("1+1").build().evaluate();
            } catch (IllegalArgumentException exception) {
                result = 0.0;
            }
            Minecraft.getInstance().player.displayClientMessage(new TextComponent(result + ""), true);
        } else {

        }
        super.tick();
    }

    protected void keyTyped(char par1, int par2) {
        TInput.charTyped(par1, par2);
        super.charTyped(par1, par2);
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
