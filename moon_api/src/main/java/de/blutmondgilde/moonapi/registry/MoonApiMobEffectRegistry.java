package de.blutmondgilde.moonapi.registry;

import de.blutmondgilde.moonapi.MoonApi;
import de.blutmondgilde.moonapi.effect.JumpDisability;
import net.minecraft.world.effect.MobEffect;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;

class MoonApiMobEffectRegistry {
    private static final DeferredRegister<MobEffect> registry = DeferredRegister.create(MobEffect.class, MoonApi.MOD_ID);

    public static void init(IEventBus modBus) {
        registry.register("jump_disability", JumpDisability::new);
        registry.register(modBus);
    }
}
