package de.blutmondgilde.moonmagic.registry;

import de.blutmondgilde.moonmagic.block.MoonMagicBlocks;
import de.blutmondgilde.moonmagic.item.MoonMagicItems;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class MoonMagicCreativeTabs {
    public static final CreativeModeTab ITEM_CREATIVE_TAB = new CreativeModeTab("moon_magic_items") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(MoonMagicItems.PURPLE_CRYSTAL_SHARD);
        }
    };
    public static final CreativeModeTab BLOCK_CREATIVE_TAB = new CreativeModeTab("moon_magic_blocks") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(MoonMagicBlocks.BLUE_CAVE_CRYSTAL.asItem());
        }
    };
}
