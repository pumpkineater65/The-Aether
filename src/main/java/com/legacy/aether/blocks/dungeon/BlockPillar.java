package com.legacy.aether.blocks.dungeon;

import net.fabricmc.fabric.api.block.FabricBlockSettings;
import net.minecraft.block.Material;
import net.minecraft.block.PillarBlock;
import net.minecraft.sound.BlockSoundGroup;

public class BlockPillar extends PillarBlock {
    public BlockPillar() {
        super(FabricBlockSettings.of(Material.STONE).hardness(5.0f).resistance(-1.0f).sounds(BlockSoundGroup.METAL).build());
    }

    public BlockPillar(Settings settings) {
        super(settings);
    }
}
