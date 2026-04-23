package com.advanced.client.gui.component;

import com.advanced.client.mods.Mod;
import com.advanced.client.render.RenderUtils;
import net.minecraft.client.gui.FontRenderer;

public class ModButton {

    private final Mod mod;
    private final int x, y, width, height;

    public ModButton(Mod mod, int x, int y, int width, int height) {
        this.mod = mod;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void draw(FontRenderer fr, int mouseX, int mouseY) {
        int bg = mod.isEnabled() ? 0xAA00AA00 : 0xAA880000;
        if (isHovered(mouseX, mouseY)) bg = mod.isEnabled() ? 0xAA00FF00 : 0xAAFF0000;
        RenderUtils.drawRect(x, y, width, height, bg);
        String label = mod.getIcon() + " " + mod.getName();
        fr.drawStringWithShadow(label, x + 4, y + (height - 8) / 2f, 0xFFFFFF);
    }

    public boolean isHovered(int mouseX, int mouseY) {
        return mouseX >= x && mouseX <= x + width && mouseY >= y && mouseY <= y + height;
    }

    public void onClick() {
        mod.toggle();
    }
}
