package de.blutmondgilde.moonmagic.data;

import de.blutmondgilde.moonmagic.MoonMagic;
import de.blutmondgilde.moonmagic.block.MoonMagicBlocks;
import de.blutmondgilde.moonmagic.registry.MoonMagicRegistries;
import net.minecraft.data.loot.BlockLoot;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.minecraftforge.fmllegacy.RegistryObject;
import org.jetbrains.annotations.NotNull;

public class MoonMagicBlockLoot extends BlockLoot implements IConditionBuilder {
    @Override
    protected void addTables() {
        MoonMagic.getLogger().info("Generating Block Loot Tables...");

        add(MoonMagicBlocks.BLACK_CAVE_CRYSTAL, block -> createSilkTouchDispatchTable(block, applyExplosionDecay(block, LootItem.lootTableItem(Items.RAW_COPPER)
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
