package de.blutmondgilde.moonmagic;

import de.blutmondgilde.moonapi.capability.AttachmentPredicate;
import de.blutmondgilde.moonapi.capability.CapabilityType;
import de.blutmondgilde.moonapi.capability.MoonCapabilityHandler;
import de.blutmondgilde.moonapi.capability.SimpleCapability;
import de.blutmondgilde.moonmagic.client.ClientProxy;
import de.blutmondgilde.moonmagic.data.MoonMagicDataGenerator;
import de.blutmondgilde.moonmagic.registry.MoonMagicRegistries;
import de.blutmondgilde.moonmagic.testing.ITestCap;
import de.blutmondgilde.moonmagic.testing.TestCap;
import de.blutmondgilde.moonmagic.testing.TestCapHolder;
import lombok.Getter;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(MoonMagic.MOD_ID)
public class MoonMagic {
    public static final String MOD_ID = "moon_magic";
    @Getter
    private static final Logger Logger = LogManager.getLogger();
    @Getter
    private final CommonProxy proxy;

    public MoonMagic() {
        proxy = DistExecutor.safeRunForDist(() -> ClientProxy::new, () -> CommonProxy::new);

        IEventBus modBus = FMLJavaModLoadingContext.get().getModEventBus();
        modBus.addListener(this::setup);
        modBus.addListener(this::clientSetup);
        modBus.addListener(MoonMagicDataGenerator::onGatherData);

        registerCapabilities();
        MoonMagicRegistries.init();
    }

    private void setup(final FMLCommonSetupEvent event) {}

    private void clientSetup(final FMLClientSetupEvent event) {
        this.proxy.initClient();
    }

    private void registerCapabilities() {
        SimpleCapability<?>[] capabilities = {
            SimpleCapability.of(new ResourceLocation(MOD_ID, "stages"),
                CapabilityType.ENTITY,
                AttachmentPredicate.builder().canAttachToEntity(entity -> entity instanceof Player).build(),
                () -> new TestCap(() -> TestCapHolder.TEST_CAP),
                ITestCap.class,
                () -> TestCapHolder.TEST_CAP)
        };

        for (SimpleCapability<?> capability : capabilities) {
            MoonCapabilityHandler.register(capability);
        }
    }
}
