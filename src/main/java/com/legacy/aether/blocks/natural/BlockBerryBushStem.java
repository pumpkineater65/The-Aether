package com.legacy.aether.blocks.natural;

import com.legacy.aether.blocks.BlocksAether;
import net.fabricmc.fabric.api.block.FabricBlockSettings;
import net.minecraft.block.BlockState;
import net.minecraft.block.Fertilizable;
import net.minecraft.block.Material;
import net.minecraft.block.PlantBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

import java.util.Random;

public class BlockBerryBushStem extends PlantBlock implements Fertilizable {

    public BlockBerryBushStem() {
        super(FabricBlockSettings.of(Material.PLANT).ticksRandomly().noCollision().hardness(2.0F).sounds(BlockSoundGroup.GRASS).build());
    }

    @Override
    public void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (world.isClient) {
            return;
        }

        super.scheduledTick(state, world, pos, random);

        if (world.getLightLevel(pos.up()) >= 9 && random.nextInt(60) == 0) {
            world.setBlockState(pos, BlocksAether.berry_bush.getDefaultState());
        }
    }

    @Override
    public VoxelShape getCollisionShape(BlockState stateIn, BlockView blockViewIn, BlockPos posIn, ShapeContext entityContext_1) {
        return VoxelShapes.cuboid(0.1F, 0.0F, 0.1F, 0.9F, 0.8F, 0.9F);
    }

    @Override
    public boolean isFertilizable(BlockView var1, BlockPos var2, BlockState var3, boolean var4) {
        return true;
    }

    @Override
    public boolean canGrow(World var1, Random var2, BlockPos var3, BlockState var4) {
        return true;
    }

    @Override
    public void grow(ServerWorld var1, Random var2, BlockPos var3, BlockState var4) {
        var1.setBlockState(var3, BlocksAether.berry_bush.getDefaultState());
    }

}