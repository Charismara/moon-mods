package de.blutmondgilde.moonmagic.registry;

import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;

public class MoonMagicRegistries {
    public static void init() {
        MoonMagicBlockRegistry.init();
        MoonMagicItemRegistry.init();
        MoonMagicBlockEntityRegistry.init();
    }

    public static DeferredRegister<Block> getBlockRegistry() {
        return MoonMagicBlockRegistry.getRegistry();
    }
}
