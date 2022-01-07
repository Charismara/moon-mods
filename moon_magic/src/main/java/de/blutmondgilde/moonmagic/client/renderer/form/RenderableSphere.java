package de.blutmondgilde.moonmagic.client.renderer.form;

import com.mojang.blaze3d.vertex.BufferBuilder;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.Tesselator;
import net.minecraft.client.renderer.MultiBufferSource;

public class RenderableSphere {
    private static final int resolution = 15;
    private static final int startU = 0;
    private static final int startV = 0;
    private static final double endV = Math.PI;
    private static final double endU = endV * 2;
    private static final double stepU = (endU - startU) / resolution;
    private static final double stepV = (endV - startV) / (resolution / 2.0);

    public void render(PoseStack pPoseStack, MultiBufferSource buffer) {
        Tesselator tesselator = Tesselator.getInstance();
        BufferBuilder builder = tesselator.getBuilder();
        builder.vertex(pPoseStack.last().pose(),0,0,0);
    }
}
