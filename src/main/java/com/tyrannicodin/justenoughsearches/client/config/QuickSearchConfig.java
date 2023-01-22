package com.tyrannicodin.justenoughsearches.client.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class QuickSearchConfig {
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    public static final ForgeConfigSpec.ConfigValue<Boolean> AUTOFOCUS;
    public static final ForgeConfigSpec.ConfigValue<Integer> WIDTH;
    public static final ForgeConfigSpec.ConfigValue<Integer> PADDINGX;
    public static final ForgeConfigSpec.ConfigValue<Integer> PADDINGYT;
    public static final ForgeConfigSpec.ConfigValue<Integer> PADDINGYB;
    public static final ForgeConfigSpec.ConfigValue<Integer> PADDINGTITLE;
    public static final ForgeConfigSpec.ConfigValue<Integer> PADDINGELEMENT;

    static {
        BUILDER.push("quicksearch");

            AUTOFOCUS = BUILDER.comment("Automatically focus the search box when opened")
                    .define("autofocus", true);

            WIDTH = BUILDER.comment("The gui width")
                    .define("width", 150);

            BUILDER.push("padding");

                PADDINGX = BUILDER.comment("Left gui")
                        .translation("config.justenoughsearches.test")
                        .define("x", 10);

                BUILDER.push("y");

                    PADDINGYT = BUILDER.comment("Above gui")
                            .define("top", 10);

                    PADDINGYB = BUILDER.comment("Below gui")
                            .define("bottom", 10);

                BUILDER.pop();

                PADDINGTITLE = BUILDER.comment("Below title")
                        .define("title-bottom", 2);

                PADDINGELEMENT = BUILDER.comment("Padding between elements")
                        .define("element", 2);

            BUILDER.pop();

        BUILDER.pop();
        SPEC = BUILDER.build();
    }
}
