package com.legacy.aether.entities.passive;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.world.World;

public abstract class EntityAetherAnimal extends AnimalEntity {

    public EntityAetherAnimal(EntityType<? extends AnimalEntity> type, World world) {
        super(type, world);

        // TODO: ???
        //this.spawningGround = BlocksAether.aether_grass;
    }

    protected void initAttributes() {
        //
    }


}