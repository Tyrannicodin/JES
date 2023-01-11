package com.tyrannicodin.justenoughsearches.client.gui.list;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.gui.narration.NarratedElementType;
import net.minecraft.client.gui.narration.NarrationElementOutput;
import net.minecraft.network.chat.TranslatableComponent;

public class ItemListElement extends ListElement{
    public ItemListElement(int pX, int pY, int pWidth, int pHeight) {
        super(pX, pY, pWidth, pHeight);
    }

    public void updateNarration(NarrationElementOutput NarratableElement) {
        NarratableElement.add(NarratedElementType.TITLE, new TranslatableComponent("Item name: ", ""));
        NarratableElement.add(NarratedElementType.HINT, new TranslatableComponent("Mod name: ", ""));
    }

    @Override
    public void render(PoseStack pPoseStack, int pMouseX, int pMouseY, float pPartialTick) {
        super.render(pPoseStack, pMouseX, pMouseY, pPartialTick);
    }
}
