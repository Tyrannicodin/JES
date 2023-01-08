package com.tyrannicodin.justenoughsearches.client.event;

import com.tyrannicodin.justenoughsearches.JustEnoughSearches;
import com.tyrannicodin.justenoughsearches.client.keys.KeyInit;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = JustEnoughSearches.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientModEvents {
    private ClientModEvents() {

    }

    @SubscribeEvent
    public static void clientSetup(FMLClientSetupEvent event) {
        KeyInit.init();
    }
}
