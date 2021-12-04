package de.blutmondgilde.moonmagic.block;


import de.blutmondgilde.moonapi.block.AbstractCaveCrystal;
import de.blutmondgilde.moonmagic.block.entity.CaveCrystalBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraft.world.phys.AABB;
import org.jetbrains.annotations.Nullable;

public class BlackCaveCrystal extends AbstractCaveCrystal {
    public BlackCaveCrystal() {
        super(MaterialColor.COLOR_BLACK);
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return new CaveCrystalBlockEntity(pPos, pState);
    }

    @Override
    public void onTick(final Level level, final BlockPos pos, final AABB range) {
        level.getEntitiesOfClass(LivingEntity.class, range).forEach(entity -> {
            if (!entity.getActiveEffectsMap().containsKey(MobEffects.WITHER)) {
                entity.addEffect(new MobEffectInstance(MobEffects.WITHER, 20 * 2, 0, false, true, true));
            }
        });
    }
}
