package de.blutmondgilde.moonmagic.registry;

import de.blutmondgilde.moonapi.block.item.CaveCrystalBlockItem;
import de.blutmondgilde.moonmagic.MoonMagic;
import de.blutmondgilde.moonmagic.block.MoonMagicBlocks;
import net.minecraft.world.item.Item;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;

class MoonMagicItemRegistry {
    private static final DeferredRegister<Item> registry = DeferredRegister.create(Item.class, MoonMagic.MOD_ID);

    public static void init() {
        registry.register("black_cave_crystal", () -> new CaveCrystalBlockItem(MoonMagicBlocks.BLACK_CAVE_CRYSTAL));
        registry.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
}
