package com.advanced.client.gui.component;

import com.advanced.client.render.RenderUtils;
import net.minecraft.client.gui.FontRenderer;

public class PerformanceSlider {

    private final String label;
    private float value;
    private final float min, max;
    private final int x, y, width, height;
    private boolean dragging = false;

    public PerformanceSlider(String label, float value, float min, float max, int x, int y, int width, int height) {
        this.label = label;
        this.value = value;
        this.min = min;
        this.max = max;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void draw(FontRenderer fr, int mouseX, int mouseY) {
        RenderUtils.drawRect(x, y, width, height, 0xAA333333);
        float ratio = (value - min) / (max - min);
        int filledWidth = (int)(width * ratio);
        RenderUtils.drawRect(x, y, filledWidth, height, 0xAA0077FF);
        String text = label + ": " + String.format("%.1f", value);
        fr.drawStringWithShadow(text, x + 5, y + (height - 8) / 2f, 0xFFFFFF);
    }

    public boolean isHovered(int mouseX, int mouseY) {
        return mouseX >= x && mouseX <= x + width && mouseY >= y && mouseY <= y + height;
    }

    public void onMouseClick(int mouseX, int mouseY) {
        if (isHovered(mouseX, mouseY)) {
            dragging = true;
            updateValue(mouseX);
        }
    }

    public void onMouseDrag(int mouseX) {
        if (dragging) updateValue(mouseX);
    }

    public void onMouseRelease() {
        dragging = false;
    }

    private void updateValue(int mouseX) {
        float ratio = (float)(mouseX - x) / width;
        value = min + (max - min) * Math.max(0, Math.min(1, ratio));
    }

    public float getValue() { return value; }
}
