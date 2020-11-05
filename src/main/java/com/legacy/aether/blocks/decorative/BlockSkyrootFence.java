package com.legacy.aether.blocks.decorative;

import com.legacy.aether.blocks.BlocksAether;
import net.fabricmc.fabric.api.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.FenceBlock;
import net.minecraft.tag.BlockTags;
import net.minecraft.tag.Tag;

public class BlockSkyrootFence extends FenceBlock {

    public BlockSkyrootFence() {
        super(FabricBlockSettings.copy(BlocksAether.skyroot_planks).build());
    }

    @Override
    public boolean isIn(Tag<Block> tag) {
        return (tag == BlockTags.FENCES || tag == BlockTags.WOODEN_FENCES) || super.isIn(tag);
    }

}