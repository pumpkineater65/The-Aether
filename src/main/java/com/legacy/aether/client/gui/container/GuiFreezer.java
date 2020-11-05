package com.legacy.aether.client.gui.container;

import com.legacy.aether.Aether;
import com.legacy.aether.blocks.entity.AetherBlockEntity;
import com.legacy.aether.container.ContainerFreezer;
import com.mojang.blaze3d.platform.GlStateManager;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Identifier;

public class GuiFreezer extends HandledScreen<ContainerFreezer> {

    private static final Identifier TEXTURE = Aether.locate("textures/gui/freezer.png");

    private AetherBlockEntity freezer;

    public GuiFreezer(int syncId, PlayerInventory inventoryIn, AetherBlockEntity enchanterIn) {
        super(new ContainerFreezer(syncId, inventoryIn, enchanterIn), inventoryIn, new TranslatableText("container.inventory"));

        this.freezer = enchanterIn;
    }

    @Override
    public void init(MinecraftClient client, int width, int height) {
        super.init(client, width, height);

        client.player.currentScreenHandler = this.handler;
    }

    @Override
    public void render(MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks) {
        this.drawBackground(matrixStack, partialTicks, mouseX, mouseY);
        super.render(matrixStack, mouseX, mouseY, partialTicks);
        this.drawMouseoverTooltip(matrixStack, mouseX, mouseY);
    }

    @Override
    protected void drawForeground(MatrixStack matrixStack, int par1, int par2) {
        String name = this.freezer.getName().asString();

        this.textRenderer.draw(matrixStack, name, this.width / 2f - this.textRenderer.getWidth(name) / 2f, 6, 4210752);
        this.textRenderer.draw(matrixStack, this.title.asString(), 8, this.height - 96 + 2, 4210752);
    }

    @Override
    protected void drawBackground(MatrixStack matrixStack, float arg0, int arg1, int arg2) {
        GlStateManager.color4f(1.0F, 1.0F, 1.0F, 1.0F);

        this.client.getTextureManager().bindTexture(TEXTURE);

        int k = this.x;
        int l = this.y;

        this.drawTexture(matrixStack, k, l, 0, 0, this.width, this.height);

        int i1;

        if (this.freezer.get(1) > 0) {
            i1 = this.getTimeRemaining(12);

            this.drawTexture(matrixStack, k + 56, l + 36 + 12 - i1, 176, 12 - i1, 14, i1 + 2);
        }

        i1 = this.getProgressScaled(24);

        this.drawTexture(matrixStack, k + 79, l + 34, 176, 14, i1 + 1, 16);
    }

    private int getProgressScaled(int i) {
        if (this.freezer.get(2) == 0) {
            return 0;
        }

        return (this.freezer.get(0) * i) / this.freezer.get(2);
    }

    private int getTimeRemaining(int i) {
        return (this.freezer.get(1) * i) / 500;
    }

}