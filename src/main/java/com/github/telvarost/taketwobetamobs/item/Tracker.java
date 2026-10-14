//package com.github.telvarost.taketwobetamobs.item;
//
//import com.github.telvarost.taketwobetamobs.HotbarTooltipHelper;
//import com.github.telvarost.taketwobetamobs.retroapi.ChunkSpawnData;
//import net.fabricmc.api.EnvType;
//import net.fabricmc.loader.api.FabricLoader;
//import net.minecraft.entity.player.PlayerEntity;
//import net.minecraft.item.ItemStack;
//import net.minecraft.world.World;
//import net.modificationstation.stationapi.api.client.item.CustomTooltipProvider;
//import net.modificationstation.stationapi.api.template.item.TemplateItem;
//import net.modificationstation.stationapi.api.util.Identifier;
//
//public class Tracker extends TemplateItem implements CustomTooltipProvider {
//    public Tracker(Identifier i) {
//        super(i);
//    }
//
//    @Override
//    public String[] getTooltip(ItemStack itemInstance, String originalTooltip) {
//        return new String[]{originalTooltip};
//    }
//
//    @Override
//    public boolean useOnBlock(ItemStack stack, PlayerEntity user, World world, int x, int y, int z, int side) {
//        if (FabricLoader.getInstance().getEnvironmentType() == EnvType.CLIENT) {
//            boolean canSpawnShadowWolf = ChunkSpawnData.getCanSpawnShadowWolf(world, x, z);
//            HotbarTooltipHelper.setTooltip("Chunk X/Y: " + (x >> 4) + "/" + (z >> 4) + " Shadow Wolf Spawning: " + canSpawnShadowWolf, 40);
//        }
//        return true;
//    }
//}
