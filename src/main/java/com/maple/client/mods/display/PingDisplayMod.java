package com.maple.client.mods.display;

import com.maple.client.mods.Mod;
import com.maple.client.util.RenderUtils;

public class PingDisplayMod extends Mod {
    
    public PingDisplayMod() {
        super("pingdisplay", "Ping Display", "📡");
        this.x = 5;
        this.y = 20;
    }
    
    @Override
    public void onRender() {
        if (getMinecraft().player != null && getMinecraft().getConnection() != null) {
            int ping = getMinecraft().getConnection().getLatency();
            String text = "Ping: " + ping + "ms";
            int drawX = (int) x;
            int drawY = (int) y;
            int displayColor = ping < 50 ? 0xFF00FF00 : ping < 100 ? 0xFFFFFF00 : ping < 150 ? 0xFFFF8800 : 0xFFFF0000;
            RenderUtils.drawText(text, drawX, drawY, displayColor);
        }
    }
    
    @Override
    public void onUpdate() {}
    
    @Override
    public void onKeyPress(int keyCode) {}
}