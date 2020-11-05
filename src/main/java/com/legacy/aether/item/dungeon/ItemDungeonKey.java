package com.legacy.aether.item.dungeon;

import com.legacy.aether.item.AetherItemGroup;
import com.legacy.aether.item.ItemsAether;
import net.minecraft.item.Item;

public class ItemDungeonKey extends Item {

    public ItemDungeonKey() {
        super(new Settings().maxCount(1).group(AetherItemGroup.AETHER_MISC).rarity(ItemsAether.AETHER_LOOT));
    }

}