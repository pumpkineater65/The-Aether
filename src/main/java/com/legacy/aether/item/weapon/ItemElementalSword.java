package com.legacy.aether.item.weapon;

import com.legacy.aether.item.ItemsAether;
import com.legacy.aether.item.util.AetherTier;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LightningEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;

public class ItemElementalSword extends ItemAetherSword {

    public ItemElementalSword() {
        super(AetherTier.Legendary, ItemsAether.AETHER_LOOT, 4, -2.4F);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity victim, LivingEntity attacker) {
        if (this == ItemsAether.flaming_sword) {
            victim.setOnFireFor(30);
        } else if (this == ItemsAether.lightning_sword) {
            LightningEntity lightning = EntityType.LIGHTNING_BOLT.create(attacker.world);
            //lightning.method_29495(victim.getPos());

            if (attacker instanceof ServerPlayerEntity) {
                lightning.setChanneler((ServerPlayerEntity) attacker);
            }

            //entityliving1.world.addWeatherEffect(lightning);
        } else if (this == ItemsAether.holy_sword && victim.isUndead()) {
            victim.damage(DamageSource.mob(attacker), 20);

            stack.damage(10, attacker, null);
        }

        return super.postHit(stack, victim, attacker);
    }

}