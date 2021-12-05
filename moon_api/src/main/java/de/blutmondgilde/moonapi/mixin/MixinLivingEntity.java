package de.blutmondgilde.moonapi.mixin;

import de.blutmondgilde.moonapi.MoonApi;
import de.blutmondgilde.moonapi.effect.MoonApiMobEffects;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(LivingEntity.class)
public abstract class MixinLivingEntity {
    @Shadow
    protected abstract float getJumpPower();

    //Apply jump disability modifier
    @Redirect(method = "jumpFromGround", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/LivingEntity;getJumpBoostPower()D"))
    private double onJumpFromGround(LivingEntity instance) {
        double value = instance.hasEffect(MobEffects.JUMP) ? (double) (0.1F * (float) (instance.getEffect(MobEffects.JUMP).getAmplifier() + 1)) : 0.0D;
        if (instance.hasEffect(MoonApiMobEffects.JUMP_DISABILITY)) {
            value -= getJumpPower() * instance.getEffect(MoonApiMobEffects.JUMP_DISABILITY).getAmplifier() / 3F;
            MoonApi.getLogger().info("Changed value from {} to {}", getJumpPower(), getJumpPower() + value);
        }
        return value;
    }
}
