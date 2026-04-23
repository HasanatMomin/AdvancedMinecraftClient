package com.maple.client.gui;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.network.chat.Component;
import org.lwjgl.input.Keyboard;
import com.maple.client.mods.ModManager;

public class MapleGuiClientSettings extends Screen {
    private int selectedTab = 0; // 0 = Mods, 1 = Settings
    private int modStartIndex = 0;
    private static final int MODS_PER_PAGE = 6;
    
    public MapleGuiClientSettings() {
        super(Component.literal("Maple Client Settings"));
    }
    
    @Override
    protected void init() {
        super.init();
        
        // Tab buttons
        this.addRenderableWidget(Button.builder(Component.literal("Mods"), (button) -> {
            selectedTab = 0;
        }).bounds(this.width / 4 - 50, this.height / 4 + 10, 100, 20).build());
        
        this.addRenderableWidget(Button.builder(Component.literal("Settings"), (button) -> {
            selectedTab = 1;
        }).bounds(this.width / 4 + 60, this.height / 4 + 10, 100, 20).build());
        
        // Close button
        this.addRenderableWidget(Button.builder(Component.literal("Close"), (button) -> {
            this.minecraft.setScreen(null);
        }).bounds(this.width - 110, this.height - 30, 100, 20).build());
    }
    
    @Override
    public void render(GuiGraphics guiGraphics, int pMouseX, int pMouseY, float pPartialTick) {
        this.renderBg(guiGraphics);
        
        // Draw blur background
        guiGraphics.fill(0, 0, this.width, this.height, 0x80000000);
        
        // Draw main panel
        int panelX = this.width / 4;
        int panelY = this.height / 4;
        int panelWidth = this.width / 2;
        int panelHeight = 3 * this.height / 4;
        guiGraphics.fill(panelX, panelY, panelX + panelWidth, panelY + panelHeight, 0xFF1F1F1F);
        
        // Draw title
        guiGraphics.drawCenteredString(this.font, "🍁 Maple Client Settings", this.width / 2, panelY + 10, 0xFF00AA00);
        
        if (selectedTab == 0) {
            renderModsTab(guiGraphics, panelX, panelY, panelWidth, panelHeight);
        } else {
            renderSettingsTab(guiGraphics, panelX, panelY, panelWidth, panelHeight);
        }
        
        super.render(guiGraphics, pMouseX, pMouseY, pPartialTick);
    }
    
    private void renderModsTab(GuiGraphics guiGraphics, int panelX, int panelY, int panelWidth, int panelHeight) {
        guiGraphics.drawString(this.font, "Available Mods (" + ModManager.getInstance().getAllMods().size() + ")", panelX + 10, panelY + 40, 0xFFFFFF);
        
        int offsetY = 60;
        var mods = ModManager.getInstance().getAllMods();
        for (int i = modStartIndex; i < Math.min(modStartIndex + MODS_PER_PAGE, mods.size()); i++) {
            var mod = mods.get(i);
            String status = mod.isEnabled() ? "✓" : "✗";
            String text = mod.getIcon() + " " + mod.getName() + " " + status;
            guiGraphics.drawString(this.font, text, panelX + 20, panelY + offsetY, mod.isEnabled() ? 0xFF00FF00 : 0xFFFF0000);
            offsetY += 20;
        }
    }
    
    private void renderSettingsTab(GuiGraphics guiGraphics, int panelX, int panelY, int panelWidth, int panelHeight) {
        guiGraphics.drawString(this.font, "Global Settings", panelX + 10, panelY + 40, 0xFFFFFF);
        
        int offsetY = 60;
        String[] settings = {
            "✓ Raw Mouse Input",
            "✗ Borderless Fullscreen",
            "✓ Cape Display",
            "Performance Level: 5/10"
        };
        
        for (String setting : settings) {
            guiGraphics.drawString(this.font, setting, panelX + 20, panelY + offsetY, 0xFFFFFF);
            offsetY += 20;
        }
    }
    
    @Override
    public boolean keyPressed(int pKeyCode, int pScanCode, int pModifiers) {
        if (pKeyCode == Keyboard.KEY_RSHIFT || pKeyCode == Keyboard.KEY_ESCAPE) {
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