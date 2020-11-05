package com.legacy.aether.blocks.natural.enchanted;

import com.legacy.aether.blocks.BlocksAether;
import com.legacy.aether.blocks.natural.BlockAetherDirt;
import net.fabricmc.fabric.api.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Material;
import net.minecraft.block.MaterialColor;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.math.BlockPos;

import java.util.Random;

public class BlockEnchantedAetherGrass extends Block {

    public BlockEnchantedAetherGrass() {
        super(FabricBlockSettings.of(Material.SOLID_ORGANIC, MaterialColor.YELLOW).ticksRandomly().strength(0.2F, -1.0F).sounds(BlockSoundGroup.GRASS).build());
    }

    @Override
    public void scheduledTick(BlockState stateIn, ServerWorld worldIn, BlockPos posIn, Random randIn) {
        if (!worldIn.isClient) {
            if (worldIn.getLightLevel(posIn.up()) < 4) {
                worldIn.setBlockState(posIn, BlocksAether.aether_dirt.getDefaultState().with(BlockAetherDirt.DOUBLE_DROP, false));
            }
        }
    }

}