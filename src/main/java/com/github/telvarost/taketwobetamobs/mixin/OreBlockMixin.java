//package com.github.telvarost.taketwobetamobs.mixin;
//
//import com.github.telvarost.taketwobetamobs.ParticleHelper;
//import com.github.telvarost.taketwobetamobs.retroapi.ChunkSpawnData;
//import net.minecraft.block.OreBlock;
//import net.minecraft.world.World;
//import org.spongepowered.asm.mixin.Mixin;
//import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
//
//@Mixin(OreBlock.class)
//public abstract class OreBlockMixin extends BlockMixin {
//
//    @Override
//    public void takeTwoBetaMobs_onPlaced(World world, int x, int y, int z, CallbackInfo ci) {
//        if (  COAL_ORE.id == world.getBlockId(x+1, y, z)
//           && COAL_ORE.id == world.getBlockId(x-1, y, z)
//           && COAL_ORE.id == world.getBlockId(x, y, z+1)
//           && COAL_ORE.id == world.getBlockId(x, y, z-1)
//        ) {
//            boolean canSpawnShadowWolf = ChunkSpawnData.getCanSpawnShadowWolf(world, x, z);
//            if (canSpawnShadowWolf) {
//                ParticleHelper.spawnStructureCompleteParticles(false, world, x, y, z);
//            } else {
//                ParticleHelper.spawnStructureCompleteParticles(true, world, x, y, z);
//                ChunkSpawnData.setCanSpawnShadowWolf(world, x, z, true);
//            }
//        }
//    }
//}
