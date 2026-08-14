package com.github.telvarost.taketwobetamobs.entity;

import com.github.telvarost.taketwobetamobs.EntitySpawningInterface;
import com.github.telvarost.taketwobetamobs.TakeTwoBetaMobs;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.Block;
import net.minecraft.entity.Monster;
import net.minecraft.entity.passive.WolfEntity;
import net.minecraft.util.math.MathHelper;
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
			return this.isAngry() ? "/assets/taketwobetamobs/stationapi/textures/entity/shadowwolf_angry.png" : super.getTexture();
		}
	}

	@Override
	protected String getDeathSound() {
		return "taketwobetamobs:entity.shadowwolf.death";
	}

	@Override
	public boolean canSpawn() {
		int xCoord = MathHelper.floor(this.x);
		int yCoord = MathHelper.floor(this.boundingBox.minY);
		int zCoord = MathHelper.floor(this.z);
		EntitySpawningInterface entitySpawningInterface = (EntitySpawningInterface)this.world.getChunkFromPos(xCoord, zCoord);
		//System.out.println("Chunk: " + xCoord + "," + yCoord + " SWS:" + entitySpawningInterface.entitySpawning_getCanSpawnShadowWolf());
		int blockId = this.world.getBlockId(xCoord, yCoord - 1, zCoord);
		return (  this.world.difficulty > 0
			   && (blockId == Block.GRASS_BLOCK.id || blockId == Block.NETHERRACK.id)
			   && this.world.getBrightness(xCoord, yCoord, zCoord) <= 8
			   && entitySpawningInterface.entitySpawning_getCanSpawnShadowWolf()
			   && super.canSpawn()
		       );
	}
}
