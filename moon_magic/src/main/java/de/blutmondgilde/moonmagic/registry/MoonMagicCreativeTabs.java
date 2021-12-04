package de.blutmondgilde.moonmagic.registry;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

public class MoonMagicCreativeTabs {
    public static final CreativeModeTab ITEM_CREATIVE_TAB = new CreativeModeTab("moon_magic_items") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(Items.IRON_INGOT);
        }
    };
    public static final CreativeModeTab BLOCK_CREATIVE_TAB = new CreativeModeTab("moon_magic_blocks") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(Items.IRON_BLOCK);
        }
    };
}
