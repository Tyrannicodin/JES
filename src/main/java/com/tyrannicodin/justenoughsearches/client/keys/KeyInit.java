package com.tyrannicodin.justenoughsearches.client.keys;

import com.mojang.blaze3d.platform.InputConstants;
import com.tyrannicodin.justenoughsearches.JustEnoughSearches;
import net.minecraft.client.KeyMapping;
import net.minecraftforge.client.ClientRegistry;

public final class KeyInit {
    private KeyInit() {}

    public static KeyMapping quicksearchKeyMapping;

    public static void init() {
        quicksearchKeyMapping = registerKey("open_quicksearch", KeyMapping.CATEGORY_INTERFACE, InputConstants.KEY_GRAVE);
    }

    private static KeyMapping registerKey(String name, String category, int keycode) {
        final var key = new KeyMapping("key." + JustEnoughSearches.MOD_ID + "." + name, keycode, category);
        ClientRegistry.registerKeyBinding(key);
        return key;
    }
}
