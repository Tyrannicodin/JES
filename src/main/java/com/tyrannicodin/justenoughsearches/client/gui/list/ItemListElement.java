package com.tyrannicodin.justenoughsearches.client.gui.list;

import com.mojang.blaze3d.vertex.PoseStack;
import com.tyrannicodin.justenoughsearches.JustEnoughSearches;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.narration.NarratedElementType;
import net.minecraft.client.gui.narration.NarrationElementOutput;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;

import java.util.List;

public class ItemListElement extends ListElement {
    private ItemStack item;

    public ItemListElement(int pX, int pY, int pWidth, int pHeight, ItemStack pitem) {
        super(pX, pY, pWidth, pHeight);
        item = pitem;
    }

    public void updateNarration(NarrationElementOutput NarratableElement) {
        NarratableElement.add(NarratedElementType.TITLE, new TranslatableComponent("Item name: ", ""));
        NarratableElement.add(NarratedElementType.HINT, new TranslatableComponent("Mod name: ", ""));
    }

    @Override
    public void render(PoseStack pPoseStack, int pMouseX, int pMouseY, float pPartialTick) {
        Minecraft.getInstance().getItemRenderer().renderAndDecorateFakeItem(item, x+2, y+2);
        Font font = Minecraft.getInstance().font;
        drawString(pPoseStack, font, item.getDisplayName(), x+20, y+height/2-font.lineHeight/2, 0xFFFFFF);
        super.render(pPoseStack, pMouseX, pMouseY, pPartialTick);
    }

    @Override
    public void renderToolTip(PoseStack pPoseStack, int pMouseX, int pMouseY) {
        super.renderToolTip(pPoseStack, pMouseX, pMouseY);
        Minecraft minecraft = Minecraft.getInstance();
        List<Component> toolText = item.getTooltipLines(minecraft.player, minecraft.options.advancedItemTooltips ? TooltipFlag.Default.ADVANCED : TooltipFlag.Default.NORMAL);

    }

    @Override
    public boolean mouseClicked(double pMouseX, double pMouseY, int pButton) {
        if (active && visible) {
            if (x < pMouseX && x+width > pMouseX && y < pMouseY && y+height > pMouseY) {
                if (pButton == 0) {
                    SearchHandler.openItem(item, false);
                } else if (pButton == 1) {
                    SearchHandler.openItem(item, true);
                }
            }
        }
        return false;
    }
}
