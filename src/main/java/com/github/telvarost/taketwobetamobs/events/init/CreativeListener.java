//package com.github.telvarost.taketwobetamobs.events.init;
//
//import com.github.telvarost.taketwobetamobs.TakeTwoBetaMobs;
//import net.mine_diver.unsafeevents.listener.EventListener;
//import net.minecraft.item.Item;
//import net.minecraft.item.ItemStack;
//import paulevs.bhcreative.api.CreativeTab;
//import paulevs.bhcreative.api.SimpleTab;
//import paulevs.bhcreative.registry.TabRegistryEvent;
//
//import static com.github.telvarost.taketwobetamobs.events.init.ItemListener.TRACKER;
//
//public class CreativeListener {
//    public static CreativeTab tabTakeTwoBetaMobs;
//
//    @EventListener
//    public void onTabInit(TabRegistryEvent event){
//        tabTakeTwoBetaMobs = new SimpleTab(TakeTwoBetaMobs.TAKE_TWO_BETA_MOBS.id("tracker"), TRACKER);
//        event.register(tabTakeTwoBetaMobs);
//
//        for (Item item : ItemListener.items){
//            tabTakeTwoBetaMobs.addItem(new ItemStack(item, 1));
//        }
//    }
//}
