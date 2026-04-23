package com.advanced.client.gui;

import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.GlStateManager;

public class AdvancedGuiMainMenu extends GuiMainMenu {

    @Override
    public void initGui() {
        super.initGui();
        buttonList.add(new GuiButton(9999, width / 2 - 100, height / 4 + 144 + 12, "Advanced Client"));
    }

    @Override
    protected void actionPerformed(GuiButton button) throws java.io.IOException {
        if (button.id == 9999) {
            mc.displayGuiScreen(new GuiClientSettings());
            return;
        }
        super.actionPerformed(button);
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        super.drawScreen(mouseX, mouseY, partialTicks);
        fontRenderer.drawStringWithShadow("Advanced Client v1.0.0", 2, 2, 0xFFFFFF);
    }
}
