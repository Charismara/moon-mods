package de.blutmondgilde.moonmagic.block.crystals;


import de.blutmondgilde.moonapi.block.AbstractCaveCrystal;
import de.blutmondgilde.moonmagic.block.entity.CaveCrystalBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraft.world.phys.AABB;
import org.jetbrains.annotations.Nullable;

public class YellowCaveCrystal extends AbstractCaveCrystal {
    public YellowCaveCrystal() {
        super(MaterialColor.COLOR_GREEN);
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return new CaveCrystalBlockEntity(pPos, pState);
    }

    @Override
    public void onTick(final Level level, final BlockPos pos, final AABB range) {
        level.getEntitiesOfClass(Player.class, range).forEach(entity -> {
            if (isHostile(level, entity)) {
                if (!entity.getActiveEffectsMap().containsKey(MobEffects.DIG_SLOWDOWN)) {
                    entity.addEffect(new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 20 * 2, 0, false, true, true));
                }
            } else {
                if (!entity.getActiveEffectsMap().containsKey(MobEffects.DIG_SPEED)) {
                    entity.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 20 * 2, 0, false, true, true));
                }
            }
        });
    }
}
