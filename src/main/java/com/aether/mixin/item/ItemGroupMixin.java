package com.aether.mixin.item;

import com.aether.items.utils.ItemGroupExpansions;
import net.minecraft.world.item.CreativeModeTab;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(CreativeModeTab.class)
public abstract class ItemGroupMixin implements ItemGroupExpansions {
    @Shadow
    @Final
    @Mutable
    public static CreativeModeTab[] TABS;

    @Override
    public void expandArray() {
        CreativeModeTab[] tempGroups = TABS;
        TABS = new CreativeModeTab[TABS.length + 1];

        System.arraycopy(tempGroups, 0, TABS, 0, tempGroups.length);
    }
}
