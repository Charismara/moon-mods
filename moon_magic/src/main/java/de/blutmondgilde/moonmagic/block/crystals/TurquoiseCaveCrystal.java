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

public class TurquoiseCaveCrystal extends AbstractCaveCrystal {
    public TurquoiseCaveCrystal() {
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
                if (!entity.getActiveEffectsMap().containsKey(MobEffects.CONFUSION)) {
                    entity.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 20 * 2, 0, false, true, true));
                }
            } else {
                if (!entity.getActiveEffectsMap().containsKey(MobEffects.WATER_BREATHING)) {
                    entity.addEffect(new MobEffectInstance(MobEffects.WATER_BREATHING, 20 * 2, 0, false, true, true));
                }
            }
        });
    }
}
