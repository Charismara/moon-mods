package de.blutmondgilde.moonapi.block.item;

import de.blutmondgilde.moonapi.block.AbstractCaveCrystal;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;

public class CaveCrystalBlockItem extends BlockItem {
    public CaveCrystalBlockItem(AbstractCaveCrystal caveCrystal) {
        super(caveCrystal, new Properties().tab(CreativeModeTab.TAB_MISC));
    }
}
