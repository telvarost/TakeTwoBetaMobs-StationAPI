package com.github.telvarost.taketwobetamobs.mixin;

import com.github.telvarost.taketwobetamobs.EntitySpawningInterface;
import net.minecraft.world.chunk.Chunk;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

@Mixin(Chunk.class)
public abstract class ChunkMixin implements EntitySpawningInterface {

    @Unique
    public boolean _canSpawnShadowWolf = false;

    @Override
    public Boolean entitySpawning_getCanSpawnShadowWolf() {
        return _canSpawnShadowWolf;
    }

    @Override
    public void entitySpawning_setCanSpawnShadowWolf(Boolean canSpawnShadowWolf) {
        _canSpawnShadowWolf = canSpawnShadowWolf;
    }
}
