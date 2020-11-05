package com.legacy.aether.client.gui.dialogue;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.sound.PositionedSoundInstance;
import net.minecraft.client.sound.SoundLoader;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.LiteralText;
import net.minecraft.util.Formatting;

public class DialogueOption extends Screen {

    private int dialogueId;

    private String dialogueText;

    private int xPosition, yPosition;

    private int height, width;

    private MinecraftClient mc = MinecraftClient.getInstance();

    public DialogueOption(String dialogueText) {
        super(new LiteralText(""));
        this.dialogueText = "[" + dialogueText + "]";
        this.height = 12;
        this.width = this.mc.textRenderer.getWidth(this.dialogueText) + 2;
    }

    public void renderDialogue(MatrixStack matrixStack, double mouseX, double mouseY) {
        this.drawTexture(matrixStack, this.xPosition, this.yPosition, this.xPosition + this.width, this.yPosition + this.height, 0x66000000, 0x66000000);
        this.drawStringWithShadow(matrixStack, this.mc.textRenderer, this.isMouseOver(mouseX, mouseY) ? Formatting.YELLOW.toString() + this.getDialogueText() : this.getDialogueText(), this.xPosition + 2, this.yPosition + 2, 0xffffff);
    }

    public boolean isMouseOver(double mouseX, double mouseY) {
        return mouseX >= this.xPosition && mouseY >= this.yPosition && mouseX < this.xPosition + this.width && mouseY < this.yPosition + this.height;
    }

    public void playPressSound(SoundLoader soundHandlerIn) {
        soundHandlerIn.loadStatic(PositionedSoundInstance.master(SoundEvents.UI_BUTTON_CLICK, 1.0F).getId());
    }

    public void setXPosition(int xPosition) {
        this.xPosition = xPosition;
    }

    public void setYPosition(int yPosition) {
        this.yPosition = yPosition;
    }

    public int getDialogueId() {
        return this.dialogueId;
    }

    public void setDialogueId(int id) {
        this.dialogueId = id;
    }

    public int getHeight() {
        return this.height;
    }

    public int getWidth() {
        return this.width;
    }

    public String getDialogueText() {
        return this.dialogueText;
    }

    public void setDialogueText(String dialogueText) {
        this.dialogueText = "[" + dialogueText + "]";
        this.width = this.mc.textRenderer.getWidth(this.dialogueText) + 2;
    }

}