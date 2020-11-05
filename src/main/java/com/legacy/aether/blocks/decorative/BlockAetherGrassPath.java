package com.legacy.aether.blocks.decorative;

import com.legacy.aether.blocks.BlocksAether;
import net.fabricmc.fabric.api.block.FabricBlockSettings;
import net.minecraft.block.BlockState;
import net.minecraft.block.GrassPathBlock;
import net.minecraft.block.Material;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.math.BlockPos;

import java.util.Random;

public class BlockAetherGrassPath extends GrassPathBlock {

    public BlockAetherGrassPath() {
        super(FabricBlockSettings.of(Material.SOIL).strength(0.65F, 0.65F).sounds(BlockSoundGroup.GRASS).build());
    }

    @Override
    public void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        world.setBlockState(pos, pushEntitiesUpBeforeBlockChange(state, BlocksAether.aether_dirt.getDefaultState(), world, pos));
    }

}