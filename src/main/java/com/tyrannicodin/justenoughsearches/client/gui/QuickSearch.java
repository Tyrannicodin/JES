package com.tyrannicodin.justenoughsearches.client.gui;

import com.mojang.logging.LogUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.TextComponent;
import net.objecthunter.exp4j.ExpressionBuilder;
import java.util.EmptyStackException;

public class QuickSearch extends Screen {
    private String prevValue = "";

    private EditBox TInput;
    public QuickSearch() {
        super(new TextComponent("Quick search"));
    }

    @Override
    protected void init() {
        super.init();
        TInput = new EditBox(this.font, 10, 10, 150, 16, new TextComponent(""));;
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
    public boolean isPauseScreen() {
        return false;
    }

    @Override
    public boolean shouldCloseOnEsc() {
        return true;
    }
}
