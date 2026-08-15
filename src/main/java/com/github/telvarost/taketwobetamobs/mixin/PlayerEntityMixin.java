package com.github.telvarost.taketwobetamobs.mixin;

import com.github.telvarost.taketwobetamobs.entity.ShadowWolfEntity;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.PigZombieEntity;
import net.minecraft.entity.passive.PigEntity;
import net.minecraft.entity.passive.WolfEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.Box;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerEntity.class)
public abstract class PlayerEntityMixin extends LivingEntity {

    @Shadow
    protected abstract boolean isPvpEnabled();

    @Shadow
    public String name;

    public PlayerEntityMixin(World world) {
        super(world);
    }

    @Inject(method = "commandWolvesToAttack", at = @At("HEAD"))
    protected void commandWolvesToAttack(LivingEntity entity, boolean sitting, CallbackInfo ci) {
        commandShadowWolvesToAttack(entity, sitting);
    }

    @Unique
    protected void commandShadowWolvesToAttack(LivingEntity entity, boolean sitting) {
        if  (  entity instanceof ShadowWolfEntity
            || entity instanceof PlayerEntity
            || entity instanceof PigZombieEntity
            || entity instanceof PigEntity
        ) {
            if (!(entity instanceof PlayerEntity) || this.isPvpEnabled()) {
                for(Object var5 : this.world.collectEntitiesByClass(ShadowWolfEntity.class, Box.createCached(this.x, this.y, this.z, this.x + (double)1.0F, this.y + (double)1.0F, this.z + (double)1.0F).expand((double)16.0F, (double)4.0F, (double)16.0F))) {
                    ShadowWolfEntity var6 = (ShadowWolfEntity)var5;
                    if (var6.isTamed() && var6.getTarget() == null && this.name.equals(var6.getOwnerName()) && (!sitting || !var6.isInSittingPose())) {
                        var6.setSitting(false);
                        var6.setTarget(entity);
                    }
                }
            }
        }
    }

    @WrapOperation(
            method = "commandWolvesToAttack",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/entity/passive/WolfEntity;isTamed()Z",
                    ordinal = 1
            )
    )
    public boolean takeTwoBetaMobs_isTamed(WolfEntity instance, Operation<Boolean> original) {
        if (instance instanceof ShadowWolfEntity) {
            return false;
        } else {
            return original.call(instance);
        }
    }
}
