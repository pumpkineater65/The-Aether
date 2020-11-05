package com.legacy.aether.mixin.client;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerInteractionManager;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(ClientPlayerInteractionManager.class)
public class MixinClientPlayerInteractionManager {

    @Shadow
    @Final
    private MinecraftClient client;

	/*@Inject(method = "getReachDistance", at = @At("RETURN"), cancellable = true)
	public void setAetherReachDistance(CallbackInfoReturnable<Float> ci)
	{
		if (this.client.player != null)
		{
			float original = ci.getReturnValue();

			ci.setReturnValue(AetherAPI.get(this.client.player).setReachDistance(original));
		}
	}*/

}