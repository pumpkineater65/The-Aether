package com.legacy.aether.client.gui.dialogue;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.sound.SoundLoader;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.LiteralText;
import net.minecraft.text.OrderedText;
import net.minecraft.text.Text;

import java.util.ArrayList;

public class GuiDialogue extends Screen {

    private ArrayList<DialogueOption> dialogueOptions = new ArrayList<DialogueOption>();

    private String dialogue;

    public GuiDialogue(String dialogue) {
        super(new LiteralText(""));
        this.dialogue = dialogue;
    }

    public GuiDialogue(String dialogue, DialogueOption... options) {
        this(dialogue);

        this.addDialogueOptions(options);
    }

    public void addDialogueWithOptions(String dialogue, DialogueOption... options) {
        this.dialogue = dialogue;

        this.dialogueOptions.clear();

        this.addDialogueOptions(options);
        this.positionDialogueOptions(this.getDialogueOptions());
    }

    public void initGui() {
        this.positionDialogueOptions(this.getDialogueOptions());
    }

    private void positionDialogueOptions(ArrayList<DialogueOption> options) {
        int lineNumber = 0;

        for (DialogueOption option : options) {
            option.setDialogueId(lineNumber);
            option.setXPosition((this.width / 2) - (option.getWidth() / 2));
            option.setYPosition((this.height / 2) + this.textRenderer.wrapLines(new LiteralText(this.dialogue), 300).size() * 12 + 12 * lineNumber);

            lineNumber++;
        }
    }

    public void addDialogueOptions(DialogueOption... options) {
        for (DialogueOption option : options) {
            this.dialogueOptions.add(option);
        }
    }

    public void addDialogueMessage(String dialogueMessage) {
        MinecraftClient.getInstance().inGameHud.getChatHud().addMessage(new LiteralText(dialogueMessage));
    }

    public void dialogueTreeCompleted() {
        this.client.openScreen(null);
    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }

    @Override
    public void render(MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks) {
        super.render(matrixStack, mouseX, mouseY, partialTicks);

        int optionWidth = 0;

        /*for (OrderedText dialogueText : this.textRenderer.wrapLines(new LiteralText(this.dialogue), 300)) {
            String theDialogue = dialogueText.getString();
            int stringWidth = this.textRenderer.getWidth(theDialogue);

            this.drawTexture(matrixStack, this.width / 2 - stringWidth / 2 - 2, this.height / 2 + optionWidth * 12 - 2, this.width / 2 + stringWidth / 2 + 2, this.height / 2 + optionWidth * 10 + 10, 0x66000000, 0x66000000);
            this.drawStringWithShadow(matrixStack, this.textRenderer, theDialogue, this.width / 2 - stringWidth / 2, this.height / 2 + optionWidth * 10, 0xffffff);
            ++optionWidth;
        }*/

        for (DialogueOption dialogue : this.dialogueOptions) {
            dialogue.renderDialogue(matrixStack, mouseX, mouseY);
        }
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int mouseButton) {
        if (mouseButton == 0) {
            for (DialogueOption dialogue : this.dialogueOptions) {
                if (dialogue.isMouseOver(mouseX, mouseY)) {
                    dialogue.playPressSound(new SoundLoader(this.client.getResourceManager()));
                    this.dialogueClicked(dialogue);
                }
            }
        }

        return super.mouseClicked(mouseX, mouseY, mouseButton);
    }

    public void dialogueClicked(DialogueOption dialogue) {

    }

    public ArrayList<DialogueOption> getDialogueOptions() {
        return this.dialogueOptions;
    }

    public String getDialogue() {
        return this.dialogue;
    }

}