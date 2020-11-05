package com.legacy.aether.client.rendering.entity.layer;

import com.legacy.aether.entities.passive.EntityPhyg;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.feature.FeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.client.render.entity.model.PigEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class PhygSaddleLayer extends FeatureRenderer<EntityPhyg, PigEntityModel<EntityPhyg>> {

    private static final Identifier TEXTURE = new Identifier("textures/entity/pig/pig_saddle.png");

    private final PigEntityModel<EntityPhyg> model = new PigEntityModel<EntityPhyg>(0.5F);

    public PhygSaddleLayer(FeatureRendererContext<EntityPhyg, PigEntityModel<EntityPhyg>> context) {
        super(context);
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, EntityPhyg phyg, float limbAngle, float limbDistance, float tickDelta, float customAngle, float netHeadYaw, float headPitch) {
        if (phyg.getSaddled()) {
            this.getContextModel().copyStateTo(this.model);
            //this.model.copyStateTo(this.getModel());
            VertexConsumer vertexConsumer = vertexConsumers.getBuffer(RenderLayer.getEntityCutoutNoCull(TEXTURE));
            this.model.render(matrices, vertexConsumer, light, OverlayTexture.DEFAULT_UV, 1.0F, 1.0F, 1.0F, 1.0F);
        }
    }

    // TODO: ???
    /*@Override
    public boolean hasHurtOverlay()
    {
        return false;
    }*/

}
