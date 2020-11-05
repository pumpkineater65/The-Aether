package com.legacy.aether.client.rendering;

import com.legacy.aether.api.player.IPlayerAether;
import com.legacy.aether.item.ItemsAether;
import com.legacy.aether.item.accessory.ItemAccessory;
import com.mojang.blaze3d.platform.GlStateManager;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.client.render.entity.model.PlayerEntityModel;

public class AetherFirstPersonRenderer {

    private static BipedEntityModel<AbstractClientPlayerEntity> gloveModel = new BipedEntityModel<AbstractClientPlayerEntity>(0.01F);

    private static BipedEntityModel<AbstractClientPlayerEntity> slimGloveModel = new PlayerEntityModel<AbstractClientPlayerEntity>(0.01F, true);

    public static void renderRightGlove(IPlayerAether player, ItemAccessory gloves) {
        boolean isSlim = ((AbstractClientPlayerEntity) player.getPlayer()).getModel().equals("slim");
        MinecraftClient.getInstance().getEntityRenderDispatcher().textureManager.bindTexture(gloves.getTexture(isSlim));

        int colour = gloves.getColor();
        float red = ((colour >> 16) & 0xff) / 255F;
        float green = ((colour >> 8) & 0xff) / 255F;
        float blue = (colour & 0xff) / 255F;

        if (gloves != ItemsAether.phoenix_gloves) {
            GlStateManager.color4f(red, green, blue, 1.0F);
        }

        GlStateManager.enableBlend();
        getModel(isSlim).handSwingProgress = 0.0F; // TODO: Verify.
        getModel(isSlim).sneaking = false;
        getModel(isSlim).setAngles((AbstractClientPlayerEntity) player.getPlayer(), 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
        getModel(isSlim).rightArm.pitch = 0.0F;
        //getModel(isSlim).rightArm.render(0.0625F);
        GlStateManager.disableBlend();

        GlStateManager.color4f(1.0F, 1.0F, 1.0F, 1.0F);
    }

    public static void renderLeftGlove(IPlayerAether player, ItemAccessory gloves) {
        boolean isSlim = ((AbstractClientPlayerEntity) player.getPlayer()).getModel().equals("slim");
        MinecraftClient.getInstance().getEntityRenderDispatcher().textureManager.bindTexture(gloves.getTexture(isSlim));

        int colour = gloves.getColor();
        float red = ((colour >> 16) & 0xff) / 255F;
        float green = ((colour >> 8) & 0xff) / 255F;
        float blue = (colour & 0xff) / 255F;

        if (gloves != ItemsAether.phoenix_gloves) {
            GlStateManager.color4f(red, green, blue, 255f);
        }

        GlStateManager.enableBlend();
        getModel(isSlim).handSwingProgress = 0.0F;
        getModel(isSlim).sneaking = false;
        getModel(isSlim).setAngles((AbstractClientPlayerEntity) player.getPlayer(), 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
        getModel(isSlim).leftArm.pitch = 0.0F;
        //getModel(isSlim).leftArm.render(0.0625F);
        GlStateManager.disableBlend();

        GlStateManager.color4f(1.0F, 1.0F, 1.0F, 1.0F);
    }

    private static BipedEntityModel<AbstractClientPlayerEntity> getModel(boolean isSlim) {
        return isSlim ? slimGloveModel : gloveModel;
    }

}