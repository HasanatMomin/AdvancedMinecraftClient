package com.advanced.client.gui;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import org.lwjgl.glfw.GLFW;

public class GuiClientSettings extends Screen {

    private int selectedTab = 0; // 0 = Mods, 1 = Settings

    public GuiClientSettings() {
        super(Component.literal("Client Settings"));
    }

    @Override
    public void render(GuiGraphics guiGraphics, int pMouseX, int pMouseY, float pPartialTick) {
        this.renderBackground(guiGraphics);

        // Draw semi-transparent background overlay
        guiGraphics.fill(0, 0, this.width, this.height, 0x80000000);

        // Draw main panel
        int panelX = this.width / 4;
        int panelY = this.height / 4;
        int panelWidth = this.width / 2;
        int panelHeight = this.height / 2;
        guiGraphics.fill(panelX, panelY, panelX + panelWidth, panelY + panelHeight, 0xFF1F1F1F);

        // Draw title
        guiGraphics.drawCenteredString(this.font, "Client Settings", this.width / 2, panelY + 10, 0xFFFFFF);

        // Draw active tab label
        String tabLabel = selectedTab == 0 ? "Mods" : "Settings";
        guiGraphics.drawString(this.font, tabLabel, panelX + 20, panelY + 35, 0xFFFFFF);

        super.render(guiGraphics, pMouseX, pMouseY, pPartialTick);
    }

    @Override
    public boolean keyPressed(int pKeyCode, int pScanCode, int pModifiers) {
        if (pKeyCode == GLFW.GLFW_KEY_RIGHT_SHIFT || pKeyCode == GLFW.GLFW_KEY_ESCAPE) {
            this.minecraft.setScreen(null);
            return true;
        }
        return super.keyPressed(pKeyCode, pScanCode, pModifiers);
    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }
}
