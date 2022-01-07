package de.blutmondgilde.moonmagic.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class PylonCoreEntity extends BlockEntity {
    public PylonCoreEntity(BlockPos pWorldPosition, BlockState pBlockState) {
        super(MoonMagicBlockEntities.PYLON_CORE, pWorldPosition, pBlockState);
    }
}
