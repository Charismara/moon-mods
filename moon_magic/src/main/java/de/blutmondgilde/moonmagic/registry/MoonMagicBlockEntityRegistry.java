package de.blutmondgilde.moonmagic.registry;

import de.blutmondgilde.moonapi.block.AbstractCaveCrystal;
import de.blutmondgilde.moonmagic.MoonMagic;
import de.blutmondgilde.moonmagic.block.entity.CaveCrystalBlockEntity;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

class MoonMagicBlockEntityRegistry {
    private static final DeferredRegister<BlockEntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, MoonMagic.MOD_ID);

    public static void init() {
        REGISTRY.register("cave_crystal",
            () -> BlockEntityType.Builder.of(CaveCrystalBlockEntity::new, AbstractCaveCrystal.caveCrystals.toArray(new Block[AbstractCaveCrystal.caveCrystals.size()])).build(null));
        REGISTRY.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
}
