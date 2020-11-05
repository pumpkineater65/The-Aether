package com.legacy.aether.blocks.natural;

import net.fabricmc.fabric.api.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.tag.BlockTags;
import net.minecraft.tag.Tag;
import net.minecraft.util.math.Direction;

public class BlockAetherLog extends PillarBlock {

    public static final BooleanProperty DOUBLE_DROP = BooleanProperty.of("double_drop");

    public BlockAetherLog() {
        super(FabricBlockSettings.of(Material.WOOD, MaterialColor.WOOD).strength(2.0F, -1.0F).sounds(BlockSoundGroup.WOOD).build());

        this.setDefaultState(this.getDefaultState().with(DOUBLE_DROP, true).with(AXIS, Direction.Axis.Y));
    }

    @Override
    public boolean isIn(Tag<Block> tag) {
        return tag == BlockTags.LOGS || super.isIn(tag);
    }

    @Override
    public void appendProperties(StateManager.Builder<Block, BlockState> propertyBuilderIn) {
        super.appendProperties(propertyBuilderIn);

        propertyBuilderIn.add(DOUBLE_DROP);
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext context) {
        return super.getPlacementState(context).with(DOUBLE_DROP, false);
    }

}