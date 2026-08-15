package com.github.telvarost.taketwobetamobs.entity;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.WolfEntityRenderer;
import net.minecraft.entity.passive.WolfEntity;
import org.lwjgl.opengl.GL11;

@Environment(EnvType.CLIENT)
public class ShadowWolfEntityRenderer extends WolfEntityRenderer {

	public ShadowWolfEntityRenderer() {
		super(new ShadowWolfEntityModel(), 0.5F);
		this.setDecorationModel(new ShadowWolfEntityModel());
	}

	protected boolean bindTexture(WolfEntity wolfEntity, int i, float f) {
		if (i != 0) {
			return false;
		} else {
			if (wolfEntity.isAngry()) {
				this.bindTexture("/assets/taketwobetamobs/stationapi/textures/entity/shadowwolf_angry_eyes.png");
				float var4 = (1.0F - wolfEntity.getBrightnessAtEyes(1.0F)) * 0.5F;
				GL11.glEnable(3042);
				GL11.glDisable(3008);
				GL11.glBlendFunc(770, 771);
				GL11.glColor4f(1.0F, 1.0F, 1.0F, var4);
				return true;
			} else if (wolfEntity.isTamed()) {
				this.bindTexture("/assets/taketwobetamobs/stationapi/textures/entity/shadowwolf_eyes.png");
				float var4 = (1.0F - wolfEntity.getBrightnessAtEyes(1.0F)) * 0.5F;
				GL11.glEnable(3042);
				GL11.glDisable(3008);
				GL11.glBlendFunc(770, 771);
				GL11.glColor4f(1.0F, 1.0F, 1.0F, var4);
				return true;
			} else {
				this.bindTexture("/assets/taketwobetamobs/stationapi/textures/entity/shadowwolf_untamed_eyes.png");
				GL11.glEnable(3042);
				GL11.glDisable(3008);
				GL11.glBlendFunc(770, 771);
				GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0f);
				return true;
			}
		}
	}

	@Override
	public void render(WolfEntity wolfEntity, double d, double e, double f, float g, float h) {
		GL11.glPushMatrix();
		GL11.glDisable(2884);
		this.model.handSwingProgress = this.getHandSwingProgress(wolfEntity, h);
		if (this.decorationModel != null) {
			this.decorationModel.handSwingProgress = this.model.handSwingProgress;
		}

		this.model.riding = wolfEntity.hasVehicle();
		if (this.decorationModel != null) {
			this.decorationModel.riding = this.model.riding;
		}

		try {
			float var10 = wolfEntity.lastBodyYaw + (wolfEntity.bodyYaw - wolfEntity.lastBodyYaw) * h;
			float var11 = wolfEntity.prevYaw + (wolfEntity.yaw - wolfEntity.prevYaw) * h;
			float var12 = wolfEntity.prevPitch + (wolfEntity.pitch - wolfEntity.prevPitch) * h;
			this.applyTranslation(wolfEntity, d, e, f);
			float var13 = this.getHeadBob(wolfEntity, h);
			this.applyHandSwingRotation(wolfEntity, var13, var10, h);
			float var14 = 0.0625F;
			GL11.glEnable(32826);
			GL11.glScalef(-1.0F, -1.0F, 1.0F);
			this.applyScale(wolfEntity, h);

			// Begin transparency
			GL11.glEnable(GL11.GL_NORMALIZE);
			GL11.glEnable(GL11.GL_BLEND);
			GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);

			GL11.glTranslatef(0.0F, -24.0F * var14 - 0.0078125F, 0.0F);
			float var15 = wolfEntity.lastWalkAnimationSpeed + (wolfEntity.walkAnimationSpeed - wolfEntity.lastWalkAnimationSpeed) * h;
			float var16 = wolfEntity.walkAnimationProgress - wolfEntity.walkAnimationSpeed * (1.0F - h);
			if (var15 > 1.0F) {
				var15 = 1.0F;
			}

			this.bindDownloadedTexture(wolfEntity.skinUrl, wolfEntity.getTexture());
			GL11.glEnable(3008);
			this.model.animateModel(wolfEntity, var16, var15, h);
			float var7 = wolfEntity.getBrightnessAtEyes(h) * wolfEntity.getFurBrightnessMultiplier(h);
			GL11.glColor4f(var7, var7, var7, 0.75f);
			this.model.render(var16, var15, var13, var11 - var10, var12, var14);

			// End transparency
			GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);

			for(int var17 = 0; var17 < 4; ++var17) {
				if (this.bindTexture(wolfEntity, var17, h)) {
					this.decorationModel.animateModel(wolfEntity, var16, var15, h);
					this.decorationModel.render(var16, var15, var13, var11 - var10, var12, var14);
					GL11.glDisable(3042);
					GL11.glEnable(3008);
				}
			}

			this.renderMore(wolfEntity, h);
			float var25 = wolfEntity.getBrightnessAtEyes(h);
			int var18 = this.getOverlayColor(wolfEntity, var25, h);
			if ((var18 >> 24 & 255) > 0 || wolfEntity.hurtTime > 0 || wolfEntity.deathTime > 0) {
				GL11.glDisable(3553);
				GL11.glDisable(3008);
				GL11.glEnable(3042);
				GL11.glBlendFunc(770, 771);
				GL11.glDepthFunc(514);
				if (wolfEntity.hurtTime > 0 || wolfEntity.deathTime > 0) {
					GL11.glColor4f(var25, 0.0F, 0.0F, 0.4F);
					this.model.render(var16, var15, var13, var11 - var10, var12, var14);

					for(int var19 = 0; var19 < 4; ++var19) {
						if (this.bindDecorationTexture(wolfEntity, var19, h)) {
							GL11.glColor4f(var25, 0.0F, 0.0F, 0.4F);
							this.decorationModel.render(var16, var15, var13, var11 - var10, var12, var14);
						}
					}
				}

				if ((var18 >> 24 & 255) > 0) {
					float var26 = (float)(var18 >> 16 & 255) / 255.0F;
					float var20 = (float)(var18 >> 8 & 255) / 255.0F;
					float var21 = (float)(var18 & 255) / 255.0F;
					float var22 = (float)(var18 >> 24 & 255) / 255.0F;
					GL11.glColor4f(var26, var20, var21, var22);
					this.model.render(var16, var15, var13, var11 - var10, var12, var14);

					for(int var23 = 0; var23 < 4; ++var23) {
						if (this.bindDecorationTexture(wolfEntity, var23, h)) {
							GL11.glColor4f(var26, var20, var21, var22);
							this.decorationModel.render(var16, var15, var13, var11 - var10, var12, var14);
						}
					}
				}

				GL11.glDepthFunc(515);
				GL11.glDisable(3042);
				GL11.glEnable(3008);
				GL11.glEnable(3553);
			}

			GL11.glDisable(32826);
		} catch (Exception var24) {
			var24.printStackTrace();
		}

		GL11.glEnable(2884);
		GL11.glPopMatrix();
		this.renderNameTag(wolfEntity, d, e, f);
	}
}
