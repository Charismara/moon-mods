package de.blutmondgilde.moonmagic.client.renderer;

import com.mojang.blaze3d.vertex.DefaultVertexFormat;
import com.mojang.blaze3d.vertex.VertexFormat;
import de.blutmondgilde.moonmagic.MoonMagic;
import de.blutmondgilde.moonmagic.block.entity.MoonMagicBlockEntities;
import net.minecraft.client.renderer.RenderStateShard;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.inventory.InventoryMenu;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ForgeModelBakery;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

public class MoonMagicRenderer {
    public static final ResourceLocation PYLON_CORE_CENTER = new ResourceLocation(MoonMagic.MOD_ID, "block/pylon_core");
    public static final ResourceLocation PYLON_CORE_RING_1 = new ResourceLocation(MoonMagic.MOD_ID, "block/pylon_core/pylon_core_1");
    public static final ResourceLocation PYLON_CORE_RING_2 = new ResourceLocation(MoonMagic.MOD_ID, "block/pylon_core/pylon_core_2");
    public static final ResourceLocation PYLON_CORE_RING_3 = new ResourceLocation(MoonMagic.MOD_ID, "block/pylon_core/pylon_core_3");
    public static final ResourceLocation PYLON_CORE_RING_4 = new ResourceLocation(MoonMagic.MOD_ID, "block/pylon_core/pylon_core_4");
    public static final RenderType PYLON_TYPE = RenderType.create("moon_magic_pylon",
        DefaultVertexFormat.BLOCK,
        VertexFormat.Mode.QUADS,
        RenderType.MEDIUM_BUFFER_SIZE,
        false,
        true,
        RenderType.CompositeState.builder()
            .setTextureState(new RenderStateShard.TextureStateShard(InventoryMenu.BLOCK_ATLAS, false, false))
            .setTransparencyState(RenderStateShard.TRANSLUCENT_TRANSPARENCY)
            .setCullState(RenderStateShard.NO_CULL)
            .setLightmapState(RenderStateShard.LIGHTMAP)
            .setOverlayState(RenderStateShard.OVERLAY)
            .createCompositeState(false));

    public static void init() {
        //ItemBlockRenderTypes.setRenderLayer(MoonMagicBlocks.PYLON_CORE, PYLON_TYPE);
    }

    public static void registerEventListeners() {
        IEventBus modBus = FMLJavaModLoadingContext.get().getModEventBus();
        modBus.addListener(MoonMagicRenderer::registerRenderer);
        modBus.addListener(MoonMagicRenderer::registerModels);
    }

    private static void registerRenderer(final EntityRenderersEvent.RegisterRenderers e) {
        e.registerBlockEntityRenderer(MoonMagicBlockEntities.PYLON_CORE, PylonCoreRenderer::new);
    }

    private static void registerModels(final ModelRegistryEvent e) {
        ForgeModelBakery.addSpecialModel(PYLON_CORE_CENTER);
        ForgeModelBakery.addSpecialModel(PYLON_CORE_RING_1);
        ForgeModelBakery.addSpecialModel(PYLON_CORE_RING_2);
        ForgeModelBakery.addSpecialModel(PYLON_CORE_RING_3);
        ForgeModelBakery.addSpecialModel(PYLON_CORE_RING_4);
    }
}
