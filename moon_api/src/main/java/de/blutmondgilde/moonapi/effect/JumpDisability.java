package de.blutmondgilde.moonapi.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;

import java.awt.Color;

public class JumpDisability extends MobEffect {
    private static final Color color = new Color(148, 0, 0);

    public JumpDisability() {
        super(MobEffectCategory.HARMFUL, color.getRGB());
        addAttributeModifier(Attributes.JUMP_STRENGTH, "b725b7d6-ad0c-4b09-ad11-82bdd1bf9b61", 0, AttributeModifier.Operation.MULTIPLY_TOTAL);
    }
}
