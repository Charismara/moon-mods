package de.blutmondgilde.moonmagic;

import lombok.Getter;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod("moon_magic")
public class MoonMagic {
    @Getter
    private static final Logger Logger = LogManager.getLogger();

    public MoonMagic() {
        IEventBus modBus = FMLJavaModLoadingContext.get().getModEventBus();
        modBus.addListener(this::setup);
    }

    private void setup(final FMLCommonSetupEvent event) {}
}
