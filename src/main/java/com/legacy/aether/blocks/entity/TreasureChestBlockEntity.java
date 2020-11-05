package com.legacy.aether.blocks.entity;

import com.legacy.aether.blocks.BlocksAether;
import com.legacy.aether.item.ItemsAether;
import com.legacy.aether.item.dungeon.ItemDungeonKey;
import net.fabricmc.fabric.api.block.entity.BlockEntityClientSerializable;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.ChestBlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;

public class TreasureChestBlockEntity extends ChestBlockEntity implements BlockEntityClientSerializable {

    private boolean locked = true;

    private int type = 0;

    public ActionResult unlockTreasure(PlayerEntity player, Hand hand) {
        ItemStack heldItem = player.getStackInHand(hand);

        if (heldItem.getItem() instanceof ItemDungeonKey) {
            this.locked = false;
            this.type = heldItem.getItem() == ItemsAether.bronze_key ? 0 : heldItem.getItem() == ItemsAether.silver_key ? 1 : heldItem.getItem() == ItemsAether.golden_key ? 2 : 3;
        }

        return !this.locked ? ActionResult.SUCCESS : ActionResult.FAIL; // Assuming this works
    }

    public int getDungeonType() {
        return this.type;
    }

    public boolean isTreasureLocked() {
        return this.locked;
    }

    @Override
    public void onOpen(PlayerEntity playerIn) {
        super.onOpen(playerIn);

        if (playerIn instanceof ServerPlayerEntity) {
            ((ServerPlayerEntity) playerIn).networkHandler.sendPacket(this.toUpdatePacket());
        }
    }

    @Override
    protected void onInvOpenOrClose() {
        Block block_1 = this.getCachedState().getBlock();

        this.world.addSyncedBlockEvent(this.pos, block_1, 1, this.viewerCount);
        this.world.updateNeighborsAlways(this.pos, block_1);
    }

    @Override
    public BlockEntityUpdateS2CPacket toUpdatePacket() {
        return new BlockEntityUpdateS2CPacket(this.getPos(), 127, this.toClientTag(new CompoundTag()));
    }

    @Override
    public CompoundTag toClientTag(CompoundTag compound) {
        return this.toTag(compound);
    }

    @Override
    public void fromClientTag(CompoundTag compound) {
        this.fromTag(BlocksAether.treasure_chest.getDefaultState(), compound);
    }

    @Override
    public CompoundTag toTag(CompoundTag compound) {
        compound.putInt("dungeonType", this.type);
        compound.putBoolean("locked", this.locked);

        return super.toTag(compound);
    }

    @Override
    public void fromTag(BlockState state, CompoundTag compound) {
        super.fromTag(state, compound);

        this.type = compound.getInt("dungeonType");
        this.locked = compound.getBoolean("locked");
    }

}