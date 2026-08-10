package com.github.telvarost.taketwobetamobs.mixin;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Block.class)
public abstract class BlockMixin {

    @Shadow
    @Final
    public static Block PUMPKIN;

    @Shadow
    @Final
    public static Block NETHERRACK;

    @Inject(method = "onPlaced(Lnet/minecraft/world/World;III)V", at = @At("HEAD"))
    public void takeTwoBetaMobs_onPlaced(World world, int x, int y, int z, CallbackInfo ci) {
        /* Open mixin inheritance */
    }
}
