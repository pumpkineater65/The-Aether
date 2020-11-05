package com.legacy.aether.blocks.natural.enchanted;

import com.legacy.aether.blocks.BlockFloating;
import net.fabricmc.fabric.api.block.FabricBlockSettings;
import net.minecraft.block.Material;
import net.minecraft.block.MaterialColor;
import net.minecraft.sound.BlockSoundGroup;

public class BlockEnchantedGravitite extends BlockFloating {

    public BlockEnchantedGravitite() {
        super(FabricBlockSettings.of(Material.METAL, MaterialColor.PINK).strength(5.0F, -1.0F).sounds(BlockSoundGroup.METAL), false);
    }

}