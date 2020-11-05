package com.legacy.aether.container.slot;

import com.legacy.aether.api.AetherAPI;
import com.legacy.aether.api.accessories.AccessoryType;
import com.legacy.aether.api.accessories.AetherAccessory;
import com.legacy.aether.api.player.util.AccessoryInventory;
import com.mojang.datafixers.util.Pair;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.slot.Slot;
import net.minecraft.util.Identifier;

public class SlotAccessory extends Slot {

    private AccessoryType type;

    public SlotAccessory(AccessoryInventory inventory, AccessoryType type, int slotID, int x, int y) {
        super(inventory, slotID, x, y);

        this.type = type;
    }

    @Override
    public boolean canInsert(ItemStack stack) {
        AetherAccessory accessory = AetherAPI.instance().getAccessory(stack);

        return accessory != null && (accessory.getAccessoryType() == this.type || accessory.getExtraType() == this.type);
    }

    @Environment(EnvType.CLIENT)
    public Pair<Identifier, Identifier> getBackgroundSprite() {
        return new Pair<>(new Identifier("aether_legacy:item/sprite/"), new Identifier(this.type.getDisplayName()));
    }

    public AccessoryType getType() {
        return this.type;
    }

}