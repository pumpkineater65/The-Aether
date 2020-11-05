package com.legacy.aether.entities.projectile;

import com.legacy.aether.entities.EntityTypesAether;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class EntityPoisonNeedle extends EntityPoisonDart {

    public EntityPoisonNeedle(double x, double y, double z, World world) {
        super(EntityTypesAether.POISON_NEEDLE, x, y, z, world);

        this.setNoGravity(false);
    }

    public EntityPoisonNeedle(LivingEntity owner, World world) {
        super(EntityTypesAether.POISON_NEEDLE, owner, world);

        this.setNoGravity(false);
    }

    public EntityPoisonNeedle(World world) {
        super(EntityTypesAether.POISON_NEEDLE, world);

        this.setNoGravity(false);
    }

    @Override
    protected ItemStack asItemStack() {
        return ItemStack.EMPTY;
    }

}