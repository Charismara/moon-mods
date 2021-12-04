package de.blutmondgilde.moonmagic.data;

import de.blutmondgilde.moonmagic.MoonMagic;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;

public class MoonMagicDataGenerator {
    public static void onGatherData(GatherDataEvent e) {
        MoonMagic.getLogger().info("Generate Data...");
        DataGenerator generator = e.getGenerator();
        generator.addProvider(new MoonMagicLootTableProvider(generator));
    }
}
