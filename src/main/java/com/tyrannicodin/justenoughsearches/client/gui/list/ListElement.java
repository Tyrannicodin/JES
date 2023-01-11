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
    public double Result;

    public ListElement(int pX, int pY, int pWidth, int pHeight) {
        super(pX, pY, pWidth, pHeight, new TextComponent(""));
    }

    public boolean isEquation() {return false;}
}