package com.maple.client.mods.display;

import com.maple.client.mods.Mod;
import com.maple.client.util.RenderUtils;

public class CpsDisplayMod extends Mod {
    private int leftCps = 0;
    private int rightCps = 0;
    private long lastLeftClick = 0;
    private long lastRightClick = 0;
    
    public CpsDisplayMod() {
        super("cpsdisplay", "CPS Display", "🖱️");
        this.x = 5;
        this.y = 35;
    }
    
    @Override
    public void onRender() {
        String text = "CPS: L" + leftCps + " R" + rightCps;
        int drawX = (int) x;
        int drawY = (int) y;
        RenderUtils.drawText(text, drawX, drawY, 0xFFFFFFFF);
    }
    
    @Override
    public void onUpdate() {
        long now = System.currentTimeMillis();
        if (now - lastLeftClick > 1000) leftCps = 0;
        if (now - lastRightClick > 1000) rightCps = 0;
    }
    
    @Override
    public void onKeyPress(int keyCode) {}
    
    public void recordLeftClick() {
        lastLeftClick = System.currentTimeMillis();
        leftCps++;
    }
    
    public void recordRightClick() {
        lastRightClick = System.currentTimeMillis();
        rightCps++;
    }
}