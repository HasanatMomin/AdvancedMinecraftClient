package com.maple.client.mods.display;

import com.maple.client.mods.Mod;
import com.maple.client.util.RenderUtils;

public class ReachDisplayMod extends Mod {
    private double lastReach = 0;
    
    public ReachDisplayMod() {
        super("reachdisplay", "Reach Display", "🎯");
        this.x = 5;
        this.y = 110;
    }
    
    @Override
    public void onRender() {
        String text = "Reach: " + String.format("%.2f", lastReach);
        int drawX = (int) x;
        int drawY = (int) y;
        RenderUtils.drawText(text, drawX, drawY, 0xFFFFFFFF);
    }
    
    @Override
    public void onUpdate() {}
    
    @Override
    public void onKeyPress(int keyCode) {}
    
    public void setReach(double reach) {
        this.lastReach = reach;
    }
}