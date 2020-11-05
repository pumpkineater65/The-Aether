package com.legacy.aether.client.gui.container;

import com.legacy.aether.blocks.entity.TreasureChestBlockEntity;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.ingame.GenericContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.GenericContainerScreenHandler;
import net.minecraft.text.TranslatableText;

public class GuITreasureChest extends GenericContainerScreen {

    public GuITreasureChest(int syncId, PlayerInventory playerInventory, TreasureChestBlockEntity inventory) {
        super(GenericContainerScreenHandler.createGeneric9x3(syncId, playerInventory, inventory), playerInventory, getTextComponent(inventory));
    }

    private static TranslatableText getTextComponent(TreasureChestBlockEntity inventory) {
        if (inventory.getDungeonType() == 0) {
            return new TranslatableText("aether_legacy.treasure_chest.bronze");
        } else if (inventory.getDungeonType() == 1) {
            return new TranslatableText("aether_legacy.treasure_chest.silver");
        } else if (inventory.getDungeonType() == 2) {
            return new TranslatableText("aether_legacy.treasure_chest.golden");
        }

        return new TranslatableText("aether_legacy.treasure_chest.platinum");
    }

    @Override
    public void init(MinecraftClient client, int width, int height) {
        super.init(client, width, height);

        client.player.currentScreenHandler = this.handler;
    }

}