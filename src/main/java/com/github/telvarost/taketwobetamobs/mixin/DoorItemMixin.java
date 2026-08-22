//package com.github.telvarost.taketwobetamobs.mixin;
//
//import com.github.telvarost.taketwobetamobs.ParticleHelper;
//import com.github.telvarost.taketwobetamobs.retroapi.ChunkSpawnData;
//import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
//import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
//import net.minecraft.block.Block;
//import net.minecraft.block.material.Material;
//import net.minecraft.item.DoorItem;
//import net.minecraft.item.Item;
//import net.minecraft.world.World;
//import org.spongepowered.asm.mixin.Mixin;
//import org.spongepowered.asm.mixin.Shadow;
//import org.spongepowered.asm.mixin.injection.At;
//
//@Mixin(DoorItem.class)
//public abstract class DoorItemMixin extends Item {
//
//    @Shadow
//    private Material material;
//
//    public DoorItemMixin(int id) {
//        super(id);
//    }
//
//    @WrapOperation(
//            method = "useOnBlock",
//            at = @At(
//                    value = "INVOKE",
//                    target = "Lnet/minecraft/block/Block;canPlaceAt(Lnet/minecraft/world/World;III)Z"
//            )
//    )
//    public boolean takeTwoBetaMobs_canPlaceAt(Block instance, World world, int x, int y, int z, Operation<Boolean> original) {
//        if (original.call(instance, world, x, y, z)) {
//            boolean canSpawnShadowWolf = ChunkSpawnData.getCanSpawnShadowWolf(world, x, z);
//            if (canSpawnShadowWolf) {
//                ParticleHelper.spawnStructureCompleteParticles(false, world, x, y, z);
//                ParticleHelper.spawnStructureCompleteParticles(false, world, x, y + 1, z);
//            } else {
//                ParticleHelper.spawnStructureCompleteParticles(true, world, x, y, z);
//                ParticleHelper.spawnStructureCompleteParticles(true, world, x, y + 1, z);
//                ChunkSpawnData.setCanSpawnShadowWolf(world, x, z, true);
//            }
//            return true;
//        } else {
//            return false;
//        }
//    }
//}
