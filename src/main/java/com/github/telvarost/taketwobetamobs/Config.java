package com.github.telvarost.taketwobetamobs;

import net.glasslauncher.mods.gcapi3.api.*;

public class Config {

    @ConfigRoot(value = "config", visibleName = "TakeTwoBetaMobs")
    public static ConfigFields config = new ConfigFields();

    public static class ConfigFields {

        @ConfigCategory(
                name = "Recipe Config",
                description = "Restart required for changes to take effect"
        )
        public RecipeConfig RECIPE_CONFIG = new RecipeConfig();

//        @ConfigEntry(
//                name = "Chance On Break Soul Sand Spawns Lost Soul",
//                description = "Float value between 0.0 (0%) and 1.0 (100%)",
//                multiplayerSynced = true,
//                maxLength = 1
//        )
//        public Float chanceBreakingSoulSandSpawnsShadowWolf = 0.01F;

        @ConfigEntry(
                name = "Shadow Wolf Spawn Conditions",
                description = "What regions entity can spawn in",
                multiplayerSynced = true
        )
        public Boolean spawnRegionShadowWolf = true;
    }

    public static class RecipeConfig {

        @ConfigEntry(
                name = "Enable Locator Crafting Recipe",
                description = "Combine clock and compass to craft",
                multiplayerSynced = true
        )
        public Boolean enableLocatorCraftingRecipe = true;
    }
}
