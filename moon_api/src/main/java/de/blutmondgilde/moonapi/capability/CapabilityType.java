package de.blutmondgilde.moonapi.capability;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.chunk.LevelChunk;

@RequiredArgsConstructor
public enum CapabilityType {
    ENTITY(Entity.class),
    BLOCK_ENTITY(BlockEntity.class),
    ITEM(ItemStack.class),
    WORLD(Level.class),
    CHUNK(LevelChunk.class);

    @Getter
    private final Class<?> attachmentClass;
}
