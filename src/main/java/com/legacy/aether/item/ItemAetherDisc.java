package com.legacy.aether.item;

import net.minecraft.item.MusicDiscItem;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Rarity;

public class ItemAetherDisc extends MusicDiscItem {

    public ItemAetherDisc(int comparatorValueIn, SoundEvent soundIn) {
        super(comparatorValueIn, soundIn, new Settings().maxCount(1).group(AetherItemGroup.AETHER_MISC).rarity(Rarity.RARE));
    }

}