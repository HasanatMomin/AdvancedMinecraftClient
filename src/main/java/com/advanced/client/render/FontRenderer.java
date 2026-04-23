package com.advanced.client.render;

import net.minecraft.client.Minecraft;

public class FontRenderer {

    private final net.minecraft.client.gui.FontRenderer mcFontRenderer;

    public FontRenderer() {
        this.mcFontRenderer = Minecraft.getMinecraft().fontRenderer;
    }

    public void drawString(String text, float x, float y, int color) {
        mcFontRenderer.drawString(text, x, y, color);
    }

    public void drawStringWithShadow(String text, float x, float y, int color) {
        mcFontRenderer.drawStringWithShadow(text, x, y, color);
    }

    public void drawCenteredString(String text, float x, float y, int color) {
        mcFontRenderer.drawString(text, x - getStringWidth(text) / 2.0f, y, color);
    }

    public void drawCenteredStringWithShadow(String text, float x, float y, int color) {
        mcFontRenderer.drawStringWithShadow(text, x - getStringWidth(text) / 2.0f, y, color);
    }

    public int getStringWidth(String text) {
        return mcFontRenderer.getStringWidth(text);
    }

    public int getFontHeight() {
        return mcFontRenderer.FONT_HEIGHT;
    }

    public net.minecraft.client.gui.FontRenderer getMcFontRenderer() {
        return mcFontRenderer;
    }
}
