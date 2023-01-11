package com.tyrannicodin.justenoughsearches.client.gui.list;

import net.minecraft.client.gui.narration.NarratedElementType;
import net.minecraft.client.gui.narration.NarrationElementOutput;
import net.minecraft.network.chat.TranslatableComponent;

public class ItemListElement extends ListElement{
    public ItemListElement(int pX, int pY, int pWidth) {
        super(pX, pY, pWidth);
    }

    public void updateNarration(NarrationElementOutput NarratableElement) {
        NarratableElement.add(NarratedElementType.TITLE, new TranslatableComponent("Item name: ", ""));
        NarratableElement.add(NarratedElementType.HINT, new TranslatableComponent("Mod name: ", ""));
    }
}
