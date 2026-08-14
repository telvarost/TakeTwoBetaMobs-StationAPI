//package com.github.telvarost.taketwobetamobs.mixin;
//
//import net.minecraft.world.World;
//import net.minecraft.world.chunk.Chunk;
//import net.minecraft.world.chunk.storage.AlphaChunkStorage;
//import org.spongepowered.asm.mixin.Mixin;
//import org.spongepowered.asm.mixin.injection.At;
//import org.spongepowered.asm.mixin.injection.Inject;
//import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
//import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
//
//@Mixin(AlphaChunkStorage.class)
//public abstract class AlphaChunkStorageMixin {
//
//    @Inject(method = "saveChunk", at = @At("HEAD"))
//    public void takeTwoBetaMobs_saveChunk(World world, Chunk chunk, CallbackInfo ci) {
//        /* Open mixin inheritance */
//    }
//
//    @Inject(method = "loadChunk", at = @At("HEAD"))
//    public void takeTwoBetaMobs_loadChunk(World world, int chunkX, int chunkZ, CallbackInfoReturnable<Chunk> cir) {
//        /* Open mixin inheritance */
//    }
//}
