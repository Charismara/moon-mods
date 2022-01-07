package de.blutmondgilde.moonapi.network;

import de.blutmondgilde.moonapi.MoonApi;
import de.blutmondgilde.moonapi.network.packet.SyncSimpleCapabilityPacket;
import lombok.Getter;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.simple.SimpleChannel;

public class MoonNetwork {
    private static final String PROTOCOL_VERSION = String.valueOf(1);
    @Getter
    private static final SimpleChannel channel = NetworkRegistry.newSimpleChannel(
        new ResourceLocation(MoonApi.MOD_ID, "main"),
        () -> PROTOCOL_VERSION, PROTOCOL_VERSION::equals, PROTOCOL_VERSION::equals);

    public static void registerPackets() {
        int index = 1;
        channel.registerMessage(index, SyncSimpleCapabilityPacket.class, SyncSimpleCapabilityPacket::encode, SyncSimpleCapabilityPacket::new, SyncSimpleCapabilityPacket::handle);
    }
}
