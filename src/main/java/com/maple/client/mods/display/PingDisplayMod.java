package com.maple.client.mods.display;

import com.maple.client.mods.Mod;
import com.maple.client.util.RenderUtils;

public class PingDisplayMod extends Mod {
    
    public PingDisplayMod() {
        super("pingdisplay", "Ping Display", "📡", "Display");
        this.x = 10;
        this.y = 25;
        this.color = 0x00FF00;
    }
    
    @Override
    public void onRender() {
        if (getMinecraft().player != null && getMinecraft().getConnection() != null) {
            int ping = getMinecraft().getConnection().getLatency();
            String text = "Ping: " + ping + "ms";
            
            int displayColor = 0x00FF00;
            if (ping > 150) {
                displayColor = 0xFF0000;
            } else if (ping > 100) {
                displayColor = 0xFFFF00;
            } else if (ping > 50) {
                displayColor = 0xFF8800;
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