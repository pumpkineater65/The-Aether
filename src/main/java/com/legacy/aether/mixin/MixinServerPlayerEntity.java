package com.legacy.aether.mixin;

import com.legacy.aether.util.PlayerTeleportationData;
import net.minecraft.server.network.ServerPlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(ServerPlayerEntity.class)
public class MixinServerPlayerEntity implements PlayerTeleportationData {

    @Shadow
    private float syncedHealth;

    @Shadow
    private int syncedExperience;

    @Shadow
    private int syncedFoodLevel;

    @Shadow
    private boolean inTeleportationState;

    @Override
    public void setPlayerTeleporting() {
        this.inTeleportationState = true;
    }

    @Override
    public void afterTeleportation() {
        this.syncedExperience = -1;
        this.syncedHealth = -1.0F;
        this.syncedFoodLevel = -1;
    }

}