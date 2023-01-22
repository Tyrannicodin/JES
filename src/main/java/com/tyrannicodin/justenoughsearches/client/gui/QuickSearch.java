package com.tyrannicodin.justenoughsearches.client.gui;

import com.mojang.blaze3d.vertex.PoseStack;
import com.tyrannicodin.justenoughsearches.client.gui.list.ListContainer;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.TranslatableComponent;
import com.tyrannicodin.justenoughsearches.client.config.QuickSearchConfig;

public class QuickSearch extends Screen {
    private String prefix = "";

    private EditBox tInput;
    private ListContainer listContainer;

    private final int xPadding;
    private final int yTopPadding;
    private final int yBottomPadding;
    private final int ElementPadding;
    private final int width;

    public QuickSearch(String pPrefix) {
        super(new TranslatableComponent("gui.justenoughsearches.quicksearch.title"));
        prefix = pPrefix;

        xPadding = QuickSearchConfig.PADDINGX.get();
        yTopPadding = QuickSearchConfig.PADDINGYT.get();
        yBottomPadding = QuickSearchConfig.PADDINGYB.get();
        width = QuickSearchConfig.WIDTH.get();
        ElementPadding = QuickSearchConfig.PADDINGELEMENT.get();
    }

    @Override
    protected void init() {
        super.init();

        int editBoxY = yTopPadding+QuickSearchConfig.PADDINGTITLE.get()+font.lineHeight;
        tInput = new EditBox(this.font, xPadding, editBoxY, width, 20, new TranslatableComponent("gui.justenoughsearches.quicksearch.editbox"));
        if (tInput.getValue() == "") {
            tInput.setValue(prefix);
        }
        tInput.setVisible(true);
        addRenderableWidget(tInput);
        if (QuickSearchConfig.AUTOFOCUS.get()) {
            tInput.setFocus(true);
            tInput.setEditable(true);
            setFocused(tInput);
        }

        listContainer = new ListContainer(xPadding, editBoxY+20+ElementPadding, width, 20, yBottomPadding, ElementPadding);
    }

    @Override
    public void tick() {
        super.tick();
        tInput.tick();
    }

    @Override
    public void render(PoseStack stack, int mouseX, int mouseY, float pPartialTick) {
        drawString(stack, font, new TranslatableComponent("gui.justenoughsearches.quicksearch_title"), xPadding, yTopPadding, 0xFFFFFF);

        listContainer.render(stack, mouseX, mouseY, pPartialTick, tInput.getValue());

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
