package com.legacy.aether.item.weapon;

import com.legacy.aether.item.AetherItemGroup;
import com.legacy.aether.item.ItemsAether;
import net.fabricmc.fabric.api.object.builder.v1.client.model.FabricModelPredicateProviderRegistry;
import net.minecraft.item.BowItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;

public class ItemPhoenixBow extends BowItem {

    public ItemPhoenixBow() {
        super(new Item.Settings().maxDamage(384).group(AetherItemGroup.AETHER_WEAPONS));

        FabricModelPredicateProviderRegistry.register(new Identifier("pull"), (itemStack_1, world_1, livingEntity_1) -> {
            if (livingEntity_1 == null) {
                return 0.0F;
            } else {
                return livingEntity_1.getActiveItem().getItem() != ItemsAether.phoenix_bow ? 0.0F : (float) (itemStack_1.getMaxUseTime() - livingEntity_1.getItemUseTimeLeft()) / 20.0F;
            }
        });
    }
}
