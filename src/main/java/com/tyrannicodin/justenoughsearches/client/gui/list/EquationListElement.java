package com.tyrannicodin.justenoughsearches.client.gui.list;

import com.mojang.blaze3d.vertex.PoseStack;

public class EquationListElement extends ListElement {
    public EquationListElement(int x, int y) {
        super(x, y);
    }

    public void render(PoseStack pPoseStack, int pMouseX, int pMouseY, float pPartialTick, int Result) {
        super.render(pPoseStack, pMouseX, pMouseY, pPartialTick);
        drawString(pPoseStack, font, "=" + Result,  x + BORDERSIZE + BORDERPADDING * 2, y + BORDERSIZE + BORDERPADDING * 2, TEXTCOLOUR);
    }
}
