# TakeTwoBetaMobs StationAPI for Minecraft Beta 1.7.3

A StationAPI mod for Minecraft Beta 1.7.3 that attempts to add a variant for each beta mob.
- Mod works on Multiplayer with [GlassConfigAPI](https://modrinth.com/mod/glass-config-api) version 3.0+ used to sync configs!
  - Requires [ZastavkaAPI](https://modrinth.com/mod/zastavkaapi) to work on servers, until StationAPI fixes its falling blocks.
- All features can be enabled/disabled through [GlassConfigAPI](https://modrinth.com/mod/glass-config-api) as well.

### Mobs

* Shadow Wolf
  * Immune to all damage except from other shadow wolves, players, zombie pigmen, and/or pigs
    * Also, can only be commanded to attack the above entities
    * There is an exception for extremely high damage (100 damage or above) so special mods may still kill the wolves
  * 2x HP compared to normal wolves
  * Tamed with charcoal instead of bones (regular coal will not work)
  * Untamed shadow wolves automatically become hostile when in the Nether
  * Spawn Regions
    * Chunk Specific - Spawns in chunks with blood spruce structures (see below)
    * Biome Specific - Spawns in Forest and Taiga biomes (same as normal wolves)
    * Dimension Specific - Spawns only in the Nether
    * All Regions - Spawns in all dimensions and biomes (similarly no regions means natural spawning is disabled)

### Structures for Chunk Specific spawn regions

All structures require the keystone block to be placed last to activate.

* Blood Spruce - Spruce sapling keystone
  * A cross of 4 netherrack with dirt in the center and then place the spruce sapling on the dirt
    * Other blocks that allow spruce sapling placement besides dirt may be used if available

### Other Features

* Locator

### Crafting Recipes

All crafting recipes can be turned on/off from the mod config menu.

![locator crafting recipe](https://github.com/telvarost/TakeTwoBetaMobs-StationAPI/blob/main/images/LocatorCraftingRecipe.png)

## Installation using Prism Launcher

1. Download an instance of Babric for Prism Launcher: https://github.com/babric/prism-instance
2. Install Java 17 and set the instance to use it: https://adoptium.net/temurin/releases/
3. Add GlassConfigAPI 3.0.2+ to the mod folder for the instance: https://modrinth.com/mod/glass-config-api
4. Add Glass Networking to the mod folder for the instance: https://modrinth.com/mod/glass-networking
5. Add StationAPI to the mod folder for the instance: https://modrinth.com/mod/stationapi
6. Add ZastavkaAPI to the mod folder for the instance: https://modrinth.com/mod/zastavkaapi
7. (Optional) Add Mod Menu to the mod folder for the instance: https://modrinth.com/mod/modmenu-beta
8. Add this mod to the mod folder for the instance: https://github.com/telvarost/TakeTwoBetaMobs-StationAPI/releases
9. Run and enjoy! 👍

## Feedback

Got any suggestions on what should be added next? Feel free to share it by [creating an issue](https://github.com/telvarost/TakeTwoBetaMobs-StationAPI/issues/new). Know how to code and want to do it yourself? Then look below on how to get started.

## Contributing

Thanks for considering contributing! To get started fork this repository, make your changes, and create a PR. 

If you are new to StationAPI consider watching the following videos on Babric/StationAPI Minecraft modding: https://www.youtube.com/watch?v=9-sVGjnGJ5s&list=PLa2JWzyvH63wGcj5-i0P12VkJG7PDyo9T
