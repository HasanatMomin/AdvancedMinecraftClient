package com.advanced.client.gui.component;

import com.advanced.client.render.RenderUtils;
import net.minecraft.client.gui.FontRenderer;

public class SettingsToggle {

    private final String label;
    private boolean value;
    private final int x, y, width, height;

    public SettingsToggle(String label, boolean value, int x, int y, int width, int height) {
        this.label = label;
        this.value = value;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void draw(FontRenderer fr, int mouseX, int mouseY) {
        int bg = value ? 0xAA00AA00 : 0xAA880000;
        RenderUtils.drawRect(x, y, width, height, bg);
        String text = label + ": " + (value ? "ON" : "OFF");
        fr.drawStringWithShadow(text, x + 5, y + (height - 8) / 2f, 0xFFFFFF);
    }

    public boolean isHovered(int mouseX, int mouseY) {
        return mouseX >= x && mouseX <= x + width && mouseY >= y && mouseY <= y + height;
    }

    public void toggle() {
        value = !value;
    }

    public boolean getValue() { return value; }
}
