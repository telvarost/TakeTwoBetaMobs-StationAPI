package com.github.telvarost.taketwobetamobs.mixin;

import com.github.telvarost.taketwobetamobs.EntitySpawningInterface;
import net.minecraft.block.SaplingBlock;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(SaplingBlock.class)
public abstract class SaplingBlockMixin extends BlockMixin {

    @Override
    public void takeTwoBetaMobs_onPlaced(World world, int x, int y, int z, CallbackInfo ci) {
        int blockMeta = world.getBlockMeta(x, y, z);

        if (1 == blockMeta) {
            if (  NETHERRACK.id == world.getBlockId(x+1, y-1, z)
               && NETHERRACK.id == world.getBlockId(x-1, y-1, z)
               && NETHERRACK.id == world.getBlockId(x, y-1, z+1)
               && NETHERRACK.id == world.getBlockId(x, y-1, z-1)
            ) {
                EntitySpawningInterface entitySpawningInterface = (EntitySpawningInterface)world.getChunk(x >> 4, z >> 4);
                //System.out.println("Can spawn? " + entitySpawningInterface.entitySpawning_getCanSpawnShadowWolf());
                entitySpawningInterface.entitySpawning_setCanSpawnShadowWolf(true);
            }
        }
    }
}
