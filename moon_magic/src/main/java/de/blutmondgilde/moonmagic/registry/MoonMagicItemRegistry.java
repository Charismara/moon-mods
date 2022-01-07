package de.blutmondgilde.moonmagic.registry;

import de.blutmondgilde.moonapi.block.item.CaveCrystalBlockItem;
import de.blutmondgilde.moonmagic.MoonMagic;
import de.blutmondgilde.moonmagic.block.MoonMagicBlocks;
import de.blutmondgilde.moonmagic.item.CaveCrystalItem;
import de.blutmondgilde.moonmagic.item.PylonCoreItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;

class MoonMagicItemRegistry {
    private static final DeferredRegister<Item> registry = DeferredRegister.create(Item.class, MoonMagic.MOD_ID);

    public static void init() {
        registry.register("black_cave_crystal", () -> new CaveCrystalBlockItem(MoonMagicBlocks.BLACK_CAVE_CRYSTAL, MoonMagicCreativeTabs.BLOCK_CREATIVE_TAB));
        registry.register("blue_cave_crystal", () -> new CaveCrystalBlockItem(MoonMagicBlocks.BLUE_CAVE_CRYSTAL, MoonMagicCreativeTabs.BLOCK_CREATIVE_TAB));
        registry.register("brown_cave_crystal", () -> new CaveCrystalBlockItem(MoonMagicBlocks.BROWN_CAVE_CRYSTAL, MoonMagicCreativeTabs.BLOCK_CREATIVE_TAB));
        registry.register("gray_cave_crystal", () -> new CaveCrystalBlockItem(MoonMagicBlocks.GRAY_CAVE_CRYSTAL, MoonMagicCreativeTabs.BLOCK_CREATIVE_TAB));
        registry.register("green_cave_crystal", () -> new CaveCrystalBlockItem(MoonMagicBlocks.GREEN_CAVE_CRYSTAL, MoonMagicCreativeTabs.BLOCK_CREATIVE_TAB));
        registry.register("light_blue_cave_crystal", () -> new CaveCrystalBlockItem(MoonMagicBlocks.LIGHT_BLUE_CAVE_CRYSTAL, MoonMagicCreativeTabs.BLOCK_CREATIVE_TAB));
        registry.register("light_gray_cave_crystal", () -> new CaveCrystalBlockItem(MoonMagicBlocks.LIGHT_GRAY_CAVE_CRYSTAL, MoonMagicCreativeTabs.BLOCK_CREATIVE_TAB));
        registry.register("lime_cave_crystal", () -> new CaveCrystalBlockItem(MoonMagicBlocks.LIME_CAVE_CRYSTAL, MoonMagicCreativeTabs.BLOCK_CREATIVE_TAB));
        registry.register("magenta_cave_crystal", () -> new CaveCrystalBlockItem(MoonMagicBlocks.MAGENTA_CAVE_CRYSTAL, MoonMagicCreativeTabs.BLOCK_CREATIVE_TAB));
        registry.register("orange_cave_crystal", () -> new CaveCrystalBlockItem(MoonMagicBlocks.ORANGE_CAVE_CRYSTAL, MoonMagicCreativeTabs.BLOCK_CREATIVE_TAB));
        registry.register("pink_cave_crystal", () -> new CaveCrystalBlockItem(MoonMagicBlocks.PINK_CAVE_CRYSTAL, MoonMagicCreativeTabs.BLOCK_CREATIVE_TAB));
        registry.register("purple_cave_crystal", () -> new CaveCrystalBlockItem(MoonMagicBlocks.PURPLE_CAVE_CRYSTAL, MoonMagicCreativeTabs.BLOCK_CREATIVE_TAB));
        registry.register("red_cave_crystal", () -> new CaveCrystalBlockItem(MoonMagicBlocks.RED_CAVE_CRYSTAL, MoonMagicCreativeTabs.BLOCK_CREATIVE_TAB));
        registry.register("turquoise_cave_crystal", () -> new CaveCrystalBlockItem(MoonMagicBlocks.TURQUOISE_CAVE_CRYSTAL, MoonMagicCreativeTabs.BLOCK_CREATIVE_TAB));
        registry.register("white_cave_crystal", () -> new CaveCrystalBlockItem(MoonMagicBlocks.WHITE_CAVE_CRYSTAL, MoonMagicCreativeTabs.BLOCK_CREATIVE_TAB));
        registry.register("yellow_cave_crystal", () -> new CaveCrystalBlockItem(MoonMagicBlocks.YELLOW_CAVE_CRYSTAL, MoonMagicCreativeTabs.BLOCK_CREATIVE_TAB));
        //Crystal Shards
        registry.register("black_crystal_shard", CaveCrystalItem::new);
        registry.register("blue_crystal_shard", CaveCrystalItem::new);
        registry.register("brown_crystal_shard", CaveCrystalItem::new);
        registry.register("gray_crystal_shard", CaveCrystalItem::new);
        registry.register("green_crystal_shard", CaveCrystalItem::new);
        registry.register("light_blue_crystal_shard", CaveCrystalItem::new);
        registry.register("light_gray_crystal_shard", CaveCrystalItem::new);
        registry.register("lime_crystal_shard", CaveCrystalItem::new);
        registry.register("magenta_crystal_shard", CaveCrystalItem::new);
        registry.register("orange_crystal_shard", CaveCrystalItem::new);
        registry.register("pink_crystal_shard", CaveCrystalItem::new);
        registry.register("purple_crystal_shard", CaveCrystalItem::new);
        registry.register("red_crystal_shard", CaveCrystalItem::new);
        registry.register("turquoise_crystal_shard", CaveCrystalItem::new);
        registry.register("white_crystal_shard", CaveCrystalItem::new);
        registry.register("yellow_crystal_shard", CaveCrystalItem::new);

        registry.register("pylon_core", PylonCoreItem::new);

        registry.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
}
