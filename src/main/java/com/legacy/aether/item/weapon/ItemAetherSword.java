package com.legacy.aether.item.weapon;

import com.legacy.aether.item.AetherItemGroup;
import com.legacy.aether.item.util.AetherTier;
import net.minecraft.item.SwordItem;
import net.minecraft.util.Rarity;

public class ItemAetherSword extends SwordItem {

    private final AetherTier material;

    public ItemAetherSword(AetherTier material, int damageVsEntity, float attackSpeed) {
        super(material.getDefaultTier(), damageVsEntity, attackSpeed, new Settings().group(AetherItemGroup.AETHER_WEAPONS));

        this.material = material;
    }

    public ItemAetherSword(AetherTier material, Rarity rarity, int damageVsEntity, float attackSpeed) {
        super(material.getDefaultTier(), damageVsEntity, attackSpeed, new Settings().group(AetherItemGroup.AETHER_WEAPONS).rarity(rarity));

        this.material = material;
    }

}