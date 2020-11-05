package com.legacy.aether.client.rendering.entity;

import com.legacy.aether.api.AetherAPI;
import com.legacy.aether.api.player.IPlayerAether;
import com.legacy.aether.client.model.MoaModel;
import com.legacy.aether.client.rendering.entity.layer.MoaSaddleLayer;
import com.legacy.aether.entities.passive.EntityMoa;
import com.legacy.aether.player.PlayerAether;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import org.lwjgl.opengl.GL11;

public class MoaRenderer extends MobEntityRenderer<EntityMoa, MoaModel> {

    public MoaRenderer(EntityRenderDispatcher renderManager) {
        super(renderManager, new MoaModel(0.0F), 1.0F);

        // TODO: ???
        //this.addFeature(new MoaCustomizerLayer(renderManager, (MoaModel) this.getModel()));
        this.addFeature(new MoaSaddleLayer(this));
    }

    @Override
    protected float getAnimationProgress(EntityMoa moa, float f) {
        float f1 = moa.prevWingRotation + (moa.wingRotation - moa.prevWingRotation) * f;
        float f2 = moa.prevDestPos + (moa.destPos - moa.prevDestPos) * f;

        return (MathHelper.sin(f1) + 1.0F) * f2;
    }

    @Override
    protected void scale(EntityMoa moa, MatrixStack matrixStack, float f) {
        float moaScale = moa.isBaby() ? 1.0F : 1.8F;

        GL11.glScalef(moaScale, moaScale, moaScale);
    }

    @Override
    public Identifier getTexture(EntityMoa entity) {
        EntityMoa moa = entity;

        if (moa.hasPassengers() && moa.getPassengerList().get(0) instanceof PlayerEntity) {
            IPlayerAether player = AetherAPI.get((PlayerEntity) moa.getPassengerList().get(0));

            if (player instanceof PlayerAether && !((PlayerAether) player).donationPerks.getMoaSkin().shouldUseDefualt()) {
                return null;
            }
        }

        return moa.getMoaType().getTexture(false);
    }

}
