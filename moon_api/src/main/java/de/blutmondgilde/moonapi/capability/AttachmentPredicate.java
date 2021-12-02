package de.blutmondgilde.moonapi.capability;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.chunk.LevelChunk;

import java.util.function.Predicate;

/**
 * Predicate to check if the Capability should be attached to the given object or not.
 * You only need to create one of those Predicates.
 */
@Builder
public class AttachmentPredicate {
    /** Predicate for attaching a Capability to an Entity */
    @Setter
    @Getter
    @Builder.Default
    private Predicate<Entity> canAttachToEntity = entity -> false;
    /** Predicate for attaching a Capability to a TileEntity / BlockEntity */
    @Setter
    @Getter
    @Builder.Default
    private Predicate<BlockEntity> canAttachToBlockEntity = blockEntity -> false;
    /** Predicate for attaching a Capability to an Item / ItemStack */
    @Setter
    @Getter
    @Builder.Default
    private Predicate<ItemStack> canAttachToItemStack = itemStack -> false;
    /** Predicate for attaching a Capability to a World / Level */
    @Setter
    @Getter
    @Builder.Default
    private Predicate<Level> canAttachToWorld = level -> false;
    /** Predicate for attaching a Capability to a Chunk */
    @Setter
    @Getter
    @Builder.Default
    private Predicate<LevelChunk> canAttachToChunk = chunk -> false;
}
