package de.blutmondgilde.moonmagic.registry;

import de.blutmondgilde.moonapi.block.AbstractCaveCrystal;
import de.blutmondgilde.moonmagic.MoonMagic;
import de.blutmondgilde.moonmagic.block.MoonMagicBlocks;
import de.blutmondgilde.moonmagic.block.entity.CaveCrystalBlockEntity;
import de.blutmondgilde.moonmagic.block.entity.PylonCoreEntity;
import lombok.AccessLevel;
import lombok.Getter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

class MoonMagicBlockEntityRegistry {
    @Getter(AccessLevel.PACKAGE)
    private static final DeferredRegister<BlockEntityType<?>> registry = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, MoonMagic.MOD_ID);

    public static void init() {
        registry.register("cave_crystal",
            () -> BlockEntityType.Builder.of(CaveCrystalBlockEntity::new, AbstractCaveCrystal.caveCrystals.toArray(new Block[AbstractCaveCrystal.caveCrystals.size()])).build(null));
        registry.register("pylon_core", () -> BlockEntityType.Builder.of(PylonCoreEntity::new, MoonMagicBlocks.PYLON_CORE).build(null));
        registry.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
}
