package de.blutmondgilde.moonapi;

import de.blutmondgilde.moonapi.capability.MoonCapabilityHandler;
import de.blutmondgilde.moonapi.network.MoonNetwork;
import lombok.Getter;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(MoonApi.MOD_ID)
public class MoonApi {
    public static final String MOD_ID = "moon_api";
    @Getter
    private static final Logger Logger = LogManager.getLogger("MoonAPI");
    @Getter
    private static CommonProxy proxy = null;

    public MoonApi() {
        proxy = DistExecutor.safeRunForDist(() -> ClientProxy::new, () -> CommonProxy::new);

        IEventBus modBus = FMLJavaModLoadingContext.get().getModEventBus();
        modBus.addListener(this::setup);
        modBus.addListener(this::clientSetup);

        MoonCapabilityHandler.initialize();
    }

    private void setup(final FMLCommonSetupEvent event) {
        event.enqueueWork(MoonNetwork::registerPackets);
    }

    private void clientSetup(final FMLClientSetupEvent event) {
        event.enqueueWork(proxy::clientSetup);
    }
}
