package com.legacy.aether.blocks.decorative;

import net.fabricmc.fabric.api.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.FlowerPotBlock;
import net.minecraft.block.Material;
import net.minecraft.tag.BlockTags;
import net.minecraft.tag.Tag;

public class BlockAetherFlowerPot extends FlowerPotBlock {

    public BlockAetherFlowerPot(Block flower) {
        super(flower, FabricBlockSettings.of(Material.SUPPORTED).breakInstantly().build());
    }

    @Override
    public boolean isIn(Tag<Block> tag) {
        return tag == BlockTags.FLOWER_POTS || super.isIn(tag);
    }

}