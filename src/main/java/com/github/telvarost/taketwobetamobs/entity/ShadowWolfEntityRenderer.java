package com.github.telvarost.taketwobetamobs.entity;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.WolfEntityRenderer;
import net.minecraft.client.render.entity.model.WolfEntityModel;

@Environment(EnvType.CLIENT)
public class ShadowWolfEntityRenderer extends WolfEntityRenderer {

	public ShadowWolfEntityRenderer() {
		super(new WolfEntityModel(), 0.5F);
	}
}
