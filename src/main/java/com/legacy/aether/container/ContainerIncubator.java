package com.legacy.aether.container;

import com.legacy.aether.blocks.BlocksAether;
import com.legacy.aether.blocks.entity.AetherBlockEntity;
import com.legacy.aether.blocks.entity.IncubatorBlockEntity;
import com.legacy.aether.container.slot.SlotIncubator;
import com.legacy.aether.item.ItemsAether;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;

public class ContainerIncubator extends ScreenHandler {

    private Inventory incubator;

    public ContainerIncubator(int syncId, Inventory inventoryIn, AetherBlockEntity incubatorIn) {
        super(null, syncId);

        checkSize(incubatorIn, 2);
        checkDataCount(incubatorIn, 2);

        incubatorIn.onOpen(((PlayerInventory) inventoryIn).player);

        this.incubator = incubatorIn;

        this.addSlot(new SlotIncubator(incubatorIn, 1, 73, 17));
        this.addSlot(new Slot(incubatorIn, 0, 73, 53));

        for (int j = 0; j < 3; ++j) {
            for (int k = 0; k < 9; ++k) {
                this.addSlot(new Slot(inventoryIn, k + j * 9 + 9, 8 + k * 18, 84 + j * 18));
            }
        }

        for (int j = 0; j < 9; ++j) {
            this.addSlot(new Slot(inventoryIn, j, 8 + j * 18, 142));
        }

        this.addProperties(incubatorIn);
    }

    @Override
    public boolean canUse(PlayerEntity playerIn) {
        return this.incubator.canPlayerUse(playerIn);
    }

    @Override
    public ItemStack transferSlot(PlayerEntity playerIn, int index) {
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = this.slots.get(index);

        if (slot != null && slot.hasStack()) {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();

            if (index != 1 && index != 0) {
                if (itemstack.getItem() == BlocksAether.ambrosium_torch.asItem() && this.insertItem(itemstack1, 1, 2, false)) {
                    return itemstack;
                } else if (itemstack.getItem() == ItemsAether.moa_egg && this.insertItem(itemstack1, 0, 1, false)) {
                    return itemstack;
                } else if (index >= 2 && index < 29) {
                    if (!this.insertItem(itemstack1, 29, 38, false)) {
                        return ItemStack.EMPTY;
                    }
                } else if (index >= 29 && index < 37 && !this.insertItem(itemstack1, 2, 29, false)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.insertItem(itemstack1, 2, 38, false)) {
                return ItemStack.EMPTY;
            }

            if (itemstack1.getCount() == 0) {
                slot.setStack(ItemStack.EMPTY);
            } else {
                slot.markDirty();
            }

            if (itemstack1.getCount() == itemstack.getCount()) {
                return ItemStack.EMPTY;
            }

            slot.onTakeItem(playerIn, itemstack1);
        }

        return itemstack;
    }

}