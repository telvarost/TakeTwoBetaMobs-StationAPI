package com.github.telvarost.taketwobetamobs;

import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.world.World;

/**
 * Per-chunk spawn flags, persisted by RetroAPI's chunk NBT storage.
 * RetroAPI is optional: without it nothing is stored and chunk specific
 * spawning stays off.
 */
public class ChunkSpawnData {

    private static final boolean RETRO_API = FabricLoader.getInstance().isModLoaded("retroapi");

    private static final String CAN_SPAWN_SHADOW_WOLF = "taketwobetamobs:canSpawnShadowWolf";

    public static boolean getCanSpawnShadowWolf(World world, int x, int z) {
        return RETRO_API && Impl.get(world, x >> 4, z >> 4, CAN_SPAWN_SHADOW_WOLF);
    }

    public static void setCanSpawnShadowWolf(World world, int x, int z, boolean canSpawn) {
        if (RETRO_API) {
            Impl.set(world, x >> 4, z >> 4, CAN_SPAWN_SHADOW_WOLF, canSpawn);
        }
    }

    /** Holder class so RetroAPI classes are only loaded when RetroAPI is actually installed. */
    private static class Impl {
        static boolean get(World world, int chunkX, int chunkZ, String key) {
            return com.periut.retroapi.storage.RetroData.chunk(world, chunkX, chunkZ).getBoolean(key);
        }

        static void set(World world, int chunkX, int chunkZ, String key, boolean value) {
            com.periut.retroapi.storage.RetroData.chunk(world, chunkX, chunkZ).putBoolean(key, value);
        }
    }
}
