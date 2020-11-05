package com.legacy.aether.item.staff;

import com.legacy.aether.item.AetherItemGroup;
import net.minecraft.item.Item;

public class ItemNatureStaff extends Item {

    public ItemNatureStaff() {
        super(new Settings().maxCount(1).maxDamage(100).group(AetherItemGroup.AETHER_MISC));
    }

}