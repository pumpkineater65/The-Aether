package com.legacy.aether.mixin.client;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.item.HeldItemRenderer;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(HeldItemRenderer.class)
public class MixinFirstPersonRenderer {

    @Shadow
    @Final
    private MinecraftClient client;

    // TODO: FIXME
	/*@Inject(method = "renderArm", at = @At("RETURN"))
	private void renderGlove(Hand handIn, CallbackInfo ci)
	{
		IPlayerAether playerAether = AetherAPI.get(this.client.player);

		if (!playerAether.getAccessoryInventory().getInvStack(AccessoryType.GLOVES).isEmpty())
		{
			GlStateManager.pushMatrix();

			float float_1 = handIn == Hand.MAIN_HAND ? 1.0F : -1.0F;

			GlStateManager.rotatef(92.0F, 0.0F, 1.0F, 0.0F);
			GlStateManager.rotatef(45.0F, 1.0F, 0.0F, 0.0F);
			GlStateManager.rotatef(float_1 * -41.0F, 0.0F, 0.0F, 1.0F);
			GlStateManager.translatef(float_1 * 0.3F, -1.1F, 0.45F);

			if (handIn == Hand.MAIN_HAND)
			{
				AetherFirstPersonRenderer.renderRightGlove(playerAether, (ItemAccessory) playerAether.getAccessoryInventory().getInvStack(AccessoryType.GLOVES).getItem());
			}
			else
			{
				AetherFirstPersonRenderer.renderLeftGlove(playerAether, (ItemAccessory) playerAether.getAccessoryInventory().getInvStack(AccessoryType.GLOVES).getItem());
			}

			GlStateManager.popMatrix();
		}
	}*/

    // TODO: Use HeldItemRenderer in 1.15.1
	/*@Inject(method = "renderArmHoldingItem", at = @At(value = "INVOKE", target = "net/minecraft/client/render/FirstPersonRenderer.renderArmHoldingItem(FFLnet/minecraft/util/Arm;)V"))
	private void renderArmHoldingItem(MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i, float f, float g, Arm armIn, CallbackInfo ci)
	{
		IPlayerAether playerAether = AetherAPI.get(this.client.player);

		if (!playerAether.getAccessoryInventory().getInvStack(AccessoryType.GLOVES).isEmpty())
		{
			AetherFirstPersonRenderer.renderRightGlove(playerAether, (ItemAccessory) playerAether.getAccessoryInventory().getInvStack(AccessoryType.GLOVES).getItem());

			this.client.getTextureManager().bindTexture(this.client.player.getSkinTexture());
		}
	}*/

    // TODO: FIXME
	/*@Inject(method = "renderLeftArm", at = @At(value = "INVOKE", target = "net/minecraft/client/render/entity/PlayerEntityRenderer.renderLeftArm(Lnet/minecraft/client/network/AbstractClientPlayerEntity;)V"))
	private void renderLeftGlove(float float_1, float float_2, Hand handIn, CallbackInfo ci)
	{
		IPlayerAether playerAether = AetherAPI.get(this.client.player);

		if (!playerAether.getAccessoryInventory().getInvStack(AccessoryType.GLOVES).isEmpty())
		{
			AetherFirstPersonRenderer.renderLeftGlove(playerAether, (ItemAccessory) playerAether.getAccessoryInventory().getInvStack(AccessoryType.GLOVES).getItem());

			this.client.getTextureManager().bindTexture(this.client.player.getSkinTexture());
		}
	}*/

}