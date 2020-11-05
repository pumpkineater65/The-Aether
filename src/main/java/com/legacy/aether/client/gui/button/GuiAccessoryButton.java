package com.legacy.aether.client.gui.button;

import com.legacy.aether.Aether;
import com.legacy.aether.client.gui.container.GuiAccessories;
import com.mojang.blaze3d.platform.GlStateManager;
import io.netty.buffer.Unpooled;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.ingame.InventoryScreen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.network.packet.c2s.play.CustomPayloadC2SPacket;
import net.minecraft.text.LiteralText;
import net.minecraft.util.Identifier;

public class GuiAccessoryButton extends ButtonWidget {

    private static final Identifier TEXTURE = Aether.locate("textures/gui/inventory/button/cloud.png");

    private static final Identifier HOVERED_TEXTURE = Aether.locate("textures/gui/inventory/button/cloud_hover.png");

    private Screen screen;

    public GuiAccessoryButton(Screen screen, int xIn, int yIn) {
        super(xIn, yIn, 12, 12, new LiteralText(""), null);

        this.screen = screen;
    }

    public GuiAccessoryButton setPosition(int x, int y) {
        this.x = x;
        this.y = y;

        return this;
    }

    @Override
    public void onPress() {
        MinecraftClient mc = MinecraftClient.getInstance();

        if (mc.currentScreen instanceof GuiAccessories) {
            mc.openScreen(new InventoryScreen(mc.player));
        } else {
            mc.player.networkHandler.sendPacket(new CustomPayloadC2SPacket(Aether.locate("open_accessories"), new PacketByteBuf(Unpooled.buffer())));
        }
    }

    @Override
    public void render(MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks) {
        if (this.visible) {
            GlStateManager.color4f(1.0F, 1.0F, 1.0F, 1.0F);
            GlStateManager.pushMatrix();
            MinecraftClient.getInstance().getTextureManager().bindTexture(this.isHovered() ? HOVERED_TEXTURE : TEXTURE);
            GlStateManager.enableBlend();

            drawTexture(matrixStack, this.x - 1, this.y, 0, 0, 14, 14, 14, 14);

            GlStateManager.popMatrix();
        }
    }

}