package com.github.telvarost.taketwobetamobs.entity;

import com.github.telvarost.taketwobetamobs.TakeTwoBetaMobs;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.entity.Monster;
import net.minecraft.entity.passive.WolfEntity;
import net.minecraft.world.World;
import net.modificationstation.stationapi.api.server.entity.HasTrackingParameters;
import net.modificationstation.stationapi.api.server.entity.MobSpawnDataProvider;
import net.modificationstation.stationapi.api.util.Identifier;
import net.modificationstation.stationapi.api.util.TriState;

@HasTrackingParameters(updatePeriod = 2, sendVelocity = TriState.TRUE, trackingDistance = 30)
public class ShadowWolfEntity extends WolfEntity implements Monster, MobSpawnDataProvider {

	@Override
	public Identifier getHandlerIdentifier()
	{
		return Identifier.of(TakeTwoBetaMobs.TAKE_TWO_BETA_MOBS, "ShadowWolf");
	}

	public ShadowWolfEntity(World world) {
		super(world);
		this.texture = "/assets/taketwobetamobs/stationapi/textures/entity/shadowwolf.png";
		this.setBoundingBoxSpacing(0.8F, 0.8F);
		this.fireImmune = true;
		this.movementSpeed = 1.1F;
		this.health = 8;
	}

	@Override
	@Environment(EnvType.CLIENT)
	public String getTexture() {
		if (this.isTamed()) {
			return "/assets/taketwobetamobs/stationapi/textures/entity/shadowwolf.png";
		} else {
			return this.isAngry() ? "/assets/taketwobetamobs/stationapi/textures/entity/shadowwolf.png" : super.getTexture();
		}
	}

	@Override
	protected String getDeathSound() {
		return "taketwobetamobs:entity.shadowwolf.death";
	}
}
