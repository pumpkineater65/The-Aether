package com.legacy.aether.client.gui.container;

import com.legacy.aether.Aether;
import com.legacy.aether.client.gui.button.GuiAccessoryButton;
import com.legacy.aether.container.ContainerAccessories;
import com.mojang.blaze3d.platform.GlStateManager;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.gui.screen.ingame.InventoryScreen;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Identifier;

public class GuiAccessories extends HandledScreen<ContainerAccessories> {

    private static final Identifier TEXTURE = Aether.locate("textures/gui/inventory/accessories.png");

    public GuiAccessories(int syncId, PlayerEntity playerAetherIn) {
        super(new ContainerAccessories(syncId, playerAetherIn), playerAetherIn.inventory, new TranslatableText("container.crafting"));
    }

    @Override
    public void init(MinecraftClient client, int width, int height) {
        super.init(client, width, height);

        client.player.currentScreenHandler = this.handler;

        this.addButton(new GuiAccessoryButton(this, this.x + 8, this.y + 65));
    }

    @Override
    public void render(MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks) {
        this.drawBackground(matrixStack, partialTicks, mouseX, mouseY);
        super.render(matrixStack, mouseX, mouseY, partialTicks);
        this.drawMouseoverTooltip(matrixStack, mouseX, mouseY);
    }

    @Override
    protected void drawForeground(MatrixStack matrixStack, int mouseX, int mouseY) {
        this.textRenderer.draw(matrixStack, this.title.asString(), 115, 8, 4210752);
    }

    @Override
    protected void drawBackground(MatrixStack matrixStack, float partialTicks, int mouseX, int mouseY) {
        GlStateManager.color4f(1.0F, 1.0F, 1.0F, 1.0F);

        this.client.getTextureManager().bindTexture(TEXTURE);

        this.drawTexture(matrixStack, this.x, this.y, 0, 0, 176, 166);

        InventoryScreen.drawEntity(this.x + 35, this.y + 75, 30, (float) (this.x + 51) - (float) mouseX, (float) (this.y + 75 - 50) - (float) mouseY, this.client.player);
    }

}