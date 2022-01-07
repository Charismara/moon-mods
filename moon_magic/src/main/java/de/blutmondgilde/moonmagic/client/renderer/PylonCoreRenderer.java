package de.blutmondgilde.moonmagic.client.renderer;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import de.blutmondgilde.moonmagic.block.entity.PylonCoreEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.model.data.EmptyModelData;
import net.minecraftforge.client.model.data.ModelDataMap;

import java.util.List;
import java.util.Random;
import java.util.function.Consumer;

public class PylonCoreRenderer implements BlockEntityRenderer<PylonCoreEntity> {

    public PylonCoreRenderer(BlockEntityRendererProvider.Context context) {}

    @Override
    public void render(PylonCoreEntity pBlockEntity, float pPartialTick, PoseStack pPoseStack, MultiBufferSource buffer, int pPackedLight, int pPackedOverlay) {
        renderModel(pPoseStack, buffer, MoonMagicRenderer.PYLON_CORE_CENTER, pPackedLight);
        /*
        renderObjModel(MoonMagicRenderer.PYLON_CORE_RING_1, pPoseStack, buffer, pPackedLight, pPackedOverlay, stack -> {
            //TODO Translation
        });
        renderObjModel(MoonMagicRenderer.PYLON_CORE_RING_2, pPoseStack, buffer, pPackedLight, pPackedOverlay, stack -> {
            //TODO Translation
        });
        renderObjModel(MoonMagicRenderer.PYLON_CORE_RING_3, pPoseStack, buffer, pPackedLight, pPackedOverlay, stack -> {
            //TODO Translation
        });
        renderObjModel(MoonMagicRenderer.PYLON_CORE_RING_4, pPoseStack, buffer, pPackedLight, pPackedOverlay, stack -> {
            //TODO Translation
        });
         */
    }

    private void renderObjModel(ResourceLocation location, PoseStack matrices, MultiBufferSource buffer, int light, int overlay, @Deprecated Consumer<PoseStack> transforms, RenderType type) {
        List<BakedQuad> list = Minecraft.getInstance().getModelManager().getModel(location)
            .getQuads(null, null, new Random(), new ModelDataMap.Builder().build());

        VertexConsumer consumer = buffer.getBuffer(type);
        matrices.pushPose();
        transforms.accept(matrices);
        for (BakedQuad a : list) {
            consumer.putBulkData(matrices.last(), a, 1f, 1f, 1f, light, overlay);
        }
        matrices.popPose();
    }

    private static void renderModel(PoseStack matrixStack, MultiBufferSource buffer, ResourceLocation modelLocation, int packedLight) {
        BakedModel model = Minecraft.getInstance().getModelManager().getModel(modelLocation);
        Random random = new Random();
        random.setSeed(42L);
        List<BakedQuad> quads = model.getQuads(null, null, random, EmptyModelData.INSTANCE);
        VertexConsumer vertexBuilder = ItemRenderer.getFoilBuffer(buffer, MoonMagicRenderer.PYLON_TYPE, false, false);

        PoseStack.Pose matrixEntry = matrixStack.last();

        RenderSystem.enableBlend();
        for (BakedQuad quad : quads) {
            vertexBuilder.putBulkData(matrixEntry, quad, 1f, 1f, 1f, 1f, packedLight, OverlayTexture.NO_OVERLAY, true);
        }
    }
}
