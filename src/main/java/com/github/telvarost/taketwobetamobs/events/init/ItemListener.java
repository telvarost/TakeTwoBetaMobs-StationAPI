package com.github.telvarost.taketwobetamobs.events.init;

import com.github.telvarost.taketwobetamobs.TakeTwoBetaMobs;
import com.github.telvarost.taketwobetamobs.item.Tracker;
import net.mine_diver.unsafeevents.listener.EventListener;
import net.minecraft.item.Item;
import net.modificationstation.stationapi.api.event.registry.ItemRegistryEvent;

public class ItemListener {
    public static Item[] items;

    public static Item TRACKER;

    @EventListener
    public void registerItems(ItemRegistryEvent event) {
        TRACKER = new Tracker(TakeTwoBetaMobs.TAKE_TWO_BETA_MOBS.id("tracker")).setTranslationKey(TakeTwoBetaMobs.TAKE_TWO_BETA_MOBS, "tracker");

        items = new Item[]
        { TRACKER
        };
    }
}