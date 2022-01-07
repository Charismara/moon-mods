package de.blutmondgilde.moonmagic.item;

import de.blutmondgilde.moonmagic.block.MoonMagicBlocks;
import de.blutmondgilde.moonmagic.registry.MoonMagicCreativeTabs;
import net.minecraft.world.item.BlockItem;

public class PylonCoreItem extends BlockItem {
    public PylonCoreItem() {
        super(MoonMagicBlocks.PYLON_CORE, new Properties().tab(MoonMagicCreativeTabs.BLOCK_CREATIVE_TAB));
    }
}
