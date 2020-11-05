package com.legacy.aether.container.slot;

import com.legacy.aether.item.ItemsAether;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.slot.Slot;

public class SlotIncubator extends Slot {

    public SlotIncubator(Inventory inv, int slot, int x, int y) {
        super(inv, slot, x, y);
    }

    @Override
    public boolean canInsert(ItemStack stack) {
        return stack.getItem() == ItemsAether.moa_egg;
    }

    /*@Override
    public int getMaxStackAmount() {
        return 1;
    }*/

}