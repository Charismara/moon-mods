package de.blutmondgilde.moonmagic.block.entity;

import de.blutmondgilde.moonapi.block.AbstractCaveCrystal;
import de.blutmondgilde.moonapi.block.entity.TickingBlockEntity;
import de.blutmondgilde.moonapi.util.TickCounter;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.phys.AABB;

public class CaveCrystalBlockEntity extends BlockEntity implements TickingBlockEntity {
    private final TickCounter counter = new TickCounter(10);
    private static final int radius = 5;
    private final AABB range;

    public CaveCrystalBlockEntity(BlockPos pWorldPosition, BlockState pBlockState) {
        super(MoonMagicBlockEntities.CAVE_CRYSTAL, pWorldPosition, pBlockState);
        this.range = AABB.of(new BoundingBox(pWorldPosition.getX() - radius, pWorldPosition.getY() - 5, pWorldPosition.getZ() - 5,
            pWorldPosition.getX() + 5, pWorldPosition.getY() + 5, pWorldPosition.getZ() + 5));
    }

    @Override
    public void onTick() {
        if (level == null) return;
        if (counter.tick()) {
            if (getBlockState().getBlock() instanceof AbstractCaveCrystal caveCrystal) {
                caveCrystal.onTick(level, getBlockPos(), range);
            }
        }
    }
}
