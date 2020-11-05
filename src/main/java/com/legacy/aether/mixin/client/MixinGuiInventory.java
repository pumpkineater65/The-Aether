package com.legacy.aether.mixin.client;

import com.legacy.aether.client.gui.button.GuiAccessoryButton;
import net.minecraft.client.gui.screen.ingame.AbstractInventoryScreen;
import net.minecraft.client.gui.screen.ingame.InventoryScreen;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.screen.PlayerScreenHandler;
import net.minecraft.text.TranslatableText;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(InventoryScreen.class)
public abstract class MixinGuiInventory extends AbstractInventoryScreen<PlayerScreenHandler> {

    public MixinGuiInventory(PlayerEntity player) {
        super(player.playerScreenHandler, player.inventory, new TranslatableText("container.crafting"));
    }

    @Inject(method = "init", at = @At("RETURN"))
    protected void initAccessoryButton(CallbackInfo ci) {
        this.addButton(new GuiAccessoryButton(this, this.x + 26, this.y + 65));
    }

}