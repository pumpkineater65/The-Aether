package com.aether.blocks.decorative;

import com.aether.blocks.AetherBlocks;
import java.util.Random;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.block.DirtPathBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;

public class AetherDirtPathBlock extends DirtPathBlock {
    public AetherDirtPathBlock() {
        super(BlockBehaviour.Properties.of(Material.DIRT).strength(0.65F, 0.65F).sound(SoundType.GRASS));
    }

    @Override
    public void tick(BlockState state, ServerLevel world, BlockPos pos, Random random) {
        world.setBlockAndUpdate(pos, pushEntitiesUp(state, AetherBlocks.AETHER_DIRT.defaultBlockState(), world, pos));
    }
}