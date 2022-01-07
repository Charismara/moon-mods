package de.blutmondgilde.moonmagic.block;

import de.blutmondgilde.moonapi.mixin.MixinMaterial;
import de.blutmondgilde.moonmagic.block.entity.PylonCoreEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import org.jetbrains.annotations.Nullable;

public class PylonCore extends Block implements EntityBlock {
    public PylonCore() {
        super(Properties.of(((MixinMaterial) new Material
                .Builder(MaterialColor.NONE)
                .noCollider())
                .callNotSolidBlocking()
                .build())
            .strength(-1.0F, 3600000.0F)
            .isValidSpawn((p_61031_, p_61032_, p_61033_, p_61034_) -> false)
            .lightLevel(value -> 15)
            .noOcclusion()
            .noDrops());
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return new PylonCoreEntity(pPos, pState);
    }

    @Override
    public RenderShape getRenderShape(BlockState pState) {
        return RenderShape.MODEL;
    }
}
