package com.aether.blocks.aercloud;

import com.mojang.math.Vector3f;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.DustParticleOptions;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

public class PinkAercloudBlock extends BaseAercloudBlock {

    private static final ParticleOptions pinkFluff = new DustParticleOptions(new Vector3f(0.89F, 0.65F, 0.9F), 1F);

    public PinkAercloudBlock(BlockBehaviour.Properties properties) {
        super(properties);
    }

    @Override
    public void entityInside(BlockState state, Level world, BlockPos pos, Entity entity) {
        super.entityInside(state, world, pos, entity);
        if (!world.isClientSide() && entity instanceof LivingEntity) {
            if (world.getGameTime() % 20 == 0) {
                ((LivingEntity) entity).heal(1F);
                for (int i = world.getRandom().nextInt(3); i <= 5; i++) {
                    double offX = (world.getRandom().nextDouble() * entity.getBbWidth()) - (entity.getBbWidth() / 2);
                    double offZ = (world.getRandom().nextDouble() * entity.getBbWidth()) - (entity.getBbWidth() / 2);
                    double offY = world.getRandom().nextDouble() * entity.getBbHeight();
                    ((ServerLevel) world).sendParticles(pinkFluff, entity.getX() + offX, entity.getY() + offY, entity.getZ() + offZ, 3, 0, 0, 0, 1);
                }
            }
            double offX = (world.getRandom().nextDouble() * entity.getBbWidth()) - (entity.getBbWidth() / 2);
            double offZ = (world.getRandom().nextDouble() * entity.getBbWidth()) - (entity.getBbWidth() / 2);
            double offY = world.getRandom().nextDouble() * entity.getBbHeight();
            ((ServerLevel) world).sendParticles(pinkFluff, entity.getX() + offX, entity.getY() + offY, entity.getZ() + offZ, 1, 0, 0, 0, 0.1);
        }
    }
}
