package com.tyrannicodin.justenoughsearches.client.gui.list;

import com.tyrannicodin.justenoughsearches.JustEnoughSearches;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.ingredients.IIngredientType;
import mezz.jei.api.runtime.IIngredientFilter;
import mezz.jei.api.runtime.IJeiRuntime;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

import java.util.List;

@JeiPlugin
public class searchHandler implements IModPlugin {
    private static searchHandler instance;
    private IIngredientFilter ingredientFilter;

    public searchHandler() {
        instance = this;
    }

    @Override
    public ResourceLocation getPluginUid() {
        return new ResourceLocation(JustEnoughSearches.MOD_ID);
    }

    @Override
    public void onRuntimeAvailable(IJeiRuntime jeiRuntime) {
        ingredientFilter = jeiRuntime.getIngredientFilter();
    }

    public static List<ItemStack> searchItems(String searchTerm) {
        instance.ingredientFilter.setFilterText(searchTerm);
        return instance.ingredientFilter.getFilteredIngredients(VanillaTypes.ITEM_STACK);
    }

    public static searchHandler getInstance() {
        return instance;
    }
}
