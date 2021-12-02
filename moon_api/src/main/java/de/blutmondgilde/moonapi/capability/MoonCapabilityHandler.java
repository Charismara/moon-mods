package de.blutmondgilde.moonapi.capability;

import de.blutmondgilde.moonapi.MoonApi;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.chunk.LevelChunk;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.jetbrains.annotations.ApiStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SuppressWarnings("rawtypes")
public class MoonCapabilityHandler {
    private static final ArrayList<SimpleCapability<?>> entityCapabilities = new ArrayList<>();
    private static final ArrayList<SimpleCapability<?>> blockEntityCapabilities = new ArrayList<>();
    private static final ArrayList<SimpleCapability<?>> itemCapabilities = new ArrayList<>();
    private static final ArrayList<SimpleCapability<?>> worldCapabilities = new ArrayList<>();
    private static final ArrayList<SimpleCapability<?>> chunkCapabilities = new ArrayList<>();

    @ApiStatus.Internal
    public static void initialize() {
        IEventBus forgeBus = MinecraftForge.EVENT_BUS;
        forgeBus.addGenericListener(Entity.class, MoonCapabilityHandler::attachToEntity);
        forgeBus.addGenericListener(BlockEntity.class, MoonCapabilityHandler::attachToTileEntity);
        forgeBus.addGenericListener(ItemStack.class, MoonCapabilityHandler::attachToItem);
        forgeBus.addGenericListener(Level.class, MoonCapabilityHandler::attachToWorld);
        forgeBus.addGenericListener(LevelChunk.class, MoonCapabilityHandler::attachToChunk);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(MoonCapabilityHandler::registerCapabilities);

        forgeBus.addListener(MoonCapabilityHandler::syncPlayerLoggedIn);
        forgeBus.addListener(MoonCapabilityHandler::syncPlayerDimChange);
        forgeBus.addListener(MoonCapabilityHandler::syncPlayerRespawn);
        forgeBus.addListener(MoonCapabilityHandler::syncPlayerStartTracking);
    }

    private static void registerCapabilities(RegisterCapabilitiesEvent e) {
        MoonApi.getLogger().info("Registering {} entity capabilities", entityCapabilities.size());
        register(entityCapabilities, e);
        MoonApi.getLogger().info("Registering {} block_entity capabilities", blockEntityCapabilities.size());
        register(blockEntityCapabilities, e);
        MoonApi.getLogger().info("Registering {} item capabilities", itemCapabilities.size());
        register(itemCapabilities, e);
        MoonApi.getLogger().info("Registering {} world capabilities", worldCapabilities.size());
        register(worldCapabilities, e);
        MoonApi.getLogger().info("Registering {} chunk capabilities", chunkCapabilities.size());
        register(chunkCapabilities, e);
    }

    private static void register(List<SimpleCapability<?>> capabilities, RegisterCapabilitiesEvent e) {
        capabilities.forEach(simpleCapability -> {
            MoonApi.getLogger().info("Registering Capablility {}", simpleCapability.getResourceLocation().toString());
            e.register(simpleCapability.getCapabilityInterface());
        });
    }

    /** Registers a {@link SimpleCapability} to the Moon Capability System. */
    public static SimpleCapability<?> register(SimpleCapability<?> simpleCapability) {

        switch (simpleCapability.getType()) {
            case ENTITY -> entityCapabilities.add(simpleCapability);
            case BLOCK_ENTITY -> blockEntityCapabilities.add(simpleCapability);
            case ITEM -> itemCapabilities.add(simpleCapability);
            case WORLD -> worldCapabilities.add(simpleCapability);
            case CHUNK -> chunkCapabilities.add(simpleCapability);
        }
        return simpleCapability;
    }

    public static Optional<SimpleCapability<?>> find(ResourceLocation id, CapabilityType type) {
        return switch (type) {
            case ENTITY -> entityCapabilities
                .stream()
                .filter(simpleCapability -> simpleCapability.getResourceLocation().equals(id))
                .findFirst();
            case CHUNK -> chunkCapabilities //TODO implementation
                .stream()
                .filter(simpleCapability -> simpleCapability.getResourceLocation().equals(id))
                .findFirst();
            case BLOCK_ENTITY -> blockEntityCapabilities //TODO implementation
                .stream()
                .filter(simpleCapability -> simpleCapability.getResourceLocation().equals(id))
                .findFirst();
            case WORLD -> worldCapabilities //TODO implementation
                .stream()
                .filter(simpleCapability -> simpleCapability.getResourceLocation().equals(id))
                .findFirst();
            case ITEM -> itemCapabilities //TODO implementation
                .stream()
                .filter(simpleCapability -> simpleCapability.getResourceLocation().equals(id))
                .findFirst();
        };
    }

    /* ===================== Attachment Events ===================== */

    private static void attachToEntity(AttachCapabilitiesEvent<Entity> e) {
        for (SimpleCapability capability : entityCapabilities) {
            if (capability.getAttachmentPredicate().getCanAttachToEntity().test(e.getObject())) {
                e.addCapability(capability.getResourceLocation(), (ICapabilityProvider) capability.getDefaultInstance().get());
            }
        }
    }

    private static void attachToTileEntity(AttachCapabilitiesEvent<BlockEntity> e) {
        for (SimpleCapability capability : blockEntityCapabilities) {
            if (capability.getAttachmentPredicate().getCanAttachToBlockEntity().test(e.getObject())) {
                e.addCapability(capability.getResourceLocation(), (ICapabilityProvider) capability.getDefaultInstance().get());
            }
        }
    }

    private static void attachToItem(AttachCapabilitiesEvent<ItemStack> e) {
        for (SimpleCapability capability : itemCapabilities) {
            if (capability.getAttachmentPredicate().getCanAttachToItemStack().test(e.getObject())) {
                e.addCapability(capability.getResourceLocation(), (ICapabilityProvider) capability.getDefaultInstance().get());
            }
        }
    }

    private static void attachToWorld(AttachCapabilitiesEvent<Level> e) {
        for (SimpleCapability capability : worldCapabilities) {
            if (capability.getAttachmentPredicate().getCanAttachToWorld().test(e.getObject())) {
                e.addCapability(capability.getResourceLocation(), (ICapabilityProvider) capability.getDefaultInstance().get());
            }
        }
    }

    private static void attachToChunk(AttachCapabilitiesEvent<LevelChunk> e) {
        for (SimpleCapability capability : chunkCapabilities) {
            if (capability.getAttachmentPredicate().getCanAttachToChunk().test(e.getObject())) {
                e.addCapability(capability.getResourceLocation(), (ICapabilityProvider) capability.getDefaultInstance().get());
            }
        }
    }

    /* ===================== Sync Entity Events ===================== */

    private static void syncPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent e) {
        final Player player = e.getPlayer();
        entityCapabilities.forEach(simpleCapability -> {
            player.getCapability(simpleCapability.getCapabilityReference().get()).ifPresent(abstractMoonCapability -> {
                simpleCapability.sync(abstractMoonCapability, player);
            });
        });
    }

    private static void syncPlayerRespawn(PlayerEvent.PlayerRespawnEvent e) {
        final Player player = e.getPlayer();
        entityCapabilities.forEach(simpleCapability -> {
            player.getCapability(simpleCapability.getCapabilityReference().get()).ifPresent(abstractMoonCapability -> {
                simpleCapability.sync(abstractMoonCapability, player);
            });
        });
    }

    private static void syncPlayerDimChange(PlayerEvent.PlayerChangedDimensionEvent e) {
        final Player player = e.getPlayer();
        entityCapabilities.forEach(simpleCapability -> {
            player.getCapability(simpleCapability.getCapabilityReference().get()).ifPresent(abstractMoonCapability -> {
                simpleCapability.sync(abstractMoonCapability, player);
            });
        });
    }

    private static void syncPlayerStartTracking(PlayerEvent.StartTracking e) {
        final Entity target = e.getTarget();
        entityCapabilities.forEach(simpleCapability -> {
            target.getCapability(simpleCapability.getCapabilityReference().get()).ifPresent(abstractMoonCapability -> {
                simpleCapability.sync(abstractMoonCapability, target);
            });
        });
    }
}
