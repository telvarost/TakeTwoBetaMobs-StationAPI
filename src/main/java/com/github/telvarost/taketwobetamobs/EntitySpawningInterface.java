package com.github.telvarost.taketwobetamobs;

import net.modificationstation.stationapi.api.util.Util;

public interface EntitySpawningInterface {
    default Boolean entitySpawning_getCanSpawnShadowWolf() {
        return Util.assertImpl();
    }

    default void entitySpawning_setCanSpawnShadowWolf(Boolean canSpawnShadowWolf) {
        Util.assertImpl();
    }
}