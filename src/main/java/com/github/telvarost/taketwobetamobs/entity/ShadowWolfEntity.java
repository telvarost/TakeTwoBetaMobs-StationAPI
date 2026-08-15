package com.github.telvarost.taketwobetamobs.entity;

import com.github.telvarost.taketwobetamobs.Config;
import com.github.telvarost.taketwobetamobs.EntitySpawningInterface;
import com.github.telvarost.taketwobetamobs.TakeTwoBetaMobs;
import com.github.telvarost.taketwobetamobs.enums.SpawnRegionEnum;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.Monster;
import net.minecraft.entity.ai.pathing.Path;
import net.minecraft.entity.passive.PigEntity;
import net.minecraft.entity.passive.WolfEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.FoodItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.dimension.NetherDimension;
import net.modificationstation.stationapi.api.server.entity.HasTrackingParameters;
import net.modificationstation.stationapi.api.server.entity.MobSpawnDataProvider;
import net.modificationstation.stationapi.api.util.Identifier;
import net.modificationstation.stationapi.api.util.TriState;

import java.util.ArrayList;
import java.util.List;

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
		this.health = 16;
	}

	@Override
	public boolean canBreatheInWater() {
		return true;
	}

	@Override
	protected void onLanding(float fallDistance) {
		// Disable fall damage
	}

	@Override
	public boolean isInsideWall() {
		// Disable suffocation
		return false;
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
			   && (  SpawnRegionEnum.CHUNK_SPECIFIC != Config.config.spawnRegionShadowWolf
			      || entitySpawningInterface.entitySpawning_getCanSpawnShadowWolf()
		          )
			   && super.canSpawn()
		       );
	}

	@Override
	protected Entity getTargetInRange() {
		if (this.isAngry()) {
			return this.world.getClosestPlayer(this, (double)16.0F);
		} else if (this.world.dimension instanceof NetherDimension && (this.getOwnerName() == null || this.getOwnerName().isBlank())) {
			this.setAngry(true);
			return this.world.getClosestPlayer(this, (double)16.0F);
		} else {
			return null;
		}
	}

	@Override
	protected void tickLiving() {
		super.tickLiving();
		if (!this.movementBlocked && !this.hasPath() && this.isTamed() && this.vehicle == null) {
			PlayerEntity var3 = this.world.getPlayer(this.getOwnerName());
			if (var3 == null && !this.isSubmergedInWater()) {
				this.setSitting(true);
			}
		} else if (this.target == null && !this.hasPath() && !this.isTamed() && this.world.random.nextInt(100) == 0) {
			List<Object> masterList = new ArrayList<>();
			masterList.addAll(this.world.collectEntitiesByClass(PigEntity.class, Box.createCached(this.x, this.y, this.z, this.x + (double)1.0F, this.y + (double)1.0F, this.z + (double)1.0F).expand((double)16.0F, (double)4.0F, (double)16.0F)));
			//masterList.addAll(this.world.collectEntitiesByClass(PigZombieEntity.class, Box.createCached(this.x, this.y, this.z, this.x + (double)1.0F, this.y + (double)1.0F, this.z + (double)1.0F).expand((double)16.0F, (double)4.0F, (double)16.0F)));
			if (!masterList.isEmpty()) {
				this.setTarget((Entity)masterList.get(this.world.random.nextInt(masterList.size())));
			}
		}

		if (!this.world.isRemote) {
			this.dataTracker.set(18, this.health);
		}
	}

	@Override
	public void tickMovement() {
		super.tickMovement();
		this.begging = false;
		if (this.hasLookTarget() && !this.hasPath() && !this.isAngry()) {
			Entity var1 = this.getLookTarget();
			if (var1 instanceof PlayerEntity) {
				PlayerEntity var2 = (PlayerEntity)var1;
				ItemStack var3 = var2.inventory.getSelectedItem();
				if (var3 != null) {
					if (!this.isTamed() && var3.itemId == Item.COAL.id && var3.getDamage() == 1) {
						this.begging = true;
					} else if (this.isTamed() && Item.ITEMS[var3.itemId] instanceof FoodItem) {
						this.begging = ((FoodItem)Item.ITEMS[var3.itemId]).isMeat();
					}
				}
			}
		}

		if (!this.interpolateOnly && this.furWet && !this.shakingWaterOff && !this.hasPath() && this.onGround) {
			this.shakingWaterOff = true;
			this.shakeProgress = 0.0F;
			this.lastShakeProgress = 0.0F;
			this.world.broadcastEntityEvent(this, (byte)8);
		}
	}

	@Override
	public boolean interact(PlayerEntity player) {
		ItemStack stack = player.inventory.getSelectedItem();
		if (!this.isTamed()) {
			if (stack != null && stack.itemId == Item.COAL.id && stack.getDamage() == 1) {
				--stack.count;
				if (stack.count <= 0) {
					player.inventory.setStack(player.inventory.selectedSlot, (ItemStack)null);
				}

				if (!this.world.isRemote) {
					if (this.random.nextInt(3) == 0) {
						this.setAngry(false);
						this.setTarget(null);
						this.setTamed(true);
						this.setPath((Path)null);
						this.setSitting(true);
						this.health = 20;
						this.setOwnerName(player.name);
						this.showFeedParticles(true);
						this.world.broadcastEntityEvent(this, (byte)7);
					} else {
						this.showFeedParticles(false);
						this.world.broadcastEntityEvent(this, (byte)6);
					}
				}

				return true;
			}
		} else {
			if (stack != null && Item.ITEMS[stack.itemId] instanceof FoodItem) {
				FoodItem var3 = (FoodItem)Item.ITEMS[stack.itemId];
				if (var3.isMeat() && this.dataTracker.getInt(18) < 20) {
					--stack.count;
					if (stack.count <= 0) {
						player.inventory.setStack(player.inventory.selectedSlot, (ItemStack)null);
					}

					this.heal(((FoodItem)Item.RAW_PORKCHOP).getHealthRestored());
					return true;
				}
			}

			if (player.name.equalsIgnoreCase(this.getOwnerName())) {
				if (!this.world.isRemote) {
					this.setSitting(!this.isInSittingPose());
					this.jumping = false;
					this.setPath((Path)null);
				}

				return true;
			}
		}

		return false;
	}
}
