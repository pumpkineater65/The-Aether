package com.legacy.aether.mixin;

import com.legacy.aether.entities.EntityTypesAether;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnRestriction;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.world.Heightmap;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(SpawnRestriction.class)
public class MixinSpawnRestriction {

    static {
        register(EntityTypesAether.SHEEPUFF, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, EntityTypesAether::getAnimalData);
        register(EntityTypesAether.PHYG, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, EntityTypesAether::getAnimalData);
        register(EntityTypesAether.AERBUNNY, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, EntityTypesAether::getAnimalData);
        register(EntityTypesAether.FLYING_COW, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, EntityTypesAether::getAnimalData);
        register(EntityTypesAether.COCKATRICE, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, EntityTypesAether::getHostileData);
        register(EntityTypesAether.AECHOR_PLANT, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, EntityTypesAether::getHostileData);
    }

    @Shadow
    private static <T extends MobEntity> void register(EntityType<?> entityType_1, SpawnRestriction.Location spawnRestriction$Location_1, Heightmap.Type heightmap$Type_1, SpawnRestriction.SpawnPredicate<?> spawnRestriction$class_4306_1) {

    }
}