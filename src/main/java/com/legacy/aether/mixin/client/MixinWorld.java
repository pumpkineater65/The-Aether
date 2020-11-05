package com.legacy.aether.mixin.client;

//import com.legacy.aether.world.WorldAether;
import net.minecraft.world.MutableWorldProperties;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.level.LevelProperties;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(World.class)
public class MixinWorld {

    @Shadow
    @Final
    public DimensionType dimension;

    @Shadow
    @Final
    protected MutableWorldProperties properties;

    // TODO: 1.15.1
	/*@Inject(method = "getHorizonHeight", at = @At("RETURN"), cancellable = true)
	public void getAetherColorCutoff(CallbackInfoReturnable<Double> distance)
	{
		if (this.dimension == WorldAether.THE_AETHER)
		{
			double newDistance = -256.0D;

			distance.setReturnValue(newDistance);
		}
	}*/

}