package de.blutmondgilde.moonapi;

import de.blutmondgilde.moonapi.capability.CapabilityHandler;
import de.blutmondgilde.moonapi.capability.CapabilityType;
import de.blutmondgilde.moonapi.network.packet.SyncSimpleCapabilityPacket;
import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.Entity;

public class ClientProxy extends CommonProxy {
    @Override
    public void updateEntityCapability(SyncSimpleCapabilityPacket packet) {
        CapabilityHandler.find(packet.getResourceLocation(), CapabilityType.ENTITY).ifPresent(simpleCapability -> {
            if (Minecraft.getInstance().level == null) return;

            int entityId = packet.getData().getInt("entityId");
            Entity target = Minecraft.getInstance().level.getEntity(entityId);
            if (target == null) return;

            target.getCapability(simpleCapability.getCapabilityReference().get()).ifPresent(capability -> {
                capability.deserializeNBT(packet.getData());
                MoonApi.getLogger().info("Updated {} Capability", packet.getResourceLocation());
            });
        });
    }
}
