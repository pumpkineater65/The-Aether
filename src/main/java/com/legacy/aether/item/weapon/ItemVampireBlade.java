package com.legacy.aether.item.weapon;

import com.legacy.aether.item.ItemsAether;
import com.legacy.aether.item.util.AetherTier;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;

public class ItemVampireBlade extends ItemAetherSword {

    public ItemVampireBlade() {
        super(AetherTier.Legendary, ItemsAether.AETHER_LOOT, 3, -2.4F);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (!(attacker instanceof PlayerEntity)) {
            return super.postHit(stack, target, attacker);
        }

        PlayerEntity player = (PlayerEntity) attacker;

        if (player.getHealth() < player.getMaxHealth()) {
            player.heal(1.0F);
        }

        return super.postHit(stack, target, attacker);
    }

}