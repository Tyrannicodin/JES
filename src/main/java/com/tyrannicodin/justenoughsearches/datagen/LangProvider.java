package com.tyrannicodin.justenoughsearches.datagen;

import com.tyrannicodin.justenoughsearches.JustEnoughSearches;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.minecraftforge.common.data.LanguageProvider;

public class LangProvider extends LanguageProvider implements IConditionBuilder {
    public LangProvider(DataGenerator Generator) {
        super(Generator, JustEnoughSearches.MOD_ID, "en_us");
    }

    @Override
    public void addTranslations() {
        add("key.justenoughsearches.open_quicksearch", "Open quick search");
    }
}
