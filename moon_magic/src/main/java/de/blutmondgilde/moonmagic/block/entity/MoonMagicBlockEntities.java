package de.blutmondgilde.moonmagic.block.entity;

import de.blutmondgilde.moonmagic.MoonMagic;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.ObjectHolder;

@ObjectHolder(MoonMagic.MOD_ID)
public class MoonMagicBlockEntities {
    @ObjectHolder("cave_crystal")
    public static BlockEntityType<?> CAVE_CRYSTAL = null;
}
