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
		//decorationModel = new ShadowWolfEyesEntityModel();
	}

//	protected boolean bindTexture(WolfEntity wolfEntity, int i, float f) {
//		this.setDecorationModel(new ShadowWolfEyesEntityModel());
//		return true;
//	}

	@Override
	public void render(WolfEntity livingEntity, double d, double e, double f, float g, float h) {
		GL11.glPushMatrix();
		GL11.glDisable(2884);
		this.model.handSwingProgress = this.getHandSwingProgress(livingEntity, h);
		if (this.decorationModel != null) {
			this.decorationModel.handSwingProgress = this.model.handSwingProgress;
		}

		this.model.riding = livingEntity.hasVehicle();
		if (this.decorationModel != null) {
			this.decorationModel.riding = this.model.riding;
		}

		try {
			float var10 = livingEntity.lastBodyYaw + (livingEntity.bodyYaw - livingEntity.lastBodyYaw) * h;
			float var11 = livingEntity.prevYaw + (livingEntity.yaw - livingEntity.prevYaw) * h;
			float var12 = livingEntity.prevPitch + (livingEntity.pitch - livingEntity.prevPitch) * h;
			this.applyTranslation(livingEntity, d, e, f);
			float var13 = this.getHeadBob(livingEntity, h);
			this.applyHandSwingRotation(livingEntity, var13, var10, h);
			float var14 = 0.0625F;
			GL11.glEnable(32826);
			GL11.glScalef(-1.0F, -1.0F, 1.0F);
			this.applyScale(livingEntity, h);

			// Begin transparency
			GL11.glEnable(GL11.GL_NORMALIZE);
			GL11.glEnable(GL11.GL_BLEND);
			GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);

			GL11.glTranslatef(0.0F, -24.0F * var14 - 0.0078125F, 0.0F);
			float var15 = livingEntity.lastWalkAnimationSpeed + (livingEntity.walkAnimationSpeed - livingEntity.lastWalkAnimationSpeed) * h;
			float var16 = livingEntity.walkAnimationProgress - livingEntity.walkAnimationSpeed * (1.0F - h);
			if (var15 > 1.0F) {
				var15 = 1.0F;
			}

			this.bindDownloadedTexture(livingEntity.skinUrl, livingEntity.getTexture());
			GL11.glEnable(3008);
			this.model.animateModel(livingEntity, var16, var15, h);
			this.model.render(var16, var15, var13, var11 - var10, var12, var14);

			// End transparency
			GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);

			for(int var17 = 0; var17 < 4; ++var17) {
				if (this.bindTexture(livingEntity, var17, h)) {
					this.decorationModel.render(var16, var15, var13, var11 - var10, var12, var14);
					GL11.glDisable(3042);
					GL11.glEnable(3008);
				}
			}

			this.renderMore(livingEntity, h);
			float var25 = livingEntity.getBrightnessAtEyes(h);
			int var18 = this.getOverlayColor(livingEntity, var25, h);
			if ((var18 >> 24 & 255) > 0 || livingEntity.hurtTime > 0 || livingEntity.deathTime > 0) {
				GL11.glDisable(3553);
				GL11.glDisable(3008);
				GL11.glEnable(3042);
				GL11.glBlendFunc(770, 771);
				GL11.glDepthFunc(514);
				if (livingEntity.hurtTime > 0 || livingEntity.deathTime > 0) {
					GL11.glColor4f(var25, 0.0F, 0.0F, 0.4F);
					this.model.render(var16, var15, var13, var11 - var10, var12, var14);

					for(int var19 = 0; var19 < 4; ++var19) {
						if (this.bindDecorationTexture(livingEntity, var19, h)) {
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
						if (this.bindDecorationTexture(livingEntity, var23, h)) {
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
		this.renderNameTag(livingEntity, d, e, f);
	}
}
