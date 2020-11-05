package com.legacy.aether.blocks.decorative;

import com.legacy.aether.blocks.BlocksAether;
import net.fabricmc.fabric.api.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.pathing.NavigationType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.state.StateManager;
import net.minecraft.tag.FluidTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.*;

import java.util.Iterator;
import java.util.Random;

public class BlockAetherFarmland extends Block {

    protected static final VoxelShape SHAPE = Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 15.0D, 16.0D);

    public BlockAetherFarmland() {
        super(FabricBlockSettings.of(Material.SOIL).ticksRandomly().hardness(0.2F).sounds(BlockSoundGroup.GRAVEL).build());

        this.setDefaultState(this.getDefaultState().with(FarmlandBlock.MOISTURE, 0));
    }

    public static void setToDirt(BlockState state, World world, BlockPos pos) {
        world.setBlockState(pos, pushEntitiesUpBeforeBlockChange(state, BlocksAether.aether_dirt.getDefaultState(), world, pos));
    }

    private static boolean hasCrop(BlockView view, BlockPos pos) {
        Block block = view.getBlockState(pos.up()).getBlock();

        return block instanceof CropBlock || block instanceof StemBlock || block instanceof AttachedStemBlock;
    }

    private static boolean waterNearby(CollisionView world, BlockPos pos) {
        Iterator<BlockPos> positions = BlockPos.iterate(pos.add(-4, 0, -4), pos.add(4, 1, 4)).iterator();

        BlockPos blockPos_2;
        do {
            if (!positions.hasNext()) {
                return false;
            }
            blockPos_2 = positions.next();
        }
        while (!world.getFluidState(blockPos_2).isIn(FluidTags.WATER));

        return true;
    }

    @Override
    public BlockState getStateForNeighborUpdate(BlockState blockState_1, Direction direction_1, BlockState blockState_2, WorldAccess WorldAccess_1, BlockPos pos, BlockPos blockPos_2) {
        if (direction_1 == Direction.UP && !blockState_1.canPlaceAt(WorldAccess_1, pos)) {
            WorldAccess_1.getBlockTickScheduler().schedule(pos, this, 1);
        }

        return super.getStateForNeighborUpdate(blockState_1, direction_1, blockState_2, WorldAccess_1, pos, blockPos_2);
    }

    @Override
    public boolean canPlaceAt(BlockState blockState_1, WorldView viewableWorld_1, BlockPos pos) {
        BlockState blockState_2 = viewableWorld_1.getBlockState(pos.up());

        return !blockState_2.getMaterial().isSolid() || blockState_2.getBlock() instanceof FenceGateBlock;
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext itemPlacementContext_1) {
        return !this.getDefaultState().canPlaceAt(itemPlacementContext_1.getWorld(), itemPlacementContext_1.getBlockPos()) ? BlocksAether.aether_dirt.getDefaultState() : super.getPlacementState(itemPlacementContext_1);
    }

    @Override
    public boolean hasSidedTransparency(BlockState state) {
        return true;
    }

    @Override
    public VoxelShape getOutlineShape(BlockState blockState_1, BlockView blockView_1, BlockPos pos, ShapeContext entityContext_1) {
        return SHAPE;
    }

    @Override
    public void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (!state.canPlaceAt(world, pos)) {
            setToDirt(state, world, pos);
        } else {
            int moisture = state.get(FarmlandBlock.MOISTURE);

            if (!waterNearby(world, pos) && !world.hasRain(pos.up())) {
                if (moisture > 0) {
                    world.setBlockState(pos, state.with(FarmlandBlock.MOISTURE, moisture - 1), 2);
                } else if (!hasCrop(world, pos)) {
                    setToDirt(state, world, pos);
                }
            } else if (moisture < 7) {
                world.setBlockState(pos, state.with(FarmlandBlock.MOISTURE, 7), 2);
            }
        }
    }

    @Override
    public void onLandedUpon(World world, BlockPos pos, Entity entity, float fallDistance) {
        if (!world.isClient && world.random.nextFloat() < fallDistance - 0.5F && entity instanceof LivingEntity && (entity instanceof PlayerEntity || world.getGameRules().getBoolean(GameRules.DO_MOB_GRIEFING) && entity.getWidth() * entity.getWidth() * entity.getHeight() > 0.512F)) {
            setToDirt(world.getBlockState(pos), world, pos);
        }

        super.onLandedUpon(world, pos, entity, fallDistance);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> factory) {
        factory.add(FarmlandBlock.MOISTURE);
    }

    @Override
    public boolean canPathfindThrough(BlockState state, BlockView view, BlockPos pos, NavigationType placement) {
        return false;
    }

}