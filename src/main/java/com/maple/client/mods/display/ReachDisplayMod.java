package com.maple.client.mods.display;

import com.maple.client.mods.Mod;
import com.maple.client.util.RenderUtils;

public class ReachDisplayMod extends Mod {
    private double lastReach = 0;
    
    public ReachDisplayMod() {
        super("reachdisplay", "Reach Display", "🎯", "Display");
        this.x = 10;
        this.y = 115;
        this.color = 0xFFFFFF;
    }
    
    @Override
    public void onRender() {
        String text = "Reach: " + String.format("%.2f", lastReach);
        RenderUtils.drawText(getMinecraft(), text, (int) x, (int) y, color);
    }
    
    @Override
    public void onUpdate() {
    }
    
    @Override
    public void onKeyPress(int keyCode) {
    }
    
    public void setReach(double reach) {
        this.lastReach = reach;
    }
}