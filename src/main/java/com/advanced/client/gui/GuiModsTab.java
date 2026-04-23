package com.advanced.client.gui;

import com.advanced.client.AdvancedClient;
import com.advanced.client.mods.Mod;
import com.advanced.client.gui.component.ModButton;
import net.minecraft.client.gui.GuiScreen;

import java.util.ArrayList;
import java.util.List;

public class GuiModsTab extends GuiScreen {

    private final List<ModButton> modButtons = new ArrayList<>();

    @Override
    public void initGui() {
        modButtons.clear();
        if (AdvancedClient.instance == null || AdvancedClient.instance.getModManager() == null) return;

        List<Mod> mods = AdvancedClient.instance.getModManager().getMods();
        int col = 0, row = 0;
        for (Mod mod : mods) {
            int bx = 10 + col * 120;
            int by = 40 + row * 30;
            modButtons.add(new ModButton(mod, bx, by, 110, 22));
            col++;
            if (col >= 4) { col = 0; row++; }
        }
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        drawDefaultBackground();
        fontRenderer.drawStringWithShadow("Mods", width / 2 - fontRenderer.getStringWidth("Mods") / 2, 15, 0xFFFFFF);
        for (ModButton btn : modButtons) {
            btn.draw(fontRenderer, mouseX, mouseY);
        }
        super.drawScreen(mouseX, mouseY, partialTicks);
    }

    @Override
    protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws java.io.IOException {
        for (ModButton btn : modButtons) {
            if (btn.isHovered(mouseX, mouseY)) {
                btn.onClick();
                return;
            }
        }
        super.mouseClicked(mouseX, mouseY, mouseButton);
    }
}
