package com.legacy.aether.blocks.container;

import com.legacy.aether.Aether;
import com.legacy.aether.blocks.entity.FreezerBlockEntity;
import net.fabricmc.fabric.api.container.ContainerProviderRegistry;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class BlockFreezer extends BlockWithAetherEntity {

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hitResult) {
        if (!world.isClient) {
            ContainerProviderRegistry.INSTANCE.openContainer(Aether.locate("freezer"), player, (packetBuffer) -> packetBuffer.writeBlockPos(pos));
        }

        return ActionResult.SUCCESS; // Assuming this means true
    }

    @Override
    public BlockEntity createBlockEntity(BlockView world) {
        return new FreezerBlockEntity();
    }

}