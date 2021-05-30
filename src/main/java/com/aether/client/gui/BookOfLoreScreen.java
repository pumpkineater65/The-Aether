package com.aether.client.gui;

import com.aether.Aether;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.NarratorManager;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class BookOfLoreScreen extends Screen {

    public static final Identifier PAGE_TEXTURE_LEFT = Aether.locate("textures/gui/lore_book_l.png");
    public static final Identifier PAGE_TEXTURE_RIGHT = Aether.locate("textures/gui/lore_book_r.png");

    private final Style unicodeStyle;
    private Text testText;

    public BookOfLoreScreen() {
        super(NarratorManager.EMPTY);
        unicodeStyle = Style.EMPTY.withFont(MinecraftClient.UNICODE_FONT_ID);
    }

    @Override
    public void init(MinecraftClient client, int width, int height) {
        super.init(client, width, height);

        testText = new TranslatableText("optimizeWorld.confirm.description").setStyle(unicodeStyle);
    }

    @Override
    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        this.renderBackground(matrices);

        final int w = this.width / 2;
        final int h = this.height / 2;

        this.client.getTextureManager().bindTexture(PAGE_TEXTURE_LEFT);
        this.drawTexture(matrices, w - 136, h - 90, 0, 0, 136, 180);

        this.client.getTextureManager().bindTexture(PAGE_TEXTURE_RIGHT);
        this.drawTexture(matrices, w, h - 90, 0, 0, 136, 180);

        this.textRenderer.draw(matrices, testText, w - 120, h, 0);

        super.render(matrices, mouseX, mouseY, delta);
    }
}
