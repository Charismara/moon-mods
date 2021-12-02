package de.blutmondgilde.moonmagic.testing;

import de.blutmondgilde.moonapi.MoonApi;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.event.ServerChatEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.UUID;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class TestCapHolder {
    public static final Capability<ITestCap> TEST_CAP = CapabilityManager.get(new CapabilityToken<>() {});

    @SubscribeEvent
    public static void onChatMessage(ServerChatEvent e) {
        e.getPlayer().getCapability(TestCapHolder.TEST_CAP).ifPresent(iTestCap -> {
            String uuid = UUID.randomUUID().toString();
            MoonApi.getLogger().info("Current Value: {}, New Value: {}", iTestCap.getValue(), uuid);
            iTestCap.setValue(uuid);
        });
    }
}
