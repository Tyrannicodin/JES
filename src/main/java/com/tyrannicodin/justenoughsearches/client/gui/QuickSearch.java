package com.tyrannicodin.justenoughsearches.client.gui;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.logging.LogUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.components.events.GuiEventListener;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.TranslatableComponent;
import net.objecthunter.exp4j.ExpressionBuilder;
import org.slf4j.Logger;

import java.util.EmptyStackException;

public class QuickSearch extends Screen {
    private String prevValue = "";
    private String prefix = "";

    private EditBox TInput;

    private static final Logger LOGGER = LogUtils.getLogger();

    public QuickSearch(String pPrefix) {
        super(new TranslatableComponent("gui.justenoughsearches.quicksearch_title"));
        prefix = pPrefix;

    }

    @Override
    protected void init() {
        super.init();

        TInput = new EditBox(this.font, 10, 10, 150, 16, new TextComponent(""));
        TInput.setValue(prefix);
        TInput.setVisible(true);
        addRenderableWidget(TInput);
        TInput.setFocus(true);
        TInput.setEditable(true);
        setFocused(TInput);
    }

    @Override
    public void tick() {
        super.tick();
        TInput.tick();

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
        drawString(stack, this.font, new TranslatableComponent("gui.justenoughsearches.quicksearch_title"), 10, 0, 0xFFFFFF);

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
