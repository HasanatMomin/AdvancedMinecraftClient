package com.advanced.client.gui.component;

import com.advanced.client.mods.Mod;
import com.advanced.client.render.RenderUtils;
import net.minecraft.client.gui.FontRenderer;

public class HudElement {

    private final Mod mod;
    private final int width = 80, height = 16;

    public HudElement(Mod mod) {
        this.mod = mod;
    }

    public void draw(FontRenderer fr, int mouseX, int mouseY) {
        float x = mod.getX(), y = mod.getY();
        int bgColor = isHovered(mouseX, mouseY) ? 0xAA555555 : 0x88000000;
        RenderUtils.drawRect(x - 1, y - 1, width + 2, height + 2, bgColor);
        fr.drawStringWithShadow(mod.getIcon() + " " + mod.getName(), x + 2, y + 4, 0xFFFFFF);
    }

    public boolean isHovered(int mouseX, int mouseY) {
        return mouseX >= mod.getX() && mouseX <= mod.getX() + width
                && mouseY >= mod.getY() && mouseY <= mod.getY() + height;
    }

    public Mod getMod() { return mod; }
}
