package com.legacy.aether.blocks.container;

import com.legacy.aether.blocks.entity.AetherBlockEntity;
import net.fabricmc.fabric.api.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public abstract class BlockWithAetherEntity extends BlockWithEntity {

    public static final BooleanProperty POWERED = Properties.POWERED;

    public BlockWithAetherEntity() {
        super(FabricBlockSettings.of(Material.STONE).strength(2.0F, 2.0F).build());

        this.setDefaultState(this.getDefaultState().with(POWERED, false));
    }

    public static void setState(World worldIn, BlockPos pos, boolean isActive) {
        BlockState state = worldIn.getBlockState(pos);
        BlockEntity entity = worldIn.getBlockEntity(pos);

        worldIn.setBlockState(pos, state.with(POWERED, isActive), 3);

        if (entity != null) {
            entity.cancelRemoval();
            worldIn.setBlockEntity(pos, entity);
        }
    }

    public void onPlaced(World world, BlockPos pos, BlockState state, LivingEntity entity, ItemStack stack) {
        if (stack.hasCustomName()) {
            BlockEntity blockEntity = world.getBlockEntity(pos);

            if (blockEntity instanceof AetherBlockEntity) {
                ((AetherBlockEntity) blockEntity).setCustomName(stack.getName());
            }
        }
    }

    @Override
    public void onStateReplaced(BlockState state, World world, BlockPos pos, BlockState replacedState, boolean updateNeighbors) {
        if (state.getBlock() != replacedState.getBlock()) {
            BlockEntity entity = world.getBlockEntity(pos);

            if (entity instanceof AetherBlockEntity) {
                ItemScatterer.spawn(world, pos, (AetherBlockEntity) entity);
                world.updateComparators(pos, this);
            }
        }

        super.onStateReplaced(state, world, pos, replacedState, updateNeighbors);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(POWERED);
    }

    @Override
    public int getComparatorOutput(BlockState state, World world, BlockPos pos) {
        return ScreenHandler.calculateComparatorOutput(world.getBlockEntity(pos));
    }

    @Override
    public boolean hasComparatorOutput(BlockState state) {
        return true;
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

}