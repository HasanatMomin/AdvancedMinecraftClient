package com.maple.client.gui;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import org.lwjgl.input.Keyboard;
import com.maple.client.mods.ModManager;
import com.maple.client.mods.Mod;
import java.util.List;

public class MapleGuiClientSettings extends Screen {
    private int selectedTab = 0; // 0 = Mods, 1 = Settings
    private int scrollOffset = 0;
    
    public MapleGuiClientSettings() {
        super(Component.literal("🍁 Maple Client Settings"));
    }
    
    @Override
    public void render(GuiGraphics guiGraphics, int pMouseX, int pMouseY, float pPartialTick) {
        this.renderBg(guiGraphics);
        guiGraphics.fill(0, 0, this.width, this.height, 0x80000000);
        
        int panelX = this.width / 4;
        int panelY = this.height / 4;
        int panelWidth = this.width / 2;
        int panelHeight = this.height / 2;
        
        guiGraphics.fill(panelX, panelY, panelX + panelWidth, panelY + panelHeight, 0xFF1F1F1F);
        guiGraphics.drawCenteredString(this.font, "🍁 Maple Client Settings", this.width / 2, panelY + 10, 0xFFFFFF);
        
        // Tab buttons
        guiGraphics.fill(panelX + 20, panelY + 35, panelX + 80, panelY + 50, selectedTab == 0 ? 0xFF00AA00 : 0xFF666666);
        guiGraphics.drawCenteredString(this.font, "Mods", panelX + 50, panelY + 38, 0xFFFFFF);
        
        guiGraphics.fill(panelX + 90, panelY + 35, panelX + 150, panelY + 50, selectedTab == 1 ? 0xFF00AA00 : 0xFF666666);
        guiGraphics.drawCenteredString(this.font, "Settings", panelX + 120, panelY + 38, 0xFFFFFF);
        
        if (selectedTab == 0) {
            renderModsList(guiGraphics, panelX, panelY, panelWidth, panelHeight);
        } else {
            renderSettingsList(guiGraphics, panelX, panelY, panelWidth, panelHeight);
        }
    }
    
    private void renderModsList(GuiGraphics guiGraphics, int x, int y, int width, int height) {
        List<Mod> mods = ModManager.getInstance().getAllMods();
        int offsetY = 65;
        
        for (Mod mod : mods) {
            String status = mod.isEnabled() ? "✓" : "✗";
            String text = mod.getIcon() + " " + mod.getName() + " [" + status + "]";
            guiGraphics.drawString(this.font, text, x + 20, y + offsetY, 0xFFFFFF);
            offsetY += 15;
            
            if (offsetY > y + height - 30) break;
        }
    }
    
    private void renderSettingsList(GuiGraphics guiGraphics, int x, int y, int width, int height) {
        guiGraphics.drawString(this.font, "Performance Level: 5/10", x + 20, y + 65, 0xFFFFFF);
        guiGraphics.drawString(this.font, "Raw Mouse Input: ON", x + 20, y + 80, 0xFFFFFF);
        guiGraphics.drawString(this.font, "Cape Enabled: ON", x + 20, y + 95, 0xFFFFFF);
        guiGraphics.drawString(this.font, "Borderless Fullscreen: OFF", x + 20, y + 110, 0xFFFFFF);
    }
    
    @Override
    public boolean keyPressed(int pKeyCode, int pScanCode, int pModifiers) {
        if (pKeyCode == Keyboard.KEY_RSHIFT || pKeyCode == Keyboard.KEY_ESCAPE) {
            this.minecraft.setScreen(null);
            return true;
        }
        
        if (pKeyCode == Keyboard.KEY_TAB) {
            selectedTab = (selectedTab + 1) % 2;
            return true;
        }
        
        return super.keyPressed(pKeyCode, pScanCode, pModifiers);
    }
    
    @Override
    public boolean mouseScrolled(double pMouseX, double pMouseY, double pScrollX, double pScrollY) {
        scrollOffset -= (int) pScrollY * 5;
        return true;
    }
    
    @Override
    public boolean isPauseScreen() {
        return false;
    }
}