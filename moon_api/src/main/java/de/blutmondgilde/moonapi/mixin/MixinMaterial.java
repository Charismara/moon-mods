package de.blutmondgilde.moonapi.mixin;

import net.minecraft.world.level.material.Material;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(Material.Builder.class)
public interface MixinMaterial {
    @Invoker
    Material.Builder callNotSolidBlocking();
}
