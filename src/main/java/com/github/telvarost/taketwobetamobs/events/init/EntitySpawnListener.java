package com.github.telvarost.taketwobetamobs.events.init;

import com.github.telvarost.taketwobetamobs.Config;
import com.github.telvarost.taketwobetamobs.entity.ShadowWolfEntity;
import com.github.telvarost.taketwobetamobs.enums.SpawnRegionEnum;
import net.mine_diver.unsafeevents.listener.EventListener;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.ForestBiome;
import net.minecraft.world.biome.TaigaBiome;
import net.minecraft.world.dimension.NetherDimension;
import net.minecraft.world.dimension.OverworldDimension;
import net.modificationstation.stationapi.api.event.worldgen.biome.BiomeModificationEvent;

public class EntitySpawnListener {

    @EventListener
    public void registerEntitySpawn(BiomeModificationEvent event) {
        // Check vanilla biomes first
        if  (  event.biome == Biome.RAINFOREST
            || event.biome == Biome.SWAMPLAND
            || event.biome == Biome.DESERT
            || event.biome == Biome.SAVANNA
            || event.biome == Biome.SHRUBLAND
            || event.biome == Biome.TUNDRA
            || event.biome == Biome.PLAINS
            || event.biome == Biome.ICE_DESERT
        ) {
            // Generic Vanilla Biomes
            if  (  SpawnRegionEnum.ALL_REGIONS == Config.config.spawnRegionShadowWolf
                || SpawnRegionEnum.CHUNK_SPECIFIC == Config.config.spawnRegionShadowWolf
            ) {
                event.biome.addPassiveEntity(ShadowWolfEntity.class, 2);
            }

        } else if (event.biome instanceof ForestBiome || event.biome instanceof TaigaBiome) {
            // Wolf Vanilla Biomes
            if  (  SpawnRegionEnum.ALL_REGIONS == Config.config.spawnRegionShadowWolf
                || SpawnRegionEnum.CHUNK_SPECIFIC == Config.config.spawnRegionShadowWolf
                || SpawnRegionEnum.BIOME_SPECIFIC == Config.config.spawnRegionShadowWolf
            ) {
                event.biome.addPassiveEntity(ShadowWolfEntity.class, 2);
            }

        } else if (event.biome == Biome.HELL) {
            // Other Dimension Vanilla Biomes
            if  (  SpawnRegionEnum.ALL_REGIONS == Config.config.spawnRegionShadowWolf
                || SpawnRegionEnum.CHUNK_SPECIFIC == Config.config.spawnRegionShadowWolf
                || SpawnRegionEnum.DIMENSION_SPECIFIC == Config.config.spawnRegionShadowWolf
            ) {
                event.biome.addPassiveEntity(ShadowWolfEntity.class, 2);
            }

        } else if (event.biome == Biome.SKY) {
            // Other Dimension Vanilla Biomes
            if  (  SpawnRegionEnum.ALL_REGIONS == Config.config.spawnRegionShadowWolf
                || SpawnRegionEnum.CHUNK_SPECIFIC == Config.config.spawnRegionShadowWolf
            ) {
                event.biome.addPassiveEntity(ShadowWolfEntity.class, 2);
            }

        // Check modded biomes
        } else {
            // All modded biomes
            /// Nothing for now

            if (event.world.dimension instanceof OverworldDimension) {
                // Modded Overworld Biomes
                if  (  SpawnRegionEnum.ALL_REGIONS == Config.config.spawnRegionShadowWolf
                    || SpawnRegionEnum.CHUNK_SPECIFIC == Config.config.spawnRegionShadowWolf
                ) {
                    event.biome.addPassiveEntity(ShadowWolfEntity.class, 2);
                }

            } else if (event.world.dimension instanceof NetherDimension) {
                // Modded Nether Biomes
                if  (  SpawnRegionEnum.ALL_REGIONS == Config.config.spawnRegionShadowWolf
                    || SpawnRegionEnum.CHUNK_SPECIFIC == Config.config.spawnRegionShadowWolf
                    || SpawnRegionEnum.DIMENSION_SPECIFIC == Config.config.spawnRegionShadowWolf
                ) {
                    event.biome.addPassiveEntity(ShadowWolfEntity.class, 2);
                }

            } else {
                // Modded Dimension Biomes (including vanilla sky dimension)
                return;
            }

//            // For modded biomes, don't add if it can snow there
//            if (event.biome.canSnow()) {
//                return;
//            } else {
//                return;
//            }

//            // For non vanilla biomes, check if it can rain there
//            if (event.biome.canRain()) {
//                return;
//            } else {
//                return;
//            }
        }
    }
}
