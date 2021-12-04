package de.blutmondgilde.moonmagic.block.crystals;


import de.blutmondgilde.moonapi.block.AbstractCaveCrystal;
import de.blutmondgilde.moonmagic.block.entity.CaveCrystalBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraft.world.phys.AABB;
import org.jetbrains.annotations.Nullable;

public class WhiteCaveCrystal extends AbstractCaveCrystal {
    public WhiteCaveCrystal() {
        super(MaterialColor.COLOR_GREEN);
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return new CaveCrystalBlockEntity(pPos, pState);
    }

    @Override
    public void onTick(final Level level, final BlockPos pos, final AABB range) {
        level.getEntitiesOfClass(LivingEntity.class, range).forEach(LivingEntity::removeAllEffects);
    }
}
