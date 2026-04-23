package com.advanced.client.gui;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;

public class GuiClientSettings extends GuiScreen {

    private int selectedTab = 0;

    @Override
    public void initGui() {
        buttonList.add(new GuiButton(0, 10, 10, 80, 20, "Mods"));
        buttonList.add(new GuiButton(1, 100, 10, 80, 20, "Settings"));
        buttonList.add(new GuiButton(2, 190, 10, 80, 20, "HUD"));
        buttonList.add(new GuiButton(99, width / 2 - 50, height - 30, 100, 20, "Close"));
    }

    @Override
    protected void actionPerformed(GuiButton button) {
        if (button.id == 99) {
            mc.displayGuiScreen(null);
        } else if (button.id >= 0 && button.id <= 2) {
            selectedTab = button.id;
        }
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        drawDefaultBackground();
        fontRenderer.drawStringWithShadow("Advanced Client Settings", width / 2 - fontRenderer.getStringWidth("Advanced Client Settings") / 2, 50, 0xFFFFFF);

        switch (selectedTab) {
            case 0:
                fontRenderer.drawStringWithShadow("[ Mods Tab ]", 20, 80, 0xAAAAAA);
                break;
            case 1:
                fontRenderer.drawStringWithShadow("[ Settings Tab ]", 20, 80, 0xAAAAAA);
                break;
            case 2:
                fontRenderer.drawStringWithShadow("[ HUD Customization ]", 20, 80, 0xAAAAAA);
                break;
        }

        super.drawScreen(mouseX, mouseY, partialTicks);
    }

    @Override
    public boolean doesGuiPauseGame() {
        return false;
    }
}
