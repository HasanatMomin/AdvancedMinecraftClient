package com.advanced.client.gui;

import com.advanced.client.AdvancedClient;
import com.advanced.client.mods.Mod;
import com.advanced.client.gui.component.HudElement;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;

import java.util.ArrayList;
import java.util.List;

public class GuiHudCustomization extends GuiScreen {

    private final List<HudElement> elements = new ArrayList<>();
    private HudElement dragging = null;
    private int dragOffX, dragOffY;

    @Override
    public void initGui() {
        elements.clear();
        if (AdvancedClient.instance == null || AdvancedClient.instance.getModManager() == null) return;
        for (Mod mod : AdvancedClient.instance.getModManager().getMods()) {
            if (mod.isEnabled()) {
                elements.add(new HudElement(mod));
            }
        }
        buttonList.add(new GuiButton(99, width / 2 - 50, height - 30, 100, 20, "Done"));
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        drawDefaultBackground();
        fontRenderer.drawStringWithShadow("HUD Customization - Drag elements to reposition", 5, 5, 0xAAAAAA);
        for (HudElement el : elements) {
            el.draw(fontRenderer, mouseX, mouseY);
        }
        super.drawScreen(mouseX, mouseY, partialTicks);
    }

    @Override
    protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws java.io.IOException {
        if (mouseButton == 0) {
            for (HudElement el : elements) {
                if (el.isHovered(mouseX, mouseY)) {
                    dragging = el;
                    dragOffX = mouseX - (int) el.getMod().getX();
                    dragOffY = mouseY - (int) el.getMod().getY();
                    return;
                }
            }
        }
        super.mouseClicked(mouseX, mouseY, mouseButton);
    }

    @Override
    protected void mouseReleased(int mouseX, int mouseY, int state) {
        dragging = null;
        super.mouseReleased(mouseX, mouseY, state);
    }

    @Override
    protected void mouseClickMove(int mouseX, int mouseY, int clickedMouseButton, long timeSinceLastClick) {
        if (dragging != null) {
            dragging.getMod().setX(mouseX - dragOffX);
            dragging.getMod().setY(mouseY - dragOffY);
        }
    }

    @Override
    protected void actionPerformed(GuiButton button) {
        if (button.id == 99) mc.displayGuiScreen(null);
    }
}
