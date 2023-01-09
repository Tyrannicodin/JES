package com.tyrannicodin.justenoughsearches.client.event;

import com.tyrannicodin.justenoughsearches.JustEnoughSearches;
import com.tyrannicodin.justenoughsearches.client.gui.QuickSearch;
import com.tyrannicodin.justenoughsearches.client.keys.KeyInit;
import net.minecraft.client.Minecraft;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = JustEnoughSearches.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class ClientForgeEvents {
    private ClientForgeEvents() {

    }

    @SubscribeEvent
    public static void clientTick(TickEvent.ClientTickEvent event) {
        var player = Minecraft.getInstance().player;
        if (KeyInit.quicksearchKeyMapping.consumeClick()) {
            Minecraft.getInstance().setScreen(new QuickSearch(""));
        }
    }
}
