package com.legacy.aether.item.weapon;

import com.legacy.aether.item.ItemsAether;
import com.legacy.aether.item.util.AetherTier;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;

import java.util.Random;

public class ItemCandyCaneSword extends ItemAetherSword {

    public ItemCandyCaneSword() {
        super(AetherTier.Candy, 3, -2.0F);
    }

    @Override
    public boolean postHit(ItemStack itemstack, LivingEntity entityliving, LivingEntity entityliving1) {
        // TODO: deathCounter replace ???
        if (entityliving.deathTime > 0) {
            return true;
        } else {
            if ((new Random()).nextBoolean() && entityliving1 != null && entityliving1 instanceof PlayerEntity && !entityliving1.world.isClient && entityliving.hurtTime > 0) {
                entityliving.dropItem(ItemsAether.candy_cane, 1);
            }

            itemstack.damage(1, entityliving1, null);
            return true;
        }
    }

}