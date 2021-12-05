package de.blutmondgilde.moonapi.registry;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

public class MoonApiRegistries {
    public static void init() {
        IEventBus modBus = FMLJavaModLoadingContext.get().getModEventBus();
        MoonApiMobEffectRegistry.init(modBus);
    }
}
