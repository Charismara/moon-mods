package de.blutmondgilde.moonapi.capability;

import de.blutmondgilde.moonapi.network.MoonNetwork;
import de.blutmondgilde.moonapi.network.packet.SyncSimpleCapabilityPacket;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.Lazy;
import net.minecraftforge.fmllegacy.network.PacketDistributor;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class SimpleCapability<T extends AbstractMoonCapability & IMoonCapability> {
    @Getter
    private final ResourceLocation resourceLocation;
    @Getter
    private final CapabilityType type;
    @Getter
    private final AttachmentPredicate attachmentPredicate;
    @Getter
    private final Lazy<T> defaultInstance;
    @Getter
    private final Class<? extends IMoonCapability> capabilityInterface;
    @Getter
    private final Lazy<Capability<? extends IMoonCapability>> capabilityReference;

    public static <T extends AbstractMoonCapability & IMoonCapability> SimpleCapability<T> of(ResourceLocation resourceLocation, CapabilityType type, AttachmentPredicate attachmentPredicate,
                                                                                              Lazy<T> defaultInstance, Class<? extends IMoonCapability> capabilityInterface,
                                                                                              Lazy<Capability<? extends IMoonCapability>> capabilityReference) {
        return new SimpleCapability<>(resourceLocation, type, attachmentPredicate, defaultInstance, capabilityInterface, capabilityReference);
    }

    public void sync(IMoonCapability capability, Entity target) {
        CompoundTag tag = capability.serializeNBT();
        tag.putInt("entityId", target.getId());
        MoonNetwork.getChannel().send(PacketDistributor.TRACKING_ENTITY_AND_SELF.with(() -> target), new SyncSimpleCapabilityPacket(this.type, this.resourceLocation, tag));
    }
}
