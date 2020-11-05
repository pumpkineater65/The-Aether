package com.legacy.aether.client.gui.container;

import com.legacy.aether.Aether;
import com.legacy.aether.blocks.entity.AetherBlockEntity;
import com.legacy.aether.blocks.entity.IncubatorBlockEntity;
import com.legacy.aether.container.ContainerIncubator;
import com.mojang.blaze3d.platform.GlStateManager;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Identifier;

public class GuiIncubator extends HandledScreen<ContainerIncubator> {

    private static final Identifier TEXTURE_INCUBATOR = Aether.locate("textures/gui/incubator.png");
    private AetherBlockEntity incubator;

    public GuiIncubator(int syncId, PlayerInventory inventoryIn, AetherBlockEntity incubatorIn) {
        super(new ContainerIncubator(syncId, inventoryIn, incubatorIn), inventoryIn, new TranslatableText("container.inventory"));

        this.incubator = incubatorIn;
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
        String incubatorName = this.incubator.getName().asString();
        IncubatorBlockEntity entity = ((IncubatorBlockEntity) this.incubator);

        if (entity.ownerName != null) {
            incubatorName = ((IncubatorBlockEntity) this.incubator).ownerName + "'s " + incubatorName;
        }

        this.textRenderer.draw(matrixStack, incubatorName, this.width / 2 - this.textRenderer.getWidth(incubatorName) / 2, 6, 4210752);
        this.textRenderer.draw(matrixStack, this.title.asString(), 8, this.height - 96 + 2, 0x404040);
    }

    @Override
    protected void drawBackground(MatrixStack matrixStack, float f, int ia, int ib) {
        GlStateManager.color4f(1.0F, 1.0F, 1.0F, 1.0F);

        this.client.getTextureManager().bindTexture(TEXTURE_INCUBATOR);

        int j = this.x;
        int k = this.y;

        this.drawTexture(matrixStack, j, k, 0, 0, this.width, this.height);

        if (this.incubator.get(1) > 0) {
            int l = this.getTimeRemaining(12);

            this.drawTexture(matrixStack, j + 74, (k + 47) - l, 176, 12 - l, 14, l + 2);
        }

        int i1 = this.getProgressScaled(54);

        this.drawTexture(matrixStack, j + 103, k + 70 - i1, 179, 70 - i1, 10, i1);
    }

    public int getProgressScaled(int i) {
        return (this.incubator.get(1) * i) / 5700;
    }

    public int getTimeRemaining(int i) {
        return (this.incubator.get(0) * i) / 500;
    }

}