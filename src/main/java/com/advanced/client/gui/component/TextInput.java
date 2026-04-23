package com.advanced.client.gui.component;

import com.advanced.client.render.RenderUtils;
import net.minecraft.client.gui.FontRenderer;

public class TextInput {

    private String text = "";
    private final String placeholder;
    private boolean focused = false;
    private final int x, y, width, height;
    private final int maxLength;

    public TextInput(String placeholder, int x, int y, int width, int height, int maxLength) {
        this.placeholder = placeholder;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.maxLength = maxLength;
    }

    public void draw(FontRenderer fr, int mouseX, int mouseY) {
        int bg = focused ? 0xAA444444 : 0xAA222222;
        RenderUtils.drawRect(x, y, width, height, bg);
        RenderUtils.drawOutline(x, y, width, height, 1.0f, focused ? 0xFF00AAFF : 0xFF555555);
        String display = text.isEmpty() ? placeholder : text;
        int col = text.isEmpty() ? 0x888888 : 0xFFFFFF;
        fr.drawStringWithShadow(display + (focused && System.currentTimeMillis() % 1000 < 500 ? "|" : ""),
                x + 4, y + (height - 8) / 2f, col);
    }

    public boolean isHovered(int mouseX, int mouseY) {
        return mouseX >= x && mouseX <= x + width && mouseY >= y && mouseY <= y + height;
    }

    public void onClick(int mouseX, int mouseY) {
        focused = isHovered(mouseX, mouseY);
    }

    public void onKeyTyped(char c, int keyCode) {
        if (!focused) return;
        if (keyCode == 14) { // Backspace
            if (!text.isEmpty()) text = text.substring(0, text.length() - 1);
        } else if (c >= 32 && text.length() < maxLength) {
            text += c;
        }
    }

    public String getText() { return text; }
    public void setText(String text) { this.text = text; }
    public boolean isFocused() { return focused; }
    public void setFocused(boolean focused) { this.focused = focused; }
}
