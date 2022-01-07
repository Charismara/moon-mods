package de.blutmondgilde.moonmagic.registry;

import de.blutmondgilde.moonmagic.MoonMagic;
import de.blutmondgilde.moonmagic.block.PylonCore;
import de.blutmondgilde.moonmagic.block.crystals.BlackCaveCrystal;
import de.blutmondgilde.moonmagic.block.crystals.BlueCaveCrystal;
import de.blutmondgilde.moonmagic.block.crystals.BrownCaveCrystal;
import de.blutmondgilde.moonmagic.block.crystals.GrayCaveCrystal;
import de.blutmondgilde.moonmagic.block.crystals.GreenCaveCrystal;
import de.blutmondgilde.moonmagic.block.crystals.LightBlueCaveCrystal;
import de.blutmondgilde.moonmagic.block.crystals.LightGrayCaveCrystal;
import de.blutmondgilde.moonmagic.block.crystals.LimeCaveCrystal;
import de.blutmondgilde.moonmagic.block.crystals.MagentaCaveCrystal;
import de.blutmondgilde.moonmagic.block.crystals.OrangeCaveCrystal;
import de.blutmondgilde.moonmagic.block.crystals.PinkCaveCrystal;
import de.blutmondgilde.moonmagic.block.crystals.PurpleCaveCrystal;
import de.blutmondgilde.moonmagic.block.crystals.RedCaveCrystal;
import de.blutmondgilde.moonmagic.block.crystals.TurquoiseCaveCrystal;
import de.blutmondgilde.moonmagic.block.crystals.WhiteCaveCrystal;
import de.blutmondgilde.moonmagic.block.crystals.YellowCaveCrystal;
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
        registry.register("blue_cave_crystal", BlueCaveCrystal::new);
        registry.register("brown_cave_crystal", BrownCaveCrystal::new);
        registry.register("gray_cave_crystal", GrayCaveCrystal::new);
        registry.register("green_cave_crystal", GreenCaveCrystal::new);
        registry.register("light_blue_cave_crystal", LightBlueCaveCrystal::new);
        registry.register("light_gray_cave_crystal", LightGrayCaveCrystal::new);
        registry.register("lime_cave_crystal", LimeCaveCrystal::new);
        registry.register("magenta_cave_crystal", MagentaCaveCrystal::new);
        registry.register("orange_cave_crystal", OrangeCaveCrystal::new);
        registry.register("pink_cave_crystal", PinkCaveCrystal::new);
        registry.register("purple_cave_crystal", PurpleCaveCrystal::new);
        registry.register("red_cave_crystal", RedCaveCrystal::new);
        registry.register("turquoise_cave_crystal", TurquoiseCaveCrystal::new);
        registry.register("white_cave_crystal", WhiteCaveCrystal::new);
        registry.register("yellow_cave_crystal", YellowCaveCrystal::new);
        registry.register("pylon_core", PylonCore::new);
        registry.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
}
