package de.blutmondgilde.moonapi.network.packet;

import de.blutmondgilde.moonapi.MoonApi;
import de.blutmondgilde.moonapi.capability.CapabilityType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.fmllegacy.network.NetworkEvent;

import java.util.function.Supplier;

@AllArgsConstructor
@Getter
public class SyncSimpleCapabilityPacket {
    private final CapabilityType type;
    private final ResourceLocation resourceLocation;
    private final CompoundTag data;

    public SyncSimpleCapabilityPacket(FriendlyByteBuf buffer) {
        this.type = buffer.readEnum(CapabilityType.class);
        this.resourceLocation = buffer.readResourceLocation();
        this.data = buffer.readAnySizeNbt();
    }

    public static void encode(SyncSimpleCapabilityPacket msg, FriendlyByteBuf buffer) {
        buffer.writeEnum(msg.type);
        buffer.writeResourceLocation(msg.resourceLocation);
        buffer.writeNbt(msg.data);
    }

    public static void handle(SyncSimpleCapabilityPacket msg, Supplier<NetworkEvent.Context> contextSupplier) {
        contextSupplier.get().enqueueWork(() -> {
            switch (msg.type) {
                case ENTITY -> MoonApi.getProxy().updateEntityCapability(msg);
            }
        });
        contextSupplier.get().setPacketHandled(true);
    }
}
