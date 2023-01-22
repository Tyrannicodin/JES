package com.tyrannicodin.justenoughsearches;

import com.mojang.logging.LogUtils;
import com.tyrannicodin.justenoughsearches.client.config.QuickSearchConfig;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(JustEnoughSearches.MOD_ID)
public class JustEnoughSearches
{
    public static final String MOD_ID = "justenoughsearches";

    // Logger for mod
    public static final Logger LOGGER = LogUtils.getLogger();

    public JustEnoughSearches()
    {
        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, QuickSearchConfig.SPEC, "justenoughsearches-client.toml");

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }
}
