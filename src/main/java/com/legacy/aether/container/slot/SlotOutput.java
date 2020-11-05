package com.legacy.aether.container.slot;

import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.slot.Slot;

public class SlotOutput extends Slot {

    public SlotOutput(Inventory inventoryIn, int indexIn, int xIn, int yIn) {
        super(inventoryIn, indexIn, xIn, yIn);
    }

    @Override
    public boolean canInsert(ItemStack stackIn) {
        return false;
    }

}