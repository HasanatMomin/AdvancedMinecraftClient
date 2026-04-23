package com.maple.client.mods.display;

import com.maple.client.mods.Mod;
import com.maple.client.util.RenderUtils;

public class CpsDisplayMod extends Mod {
    private int leftCps = 0;
    private int rightCps = 0;
    private long lastLeftClick = 0;
    private long lastRightClick = 0;
    
    public CpsDisplayMod() {
        super("cpsdisplay", "CPS Display", "🖱️", "Display");
        this.x = 10;
        this.y = 40;
        this.color = 0xFFFFFF;
    }
    
    @Override
    public void onRender() {
        String text = "L: " + leftCps + " R: " + rightCps;
        RenderUtils.drawText(getMinecraft(), text, (int) x, (int) y, color);
    }
    
    @Override
    public void onUpdate() {
        long now = System.currentTimeMillis();
        if (now - lastLeftClick > 1000) leftCps = 0;
        if (now - lastRightClick > 1000) rightCps = 0;
    }
    
    @Override
    public void onKeyPress(int keyCode) {
    }
    
    public void recordLeftClick() {
        lastLeftClick = System.currentTimeMillis();
        leftCps++;
    }
    
    public void recordRightClick() {
        lastRightClick = System.currentTimeMillis();
        rightCps++;
    }
}