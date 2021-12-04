package de.blutmondgilde.moonmagic.data;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;

public class MoonMagicDataGenerator {
    public static void onGatherData(final GatherDataEvent e) {
        DataGenerator generator = e.getGenerator();
        generator.addProvider(new MoonMagicLootTableProvider(generator));
    }
}
