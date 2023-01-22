package com.tyrannicodin.justenoughsearches.client.gui.list;

import com.tyrannicodin.justenoughsearches.JustEnoughSearches;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.recipe.IFocusFactory;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.runtime.IIngredientFilter;
import mezz.jei.api.runtime.IJeiRuntime;
import mezz.jei.api.runtime.IRecipesGui;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

import java.util.List;

@JeiPlugin
public class SearchHandler implements IModPlugin {
    private static SearchHandler instance;
    private IIngredientFilter ingredientFilter;
    private IFocusFactory focusFactory;
    private IRecipesGui recipesGui;

    public SearchHandler() {
        instance = this;
    }

    @Override
    public ResourceLocation getPluginUid() {
        return new ResourceLocation(JustEnoughSearches.MOD_ID);
    }

    @Override
    public void onRuntimeAvailable(IJeiRuntime jeiRuntime) {
        ingredientFilter = jeiRuntime.getIngredientFilter();
        recipesGui = jeiRuntime.getRecipesGui();
        focusFactory = jeiRuntime.getJeiHelpers().getFocusFactory();
    }

    public static List<ItemStack> searchItems(String searchTerm) {
        instance.ingredientFilter.setFilterText(searchTerm);
        return instance.ingredientFilter.getFilteredIngredients(VanillaTypes.ITEM_STACK);
    }

    public static SearchHandler getInstance() {
        return instance;
    }

    public static void openItem(ItemStack item, boolean isInput) {
        instance.recipesGui.show(instance.focusFactory.createFocus(isInput ? RecipeIngredientRole.INPUT : RecipeIngredientRole.OUTPUT, VanillaTypes.ITEM_STACK, item));
    }
}
