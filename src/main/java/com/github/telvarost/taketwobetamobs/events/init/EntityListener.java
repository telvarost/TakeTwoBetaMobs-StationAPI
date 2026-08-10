package com.github.telvarost.taketwobetamobs.events.init;

import com.github.telvarost.taketwobetamobs.TakeTwoBetaMobs;
import com.github.telvarost.taketwobetamobs.entity.ShadowWolfEntity;
import net.mine_diver.unsafeevents.listener.EventListener;
import net.modificationstation.stationapi.api.event.entity.EntityRegisterEvent;
import net.modificationstation.stationapi.api.event.registry.MobHandlerRegistryEvent;

public class EntityListener {
    @EventListener
    public void registerEntities(EntityRegisterEvent event) {
        event.register(TakeTwoBetaMobs.TAKE_TWO_BETA_MOBS.id("ShadowWolf"), ShadowWolfEntity.class);
    }

    @EventListener
    public void registerMobHandlers(MobHandlerRegistryEvent event) {
        event.register(TakeTwoBetaMobs.TAKE_TWO_BETA_MOBS.id("ShadowWolf"), ShadowWolfEntity::new);
    }
}
