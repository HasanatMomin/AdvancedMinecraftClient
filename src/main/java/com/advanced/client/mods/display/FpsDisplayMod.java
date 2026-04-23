package com.advanced.client.mods.display;

import com.advanced.client.mods.Mod;
import net.minecraft.client.Minecraft;

public class FpsDisplayMod extends Mod {

    public FpsDisplayMod() {
        super("fpsdisplay", "FPS Display", "⚡");
        this.x = 2;
        this.y = 2;
    }

    @Override
    public void onRender() {
        int fps = Minecraft.getDebugFPS();
        String text = "FPS: " + fps;
        getMinecraft().fontRenderer.drawStringWithShadow(text, x, y, color);
    }

    @Override
    public void onUpdate() {
    }

    @Override
    public void onKeyPress(int keyCode) {
    }
}
