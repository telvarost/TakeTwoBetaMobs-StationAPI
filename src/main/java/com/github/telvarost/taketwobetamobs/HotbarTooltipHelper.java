package com.github.telvarost.taketwobetamobs;

import com.github.telvarost.taketwobetamobs.mixin.InGameHudAccessor;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.client.Minecraft;

public class HotbarTooltipHelper {
    private static Minecraft client;

    public static void setTooltip(String message, int remaining){
        if(client == null){
            client = (Minecraft) FabricLoader.getInstance().getGameInstance();
        }

        ((InGameHudAccessor)client.inGameHud).setOverlayMessage(message);
        ((InGameHudAccessor)client.inGameHud).setOverlayRemaining(remaining);
    }
}