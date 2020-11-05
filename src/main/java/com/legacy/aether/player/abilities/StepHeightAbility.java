package com.legacy.aether.player.abilities;

import com.legacy.aether.api.player.IPlayerAether;
import com.legacy.aether.api.player.util.AetherAbility;
import com.legacy.aether.item.ItemsAether;
import net.minecraft.item.ItemStack;

public class StepHeightAbility implements AetherAbility {

    private final IPlayerAether playerAether;
    private boolean update;

    public StepHeightAbility(IPlayerAether playerAether) {
        this.playerAether = playerAether;
    }

    @Override
    public boolean shouldExecute() {
        boolean execute = this.playerAether.getAccessoryInventory().wearingAccessory(new ItemStack(ItemsAether.agility_cape));

        if (execute) {
            this.update = true;
            this.playerAether.getPlayer().stepHeight = 1.0F;
        } else if (this.update) {
            this.update = false;
            this.playerAether.getPlayer().stepHeight = 0.6F;
        }

        return execute;
    }

    @Override
    public void update() {

    }

}