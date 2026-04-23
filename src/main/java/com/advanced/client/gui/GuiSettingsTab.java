package com.advanced.client.gui;

import com.advanced.client.AdvancedClient;
import com.advanced.client.settings.ClientSettings;
import com.advanced.client.gui.component.SettingsToggle;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;

import java.util.ArrayList;
import java.util.List;

public class GuiSettingsTab extends GuiScreen {

    private final List<SettingsToggle> toggles = new ArrayList<>();

    @Override
    public void initGui() {
        toggles.clear();
        ClientSettings settings = AdvancedClient.instance != null ? AdvancedClient.instance.getClientSettings() : null;
        if (settings == null) return;

        int y = 40;
        toggles.add(new SettingsToggle("Raw Mouse Input", settings.isRawMouseInput(), 10, y, 200, 20));
        y += 25;
        toggles.add(new SettingsToggle("Borderless Fullscreen", settings.isBorderlessFullscreen(), 10, y, 200, 20));
        y += 25;
        toggles.add(new SettingsToggle("Disable Hotbar Scroll", settings.isDisableHotbarScroll(), 10, y, 200, 20));
        y += 25;
        toggles.add(new SettingsToggle("Cape Enabled", settings.isCapeEnabled(), 10, y, 200, 20));

        buttonList.add(new GuiButton(99, width / 2 - 50, height - 30, 100, 20, "Close"));
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        drawDefaultBackground();
        fontRenderer.drawStringWithShadow("Settings", width / 2 - fontRenderer.getStringWidth("Settings") / 2, 15, 0xFFFFFF);
        for (SettingsToggle t : toggles) {
            t.draw(fontRenderer, mouseX, mouseY);
        }
        super.drawScreen(mouseX, mouseY, partialTicks);
    }

    @Override
    protected void actionPerformed(GuiButton button) {
        if (button.id == 99) mc.displayGuiScreen(null);
    }

    @Override
    protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws java.io.IOException {
        for (SettingsToggle t : toggles) {
            if (t.isHovered(mouseX, mouseY)) {
                t.toggle();
                return;
            }
        }
        super.mouseClicked(mouseX, mouseY, mouseButton);
    }
}
