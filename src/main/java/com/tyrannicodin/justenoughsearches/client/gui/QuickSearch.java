package com.tyrannicodin.justenoughsearches.client.gui;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.logging.LogUtils;
import com.tyrannicodin.justenoughsearches.client.gui.list.ListContainer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.components.EditBox;
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
    private ListContainer ItemContainer;

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

        ItemContainer = new ListContainer(10, 26, 150);
    }

    @Override
    public void tick() {
        super.tick();
        TInput.tick();
    }

    @Override
    public void render(PoseStack stack, int mouseX, int mouseY, float pPartialTick) {
        drawString(stack, this.font, new TranslatableComponent("gui.justenoughsearches.quicksearch_title"), 10, 0, 0xFFFFFF);

        ItemContainer.render(stack, mouseX, mouseY, pPartialTick, TInput.getValue());

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
