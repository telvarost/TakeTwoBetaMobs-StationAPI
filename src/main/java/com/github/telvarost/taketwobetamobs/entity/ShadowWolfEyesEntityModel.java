//package com.github.telvarost.taketwobetamobs.entity;
//
//import net.fabricmc.api.EnvType;
//import net.fabricmc.api.Environment;
//import net.minecraft.client.model.ModelPart;
//import net.minecraft.client.render.entity.model.EntityModel;
//import net.minecraft.entity.LivingEntity;
//import net.minecraft.entity.passive.WolfEntity;
//import net.minecraft.util.math.MathHelper;
//import org.lwjgl.opengl.GL11;
//
//@Environment(EnvType.CLIENT)
//public class ShadowWolfEyesEntityModel extends EntityModel {
//    public ModelPart head;
//
//    public ShadowWolfEyesEntityModel() {
//        float var1 = 0.0F;
//        float var2 = 13.5F;
//        this.head = new ModelPart(0, 0);
//        this.head.addCuboid(-3.0F, -3.0F, -2.0F, 6, 6, 4, var1);
//        this.head.setPivot(-1.0F, var2, -7.0F);
//    }
//
//    public void render(float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch, float scale) {
//        super.render(limbAngle, limbDistance, animationProgress, headYaw, headPitch, scale);
//        this.setAngles(limbAngle, limbDistance, animationProgress, headYaw, headPitch, scale);
//        this.head.renderForceTransform(scale);
//    }
//
//    public void animateModel(LivingEntity entity, float limbAngle, float limbDistance, float tickDelta) {
//        WolfEntity var5 = (WolfEntity)entity;
//
//        float var6 = var5.getBegAnimationProgress(tickDelta) + var5.getShakeAnimationProgress(tickDelta, 0.0F);
//        this.head.roll = var6;
//        float var7 = var5.getBrightnessAtEyes(tickDelta) * var5.getFurBrightnessMultiplier(tickDelta);
//        GL11.glColor4f(var7, var7, var7, 1.0f);
//
//    }
//
//    public void setAngles(float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch, float scale) {
//        super.setAngles(limbAngle, limbDistance, animationProgress, headYaw, headPitch, scale);
//        this.head.pitch = headPitch / (180F / (float)Math.PI);
//        this.head.yaw = headYaw / (180F / (float)Math.PI);
//    }
//}
