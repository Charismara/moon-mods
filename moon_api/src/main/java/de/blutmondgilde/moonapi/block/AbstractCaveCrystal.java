package de.blutmondgilde.moonapi.block;

import de.blutmondgilde.moonapi.block.entity.TickingBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;

public abstract class AbstractCaveCrystal extends Block implements EntityBlock {
    private static final VoxelShape SHAPE = Shapes.box(0.1f, 0, 0.35f, 0.9f, 1.0F, 0.65f);
    public static ArrayList<AbstractCaveCrystal> caveCrystals = new ArrayList<>();

    public AbstractCaveCrystal(MaterialColor color) {
        super(Properties.of(new Material.Builder(color).build())
            .noOcclusion()
            .lightLevel(value -> 15)
            .strength(3F, 3F)
            .requiresCorrectToolForDrops());
        caveCrystals.add(this);
    }

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return SHAPE;
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level pLevel, BlockState pState, BlockEntityType<T> pBlockEntityType) {
        if (pLevel.isClientSide()) return EntityBlock.super.getTicker(pLevel, pState, pBlockEntityType);

        return (pLevel1, pPos, pState1, pBlockEntity) -> {
            if (pBlockEntity instanceof TickingBlockEntity blockEntity) {
                blockEntity.onTick();
            }
        };
    }

    public abstract void onTick(Level level, BlockPos pos, AABB range);
}
