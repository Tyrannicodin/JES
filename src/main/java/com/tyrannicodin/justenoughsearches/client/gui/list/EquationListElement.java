package com.tyrannicodin.justenoughsearches.client.gui.list;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.gui.narration.NarratedElementType;
import net.minecraft.client.gui.narration.NarrationElementOutput;
import net.minecraft.network.chat.TextComponent;

public class EquationListElement extends ListElement {
    public EquationListElement(int pX, int pY, int pWidth, int pHeight) {
        super(pX, pY, pWidth, pHeight);
    }

    @Override
    public boolean isEquation() {return true;}

    @Override
    public void render(PoseStack pPoseStack, int pMouseX, int pMouseY, float pPartialTick) {
        setMessage(new TextComponent("" + Result));
        super.render(pPoseStack, pMouseX, pMouseY, pPartialTick);
    }

    public void updateNarration(NarrationElementOutput NarratableElement) {
        NarratableElement.add(NarratedElementType.TITLE, getMessage());
    }
}
