package com.maple.client.gui;

import net.minecraft.client.gui.screens.TitleScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;

public class MapleGuiMainMenu extends TitleScreen {
    
    @Override
    protected void init() {
        super.init();
        this.clearWidgets();
        
        // Maple Client Title
        int titleX = this.width / 2;
        int titleY = this.height / 4;
        
        // Launch Game Button
        this.addRenderableWidget(Button.builder(Component.literal("Launch Game"), (button) -> {
            this.minecraft.setScreen(null);
        }).bounds(this.width / 2 - 100, this.height / 2, 200, 20).build());
        
        // Client Settings Button
        this.addRenderableWidget(Button.builder(Component.literal("🍁 Maple Client Settings"), (button) -> {
            this.minecraft.setScreen(new MapleGuiClientSettings());
        }).bounds(this.width / 2 - 100, this.height / 2 + 30, 200, 20).build());
        
        // Exit Button
        this.addRenderableWidget(Button.builder(Component.literal("Exit"), (button) -> {
            this.minecraft.stop();
        }).bounds(this.width / 2 - 100, this.height / 2 + 60, 200, 20).build());
    }
    
    @Override
    public void render(GuiGraphics guiGraphics, int pMouseX, int pMouseY, float pPartialTick) {
        super.render(guiGraphics, pMouseX, pMouseY, pPartialTick);
        guiGraphics.drawCenteredString(this.font, "🍁 Maple Client v1.0.0 🍁", this.width / 2, 20, 0xFF00AA00);
    }
}