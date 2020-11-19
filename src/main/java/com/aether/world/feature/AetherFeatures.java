package com.aether.world.feature;

import com.aether.Aether;
import com.aether.blocks.AetherBlocks;
import com.aether.world.feature.config.AercloudConfig;

import net.minecraft.block.Blocks;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.Heightmap;
import net.minecraft.world.gen.UniformIntDistribution;
import net.minecraft.world.gen.decorator.ChanceDecoratorConfig;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.foliage.LargeOakFoliagePlacer;
import net.minecraft.world.gen.stateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.trunk.LargeOakTrunkPlacer;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;

import java.util.OptionalInt;

public class AetherFeatures {
    public static ConfiguredFeature<?, ?> GOLDEN_OAK, SKYROOT;
    public static ConfiguredFeature<?, ?> COLD_AERCLOUD, BLUE_AERCLOUD, GOLDEN_AERCLOUD;
    public static ConfiguredFeature<?, ?> AETHER_GRASS, AETHER_TALL_GRASS;
    public static ConfiguredFeature<?, ?> AETHER_LAKE;

    public static void registerFeatures() {
        SKYROOT = register("skyroot_tree", Feature.TREE.configure((new net.minecraft.world.gen.feature.TreeFeatureConfig.Builder(new SimpleBlockStateProvider(AetherBlocks.SKYROOT_LOG.getDefaultState()), new SimpleBlockStateProvider(AetherBlocks.SKYROOT_LEAVES.getDefaultState()), new BlobFoliagePlacer(UniformIntDistribution.of(3), UniformIntDistribution.of(4), 4), new StraightTrunkPlacer(1, 3, 0),  new TwoLayersFeatureSize(0, 0, 0, OptionalInt.of(3)))).ignoreVines().heightmap(Heightmap.Type.MOTION_BLOCKING).build())/*.decorate(Decorator.COUNT_HEIGHTMAP.configure(new CountDecoratorConfig(4)))*/);
        GOLDEN_OAK = register("golden_oak_tree", Feature.TREE.configure((new net.minecraft.world.gen.feature.TreeFeatureConfig.Builder(new SimpleBlockStateProvider(AetherBlocks.GOLDEN_OAK_LOG.getDefaultState()), new SimpleBlockStateProvider(AetherBlocks.GOLDEN_OAK_LEAVES.getDefaultState()), new LargeOakFoliagePlacer(UniformIntDistribution.of(3), UniformIntDistribution.of(6), 5), new LargeOakTrunkPlacer(5, 17, 0), new TwoLayersFeatureSize(0, 0, 0, OptionalInt.of(6)))).ignoreVines().heightmap(Heightmap.Type.MOTION_BLOCKING).build()).decorate(Decorator.CHANCE.configure(new ChanceDecoratorConfig(4))));
        COLD_AERCLOUD = register("cold_aercloud", new AercloudFeature().configure(new AercloudConfig(AetherBlocks.COLD_AERCLOUD.getDefaultState(), false, 16, 64)).decorate(Decorator.CHANCE.configure(new ChanceDecoratorConfig(10))));
        AETHER_LAKE = register("lake_water", new AetherLakeFeature(SingleStateFeatureConfig.CODEC).configure(new SingleStateFeatureConfig(Blocks.WATER.getDefaultState())).decorate(Decorator.WATER_LAKE.configure(new ChanceDecoratorConfig(4))));
        AETHER_GRASS = register("aether_grass", Feature.RANDOM_PATCH.configure(AetherConfiguredFeatures.AETHER_GRASS_CONFIG));
        AETHER_GRASS = register("aether_tall_grass", Feature.RANDOM_PATCH.configure(AetherConfiguredFeatures.AETHER_TALL_GRASS_CONFIG));
        SKYROOT = register("skyroot_tree", Feature.TREE.configure(AetherConfiguredFeatures.SKYROOT_CONFIG));
        GOLDEN_OAK = register("golden_oak_tree", Feature.TREE.configure(AetherConfiguredFeatures.GOLDEN_OAK_CONFIG));
        COLD_AERCLOUD = register("cold_aercloud", new AercloudFeature().configure(AetherConfiguredFeatures.COLD_AERCLOUD_CONFIG));
        BLUE_AERCLOUD = register("blue_aercloud", new AercloudFeature().configure(AetherConfiguredFeatures.BLUE_AERCLOUD_CONFIG));
        GOLDEN_AERCLOUD = register("golden_aercloud", new AercloudFeature().configure(AetherConfiguredFeatures.GOLDEN_AERCLOUD_CONFIG));
    }

    private static <FC extends FeatureConfig> ConfiguredFeature<FC, ?> register(String id, ConfiguredFeature<FC, ?> configuredFeature) {
        return Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier(Aether.MOD_ID, id), configuredFeature);
    }

    private static <C extends FeatureConfig, F extends Feature<C>> F register(String id, F feature) {
        return Registry.register(Registry.FEATURE, new Identifier(Aether.MOD_ID, id), feature);
    }
}