package com.github.telvarost.taketwobetamobs;

import com.github.telvarost.taketwobetamobs.enums.SpawnRegionEnum;
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

        @ConfigCategory(
                name = "Spawn Rules Config",
                description = "Restart required for changes to take effect"
        )
        public SpawnRulesConfig SPAWN_RULES_CONFIG = new SpawnRulesConfig();

//        @ConfigEntry(
//                name = "Chance On Break Soul Sand Spawns Lost Soul",
//                description = "Float value between 0.0 (0%) and 1.0 (100%)",
//                multiplayerSynced = true,
//                maxLength = 1
//        )
//        public Float chanceBreakingSoulSandSpawnsShadowWolf = 0.01F;
    }

    public static class RecipeConfig {

        @ConfigEntry(
                name = "Enable Locator Crafting Recipe",
                description = "Combine clock and compass to craft",
                multiplayerSynced = true
        )
        public Boolean enableLocatorCraftingRecipe = true;
    }

    public static class SpawnRulesConfig {

        @ConfigEntry(
                name = "Shadow Wolf Spawn Region",
                description = "Chunk specific option requires RetroAPI",
                multiplayerSynced = true
        )
        public SpawnRegionEnum spawnRegionShadowWolf = SpawnRegionEnum.BIOME_SPECIFIC;

        @ConfigEntry(
                name = "Ore Boar Spawn Region",
                description = "Chunk specific option requires RetroAPI",
                multiplayerSynced = true
        )
        public SpawnRegionEnum spawnRegionOreBoar = SpawnRegionEnum.BIOME_SPECIFIC;
    }
}
