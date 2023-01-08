package com.tyrannicodin.justenoughsearches.datagen;

import com.tyrannicodin.justenoughsearches.JustEnoughSearches;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;

@Mod.EventBusSubscriber(modid = JustEnoughSearches.MOD_ID, bus=Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        ExistingFileHelper FileHelper = event.getExistingFileHelper();

        generator.addProvider(new LangProvider(generator));
    }

}
