package de.blutmondgilde.moonmagic.block.item;

import de.blutmondgilde.moonmagic.block.MoonMagicBlocks;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;

public class BlackCaveCrystal extends BlockItem {
    public BlackCaveCrystal() {
        super(MoonMagicBlocks.BLACK_CAVE_CRYSTAL, new Properties().tab(CreativeModeTab.TAB_MISC));
    }
}
