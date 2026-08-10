package com.github.telvarost.taketwobetamobs.events.init;

import com.github.telvarost.taketwobetamobs.Config;
import net.mine_diver.unsafeevents.listener.EventListener;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.modificationstation.stationapi.api.event.recipe.RecipeRegisterEvent;
import net.modificationstation.stationapi.api.recipe.CraftingRegistry;
import net.modificationstation.stationapi.api.util.Identifier;

import static com.github.telvarost.taketwobetamobs.events.init.ItemListener.LOCATOR;

public class RecipeListener {

    @EventListener
    public void registerRecipes(RecipeRegisterEvent event) {
        Identifier type = event.recipeId;

        if (type == RecipeRegisterEvent.Vanilla.CRAFTING_SHAPELESS.type()) {
             if (Config.config.RECIPE_CONFIG.enableLocatorCraftingRecipe) {
                 CraftingRegistry.addShapelessRecipe(new ItemStack(LOCATOR, 1), Item.CLOCK, Item.COMPASS);
             }
        }
    }
}
