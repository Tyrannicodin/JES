package com.tyrannicodin.justenoughsearches.client.gui.list;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.components.AbstractWidget;
import net.minecraft.client.gui.narration.NarratedElementType;
import net.minecraft.client.gui.narration.NarrationElementOutput;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.TranslatableComponent;

public class ListElement extends AbstractWidget {
    //Will be replaced with configs
    protected final int DARKCOLOUR = 0x000030;
    protected final int LIGHTCOLOUR = 0x000080;
    protected final int TEXTCOLOUR = 0xF0F0F0;
    protected final int BORDERPADDING = 1;
    protected final int BORDERSIZE = 1;
    protected final Font font = Minecraft.getInstance().font;

    public ListElement(int pX, int pY) {
        super(pX, pY, 0, 0, new TextComponent(""));
        int height = font.lineHeight + BORDERPADDING * 4 + BORDERSIZE * 2;
        setHeight(height);
        int width = 0;
    }

    public void updateNarration(NarrationElementOutput NarratableElement){
        NarratableElement.add(NarratedElementType.TITLE, new TranslatableComponent("Item name: ", ""));
        NarratableElement.add(NarratedElementType.HINT, new TranslatableComponent("Mod name: ", ""));
    }

    @Override
    public void render(PoseStack pPoseStack, int pMouseX, int pMouseY, float pPartialTick) {
        super.render(pPoseStack, pMouseX, pMouseY, pPartialTick);

        //Drawing bg
        if (!isHovered) {
            fill(pPoseStack, x, y, x+getWidth(), x+getWidth(), DARKCOLOUR);
        } else {
            fill(pPoseStack, x, y, x+getWidth(), x+getWidth(), TEXTCOLOUR);
        }
        fill(pPoseStack, x+1, y+1, x+getWidth()-1, x+getWidth()-1, LIGHTCOLOUR);
        fill(pPoseStack, x+2, y+2, x+getWidth()-2, x+getWidth()-2, DARKCOLOUR);
    }
}