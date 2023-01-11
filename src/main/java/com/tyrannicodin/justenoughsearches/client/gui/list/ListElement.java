package com.tyrannicodin.justenoughsearches.client.gui.list;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.logging.LogUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.components.AbstractWidget;
import net.minecraft.client.gui.narration.NarratedElementType;
import net.minecraft.client.gui.narration.NarrationElementOutput;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.TranslatableComponent;
import org.slf4j.Logger;

public abstract class ListElement extends AbstractWidget {
    //Will be replaced with configs
    protected final int DARKCOLOUR = 0x000030;
    protected final int LIGHTCOLOUR = 0x000080;
    protected final int TEXTCOLOUR = 0xF0F0F0;
    protected final Font font = Minecraft.getInstance().font;

    public double Result;

    private static final Logger LOGGER = LogUtils.getLogger();

    public ListElement(int pX, int pY, int pWidth) {
        super(pX, pY, pWidth, 16, new TextComponent(""));
    }

    public boolean isEquation() {return false;}
}