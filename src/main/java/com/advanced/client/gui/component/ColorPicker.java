package com.advanced.client.gui.component;

import com.advanced.client.render.RenderUtils;
import com.advanced.client.util.ColorUtils;
import net.minecraft.client.gui.FontRenderer;

public class ColorPicker {

    private int color;
    private float hue, saturation, brightness;
    private final int x, y, width, height;

    public ColorPicker(int color, int x, int y, int width, int height) {
        this.color = color;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        float[] hsb = java.awt.Color.RGBtoHSB(
                ColorUtils.getRed(color), ColorUtils.getGreen(color), ColorUtils.getBlue(color), null);
        hue = hsb[0];
        saturation = hsb[1];
        brightness = hsb[2];
    }

    public void draw(FontRenderer fr, int mouseX, int mouseY) {
        // Draw color preview
        RenderUtils.drawRect(x, y, width, height, color | 0xFF000000);
        fr.drawStringWithShadow("Color: " + ColorUtils.toHexString(color), x + width + 5, y + 2, 0xFFFFFF);

        // Draw hue bar
        for (int i = 0; i < width; i++) {
            float h = (float) i / width;
            int c = java.awt.Color.HSBtoRGB(h, 1.0f, 1.0f);
            RenderUtils.drawRect(x + i, y + height + 4, 1, 10, c | 0xFF000000);
        }
    }

    public void onMouseClick(int mouseX, int mouseY) {
        if (mouseX >= x && mouseX <= x + width && mouseY >= y + height + 4 && mouseY <= y + height + 14) {
            hue = (float)(mouseX - x) / width;
            updateColor();
        }
    }

    private void updateColor() {
        color = java.awt.Color.HSBtoRGB(hue, saturation, brightness);
    }

    public int getColor() { return color; }
    public void setColor(int color) {
        this.color = color;
        float[] hsb = java.awt.Color.RGBtoHSB(
                ColorUtils.getRed(color), ColorUtils.getGreen(color), ColorUtils.getBlue(color), null);
        hue = hsb[0]; saturation = hsb[1]; brightness = hsb[2];
    }
}
