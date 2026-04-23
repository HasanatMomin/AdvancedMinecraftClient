package com.maple.client.mods.display;

import com.maple.client.mods.Mod;
import com.maple.client.util.RenderUtils;

public class FpsDisplayMod extends Mod {
    
    public FpsDisplayMod() {
        super("fpsdisplay", "FPS Display", "⚡");
        this.x = 5;
        this.y = 5;
    }
    
    @Override
    public void onRender() {
        if (getMinecraft().level != null) {
            int fps = getMinecraft().fps;
            String text = "FPS: " + fps;
            int drawX = (int) x;
            int drawY = (int) y;
            int displayColor = fps > 120 ? 0xFF00FF00 : fps > 60 ? 0xFFFFFF00 : 0xFFFF0000;
            RenderUtils.drawText(text, drawX, drawY, displayColor);
        }
    }
    
    @Override
    public void onUpdate() {}
    
    @Override
    public void onKeyPress(int keyCode) {}
}