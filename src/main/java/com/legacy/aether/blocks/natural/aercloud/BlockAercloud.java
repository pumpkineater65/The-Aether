package com.legacy.aether.blocks.natural.aercloud;

import com.legacy.aether.blocks.BlocksAether;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Material;
import net.minecraft.block.MaterialColor;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.DyeColor;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class BlockAercloud extends Block {

    public BlockAercloud() {
        super(FabricBlockSettings.of(Material.ICE).strength(0.2F, -1.0F).sounds(BlockSoundGroup.WOOL).build());
    }

    public BlockAercloud(DyeColor color) {
        super(FabricBlockSettings.of(Material.ICE, color.getMaterialColor()).materialColor(color.getMaterialColor()).strength(0.2F, -1.0F).sounds(BlockSoundGroup.WOOL).build());
    }

    public BlockAercloud(MaterialColor color) {
        super(FabricBlockSettings.of(Material.ICE, color).materialColor(color).strength(0.2F, -1.0F).sounds(BlockSoundGroup.WOOL).build());
    }

    @Override
    public void onEntityCollision(BlockState stateIn, World worldIn, BlockPos posIn, Entity entityIn) {
        entityIn.fallDistance = 0.0F;

        if (this == BlocksAether.blue_aercloud) {
            for (int count = 0; count < 50; count++) {
                double xOffset = posIn.getX() + worldIn.random.nextDouble();
                double yOffset = posIn.getY() + worldIn.random.nextDouble();
                double zOffset = posIn.getZ() + worldIn.random.nextDouble();

                worldIn.addParticle(ParticleTypes.SPLASH, xOffset, yOffset, zOffset, 0.0D, 0.0D, 0.0D);
            }

            if (entityIn instanceof PlayerEntity && entityIn.isSneaking() && entityIn.getVelocity().y < 0.0D) {
                entityIn.setVelocity(entityIn.getVelocity().multiply(1.0D, 0.005D, 1.0D));

                return;
            }

            entityIn.setVelocity(entityIn.getVelocity().add(0.0D, 2.0D, 0.0D));
        } else {
            if (this == BlocksAether.pink_aercloud && entityIn.age % 20 == 0 && entityIn instanceof LivingEntity) {
                ((LivingEntity) entityIn).heal(1.0F);
            }

            if (entityIn.getVelocity().y <= 0.0F) {
                entityIn.setVelocity(entityIn.getVelocity().multiply(1.0D, 0.005D, 1.0D));
            }
        }
    }

    @Override
    @Environment(EnvType.CLIENT)
    public boolean isSideInvisible(BlockState blockState_1, BlockState blockState_2, Direction direction_1) {
        return blockState_2.getBlock() instanceof BlockAercloud || super.isSideInvisible(blockState_1, blockState_2, direction_1);
    }

	/*@Override
    public boolean isOpaque(BlockState state)
    {
        return false;
    }*/

    @Override
    public VoxelShape getCollisionShape(BlockState blockstateIn, BlockView blockViewIn, BlockPos posIn, ShapeContext entityContext_1) {
        return this == BlocksAether.blue_aercloud ? VoxelShapes.cuboid(0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D) : VoxelShapes.cuboid(0.0D, 0.0D, 0.0D, 1.0D, 0.01D, 1.0D);
    }

}