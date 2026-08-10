package com.github.telvarost.taketwobetamobs.events.client;

import com.github.telvarost.taketwobetamobs.entity.ShadowWolfEntity;
import com.github.telvarost.taketwobetamobs.entity.ShadowWolfEntityRenderer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.mine_diver.unsafeevents.listener.EventListener;
import net.modificationstation.stationapi.api.client.event.render.entity.EntityRendererRegisterEvent;

public class EntityRendererListener {

    @Environment(EnvType.CLIENT)
    @EventListener
    public void registerEntityRenderer(EntityRendererRegisterEvent event) {
        event.renderers.put(ShadowWolfEntity.class, new ShadowWolfEntityRenderer());
    }
}
