package com.aether.mixin.structure;

import com.aether.blocks.AetherBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.world.gen.feature.Feature;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Feature.class)
public class FeatureMixin {

    @Inject(method = {"isSoil(Lnet/minecraft/block/BlockState;)Z"}, at = {@At("HEAD")}, cancellable = true)
    private static void isSoil(BlockState block, CallbackInfoReturnable<Boolean> cir) {
        if(block.isOf(AetherBlocks.AETHER_DIRT) || block.isOf(AetherBlocks.AETHER_GRASS) || block.isOf(AetherBlocks.AETHER_ENCHANTED_GRASS) || block.isOf(AetherBlocks.AETHER_FARMLAND)) {
            cir.setReturnValue(true);
            cir.cancel();
        }
    }
}
