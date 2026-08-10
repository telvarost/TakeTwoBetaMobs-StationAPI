package com.github.telvarost.taketwobetamobs.events.init;

import com.github.telvarost.taketwobetamobs.TakeTwoBetaMobs;
import com.github.telvarost.taketwobetamobs.item.Locator;
import net.mine_diver.unsafeevents.listener.EventListener;
import net.minecraft.item.Item;
import net.modificationstation.stationapi.api.event.registry.ItemRegistryEvent;

public class ItemListener {
    public static Item[] items;

    public static Item LOCATOR;

    @EventListener
    public void registerItems(ItemRegistryEvent event) {
        LOCATOR = new Locator(TakeTwoBetaMobs.TAKE_TWO_BETA_MOBS.id("locator")).setTranslationKey(TakeTwoBetaMobs.TAKE_TWO_BETA_MOBS, "locator");

        items = new Item[]
        { LOCATOR
        };
    }
}