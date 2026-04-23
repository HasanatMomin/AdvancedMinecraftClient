package com.maple.client.mods.display;

import com.maple.client.mods.Mod;
import com.maple.client.util.RenderUtils;

public class FpsDisplayMod extends Mod {
    
    public FpsDisplayMod() {
        super("fpsdisplay", "FPS Display", "⚡", "Display");
        this.x = 10;
        this.y = 10;
        this.color = 0x00FF00;
    }
    
    @Override
    public void onRender() {
        if (getMinecraft().level != null) {
            int fps = getMinecraft().fps;
            String text = "FPS: " + fps;
            
            int displayColor = 0x00FF00; // Green
            if (fps < 60) {
                displayColor = 0xFF0000; // Red
            } else if (fps < 120) {
                displayColor = 0xFFFF00; // Yellow
            }
            
            RenderUtils.drawText(getMinecraft(), text, (int) x, (int) y, displayColor);
        }
    }
    
    @Override
    public void onUpdate() {
    }
    
    @Override
    public void onKeyPress(int keyCode) {
    }
}