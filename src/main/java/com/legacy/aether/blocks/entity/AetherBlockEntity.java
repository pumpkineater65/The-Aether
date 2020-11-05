package com.legacy.aether.blocks.entity;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.SidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Tickable;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.Direction;

import java.util.Iterator;

public abstract class AetherBlockEntity extends BlockEntity implements SidedInventory, Tickable, PropertyDelegate {

    private String name = "generic";

    private Text customName;

    public AetherBlockEntity(String name, BlockEntityType<?> blockEntityType_1) {
        super(blockEntityType_1);

        this.name = name;
    }

    public abstract DefaultedList<ItemStack> getInventory();

    public abstract void onSlotChanged(int slot);

    @Override
    public int size() {
        return this.getInventory().size();
    }

    @Override
    public boolean isEmpty() {
        Iterator<ItemStack> iterator = this.getInventory().iterator();

        ItemStack stack;

        do {
            if (!iterator.hasNext()) {
                return true;
            }

            stack = iterator.next();
        }
        while (stack.isEmpty());

        return false;
    }

    @Override
    public ItemStack getStack(int slot) {
        return this.getInventory().get(slot);
    }

    @Override
    public ItemStack removeStack(int slot, int stackSize) {
        return Inventories.splitStack(this.getInventory(), slot, stackSize);
    }

    @Override
    public ItemStack removeStack(int slot) {
        return Inventories.removeStack(this.getInventory(), slot);
    }

    @Override
    public void setStack(int slot, ItemStack stackIn) {
        ItemStack itemStack_2 = this.getInventory().get(slot);
        boolean isClean = !stackIn.isEmpty() && stackIn.isItemEqual(itemStack_2) && ItemStack.areTagsEqual(stackIn, itemStack_2);

        this.getInventory().set(slot, stackIn);

        if (stackIn.getCount() > this.getMaxCountPerStack()) {
            stackIn.setCount(this.getMaxCountPerStack());
        }

        if (!isClean) {
            this.onSlotChanged(slot);
            this.markDirty();
        }

    }

    @Override
    public void fromTag(BlockState state, CompoundTag compound) {
        super.fromTag(state, compound);

        this.getInventory().clear();
        Inventories.fromTag(compound, this.getInventory());

        if (compound.contains("customName", 8)) {
            this.customName = Text.Serializer.fromJson(compound.getString("customName"));
        }
    }

    @Override
    public CompoundTag toTag(CompoundTag compound) {
        Inventories.toTag(compound, this.getInventory());

        if (this.hasCustomName()) {
            compound.putString("customName", Text.Serializer.toJson(this.customName));
        }

        return super.toTag(compound);
    }

    @Override
    public boolean canPlayerUse(PlayerEntity playerIn) {
        return playerIn.squaredDistanceTo((double) this.pos.getX() + 0.5D, (double) this.pos.getY() + 0.5D, (double) this.pos.getZ() + 0.5D) <= 64.0D;
    }

    @Override
    public void clear() {
        this.getInventory().clear();
    }

    public boolean hasCustomName() {
        return this.customName != null;
    }

    public Text getName() {
        return this.customName != null ? this.customName : new TranslatableText("container.aether_legacy." + this.name);
    }

    public Text getCustomName() {
        return this.customName;
    }

    public void setCustomName(Text textComponentIn) {
        this.customName = textComponentIn;
    }

    @Override
    public boolean canInsert(int slot, ItemStack stack, Direction direction) {
        return true;
    }

    @Override
    public boolean canExtract(int slot, ItemStack stack, Direction direction) {
        return this.isValid(slot, stack);
    }

}