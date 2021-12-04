package de.blutmondgilde.moonmagic.registry;

import de.blutmondgilde.moonmagic.MoonMagic;
import de.blutmondgilde.moonmagic.block.BlackCaveCrystal;
import lombok.AccessLevel;
import lombok.Getter;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;

class MoonMagicBlockRegistry {
    @Getter(AccessLevel.PACKAGE)
    private static final DeferredRegister<Block> registry = DeferredRegister.create(Block.class, MoonMagic.MOD_ID);

    public static void init() {
        registry.register("black_cave_crystal", BlackCaveCrystal::new);
        registry.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
}
