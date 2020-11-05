package com.legacy.aether.entities;

import com.legacy.aether.Aether;
import com.legacy.aether.blocks.BlocksAether;
import com.legacy.aether.entities.block.EntityFloatingBlock;
import com.legacy.aether.entities.hostile.EntityAechorPlant;
import com.legacy.aether.entities.hostile.EntityChestMimic;
import com.legacy.aether.entities.hostile.EntityCockatrice;
import com.legacy.aether.entities.passive.*;
import com.legacy.aether.entities.projectile.EntityEnchantedDart;
import com.legacy.aether.entities.projectile.EntityGoldenDart;
import com.legacy.aether.entities.projectile.EntityPoisonDart;
import com.legacy.aether.entities.projectile.EntityPoisonNeedle;
import net.fabricmc.fabric.api.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.*;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.Difficulty;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.WorldAccess;

import java.util.Random;

public class EntityTypesAether {

    public static final EntityType<EntityAechorPlant> AECHOR_PLANT = register("aechor_plant", SpawnGroup.MONSTER, EntityDimensions.changing(1.0F, 1.0F), (entityType, world) -> new EntityAechorPlant(world));

    public static final EntityType<EntityFlyingCow> FLYING_COW = register("flying_cow", SpawnGroup.CREATURE, EntityDimensions.changing(0.9F, 1.3F), (entityType, world) -> new EntityFlyingCow(world));

    public static final EntityType<EntityAerbunny> AERBUNNY = register("aerbunny", SpawnGroup.CREATURE, EntityDimensions.changing(0.4F, 0.4F), (entityType, world) -> new EntityAerbunny(world));

    public static final EntityType<EntityMoa> MOA = register("moa", SpawnGroup.CREATURE, EntityDimensions.changing(1.0F, 2.0F), (entityType, world) -> new EntityMoa(world));

    public static final EntityType<EntityPhyg> PHYG = register("phyg", SpawnGroup.CREATURE, EntityDimensions.changing(0.9F, 1.3F), (entityType, world) -> new EntityPhyg(world));

    public static final EntityType<EntitySheepuff> SHEEPUFF = register("sheepuff", SpawnGroup.CREATURE, EntityDimensions.changing(0.9F, 1.3F), (entityType, world) -> new EntitySheepuff(world));

    public static final EntityType<EntityCockatrice> COCKATRICE = register("cockatrice", SpawnGroup.MONSTER, EntityDimensions.changing(1.0F, 2.0F), (entityType, world) -> new EntityCockatrice(world));

    public static final EntityType<EntityChestMimic> CHEST_MIMIC = register("chest_mimic", SpawnGroup.MONSTER, EntityDimensions.changing(1.0F, 2.0F), (entityType, world) -> new EntityChestMimic(world));

    public static final EntityType<EntityFloatingBlock> FLOATING_BLOCK = register("floating_block", 160, 20, true, EntityDimensions.changing(0.98F, 0.98F), (entityType, world) -> new EntityFloatingBlock(world));

    public static final EntityType<EntityGoldenDart> GOLDEN_DART = register("golden_dart", SpawnGroup.MISC, EntityDimensions.changing(0.5F, 0.5F), (entityType, world) -> new EntityGoldenDart(world));

    public static final EntityType<EntityEnchantedDart> ENCHANTED_DART = register("enchanted_dart", SpawnGroup.MISC, EntityDimensions.changing(0.5F, 0.5F), (entityType, world) -> new EntityEnchantedDart(world));

    public static final EntityType<EntityPoisonDart> POISON_DART = register("poison_dart", SpawnGroup.MISC, EntityDimensions.changing(0.5F, 0.5F), (entityType, world) -> new EntityPoisonDart(world));

    public static final EntityType<EntityPoisonNeedle> POISON_NEEDLE = register("poison_needle", SpawnGroup.MISC, EntityDimensions.changing(0.5F, 0.5F), (entityType, world) -> new EntityPoisonNeedle(world));

    //public static EntityType<EntityWhirlwind> WHIRLWIND;

    //public static EntityType<EntityAerwhale> AERWHALE;

    //public static EntityType<EntityMiniCloud> MINI_CLOUD;

    //public static EntityType<EntityFireMinion> FIRE_MINION;

    //public static EntityType<EntityCrystal> CRYSTAL;

    //public static EntityType<EntityPhoenixArrow> PHOENIX_ARROW;

    public static void register() {
        Aether.log("Registering Aether Entities");
    }

    @SuppressWarnings("unused")
    private static void registerEntityTypes() {
        //FLYING_COW = (EntityType<EntityFlyingCow>) register("flying_cow", FabricEntityTypeBuilder.create(EntityFlyingCow.class, EntityFlyingCow::new).build());
		/*AERWHALE = (EntityType<EntityAerwhale>) register("aerwhale", Builder.create(EntityAerwhale.class, EntityAerwhale::new));
		AECHOR_PLANT = (EntityType<EntityAechorPlant>) register("aechor_plant", Builder.create(EntityAechorPlant.class, EntityAechorPlant::new));
		PHYG = (EntityType<EntityPhyg>) register("phyg", Builder.create(EntityPhyg.class, EntityPhyg::new));
		SHEEPUFF = (EntityType<EntitySheepuff>) register("sheepuff", Builder.create(EntitySheepuff.class, EntitySheepuff::new));
		AERBUNNY = (EntityType<EntityAerbunny>) register("aerbunny", Builder.create(EntityAerbunny.class, EntityAerbunny::new));
		COCKATRICE = (EntityType<EntityCockatrice>) register("cockatrice", Builder.create(EntityCockatrice.class, EntityCockatrice::new));
		CHEST_MIMIC = (EntityType<EntityChestMimic>) register("chest_mimic", Builder.create(EntityChestMimic.class, EntityChestMimic::new));
		GOLDEN_DART = (EntityType<EntityGoldenDart>) register("golden_dart", Builder.create(EntityGoldenDart.class, EntityGoldenDart::new));
		ENCHANTED_DART = (EntityType<EntityEnchantedDart>) register("enchanted_dart", Builder.create(EntityEnchantedDart.class, EntityEnchantedDart::new));
		POISON_DART = (EntityType<EntityPoisonDart>) register("poison_dart", Builder.create(EntityPoisonDart.class, EntityPoisonDart::new));
		POISON_NEEDLE = (EntityType<EntityPoisonNeedle>) register("poison_needle", Builder.create(EntityPoisonNeedle.class, EntityPoisonNeedle::new));*/
		/*WHIRLWIND = (EntityType<EntityWhirlwind>) register("whirlwind", Builder.create(EntityWhirlwind.class, EntityWhirlwind::new));
		MINI_CLOUD = (EntityType<EntityMiniCloud>) register("mini_cloud", Builder.create(EntityMiniCloud.class, EntityMiniCloud::new));
		FIRE_MINION = (EntityType<EntityFireMinion>) register("fire_minion", Builder.create(EntityFireMinion.class, EntityFireMinion::new));
		CRYSTAL = (EntityType<EntityCrystal>) register("crystal", Builder.create(EntityCrystal.class, EntityCrystal::new));
		PHOENIX_ARROW = (EntityType<EntityPhoenixArrow>) register("phoenix_arrow", Builder.create(EntityPhoenixArrow.class, EntityPhoenixArrow::new));

		AetherMoaTypes.initialization();*/
    }

    public static void registerItems() {
        //Registry.register(Registry.ITEM, Aether.locate("aechor_plant_spawn_egg"), new ItemAetherSpawnEgg(AECHOR_PLANT, 0x9fc3f7, 0x29a793));
        //Registry.register(Registry.ITEM, Aether.locate("cockatrice_spawn_egg"), new ItemAetherSpawnEgg(COCKATRICE, 0x9fc3f7, 0x3d2338));
    }

    public static <X extends Entity> EntityType<X> register(String name, int trackingDistance, int updateIntervalTicks, boolean alwaysUpdateVelocity, EntityDimensions size, EntityType.EntityFactory<X> factory) {
        return Registry.register(Registry.ENTITY_TYPE, Aether.locate(name), FabricEntityTypeBuilder.create(SpawnGroup.MISC, factory).trackable(trackingDistance, updateIntervalTicks, alwaysUpdateVelocity).size(size).disableSaving().build());
    }

    public static <X extends Entity> EntityType<X> register(String name, SpawnGroup category, EntityDimensions size, EntityType.EntityFactory<X> factory) {
        return Registry.register(Registry.ENTITY_TYPE, Aether.locate(name), FabricEntityTypeBuilder.create(category, factory).size(size).disableSaving().build());
    }

    public static boolean getAnimalData(EntityType<? extends Entity> entityType, WorldAccess WorldAccess, SpawnReason SpawnReason, BlockPos blockPos, Random random) {
        return WorldAccess.getBlockState(blockPos.down()).getBlock() == BlocksAether.aether_grass && WorldAccess.getBaseLightLevel(blockPos, 0) > 8 && (SpawnReason == SpawnReason.SPAWNER || WorldAccess.getBlockState(blockPos).allowsSpawning(WorldAccess, blockPos, entityType));
    }

    public static boolean getHostileData(EntityType<? extends Entity> entityType_1, ServerWorldAccess WorldAccess_1, SpawnReason SpawnReason, BlockPos blockPos_1, Random random_1) {
        return WorldAccess_1.getDifficulty() != Difficulty.PEACEFUL && HostileEntity.isSpawnDark(WorldAccess_1, blockPos_1, random_1) && (SpawnReason == SpawnReason.SPAWNER || WorldAccess_1.getBlockState(blockPos_1).allowsSpawning(WorldAccess_1, blockPos_1, entityType_1));
    }
}