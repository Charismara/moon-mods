package de.blutmondgilde.moonmagic.data;

import de.blutmondgilde.moonapi.block.AbstractCaveCrystal;
import de.blutmondgilde.moonmagic.block.MoonMagicBlocks;
import de.blutmondgilde.moonmagic.item.MoonMagicItems;
import de.blutmondgilde.moonmagic.registry.MoonMagicRegistries;
import net.minecraft.data.loot.BlockLoot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;

public class MoonMagicBlockLoot extends BlockLoot implements IConditionBuilder {
    @Override
    protected void addTables() {
        add(MoonMagicBlocks.BLACK_CAVE_CRYSTAL,MoonMagicItems.BLACK_CRYSTAL_SHARD);
        add(MoonMagicBlocks.BLUE_CAVE_CRYSTAL,MoonMagicItems.BLUE_CRYSTAL_SHARD);
        add(MoonMagicBlocks.BROWN_CAVE_CRYSTAL,MoonMagicItems.BROWN_CRYSTAL_SHARD);
        add(MoonMagicBlocks.GRAY_CAVE_CRYSTAL,MoonMagicItems.GRAY_CRYSTAL_SHARD);
        add(MoonMagicBlocks.GREEN_CAVE_CRYSTAL,MoonMagicItems.GREEN_CRYSTAL_SHARD);
        add(MoonMagicBlocks.LIGHT_BLUE_CAVE_CRYSTAL,MoonMagicItems.LIGHT_BLUE_CRYSTAL_SHARD);
        add(MoonMagicBlocks.LIGHT_GRAY_CAVE_CRYSTAL,MoonMagicItems.LIGHT_GRAY_CRYSTAL_SHARD);
        add(MoonMagicBlocks.LIME_CAVE_CRYSTAL,MoonMagicItems.LIME_CRYSTAL_SHARD);
        add(MoonMagicBlocks.MAGENTA_CAVE_CRYSTAL,MoonMagicItems.MAGENTA_CRYSTAL_SHARD);
        add(MoonMagicBlocks.ORANGE_CAVE_CRYSTAL,MoonMagicItems.ORANGE_CRYSTAL_SHARD);
        add(MoonMagicBlocks.PINK_CAVE_CRYSTAL,MoonMagicItems.PINK_CRYSTAL_SHARD);
        add(MoonMagicBlocks.PURPLE_CAVE_CRYSTAL,MoonMagicItems.PURPLE_CRYSTAL_SHARD);
        add(MoonMagicBlocks.RED_CAVE_CRYSTAL,MoonMagicItems.RED_CRYSTAL_SHARD);
        add(MoonMagicBlocks.TURQUOISE_CAVE_CRYSTAL,MoonMagicItems.TURQUOISE_CRYSTAL_SHARD);
        add(MoonMagicBlocks.WHITE_CAVE_CRYSTAL,MoonMagicItems.WHITE_CRYSTAL_SHARD);
        add(MoonMagicBlocks.YELLOW_CAVE_CRYSTAL,MoonMagicItems.YELLOW_CRYSTAL_SHARD);
    }

    private void add(AbstractCaveCrystal caveCrystal, Item item){
        add(caveCrystal, block -> createSilkTouchDispatchTable(block, applyExplosionDecay(block, LootItem.lootTableItem(item)
            .apply(SetItemCountFunction.setCount(UniformGenerator.between(3.0F, 4.0F)))
            .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE)))));
    }

    @NotNull
    @Override
    protected Iterable<Block> getKnownBlocks() {
        return MoonMagicRegistries.getBlockRegistry().getEntries()
            .stream()
            .map(RegistryObject::get)::iterator;
    }
}
