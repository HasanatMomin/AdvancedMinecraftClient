package com.maple.client.mods.display;

import com.maple.client.mods.Mod;
import com.maple.client.util.RenderUtils;

public class ComboCounterMod extends Mod {
    private int comboCount = 0;
    private long lastHitTime = 0;
    
    public ComboCounterMod() {
        super("combocounter", "Combo Counter", "💥");
        this.x = 5;
        this.y = 125;
    }
    
    @Override
    public void onRender() {
        String text = "Combo: " + comboCount;
        int drawX = (int) x;
        int drawY = (int) y;
        RenderUtils.drawText(text, drawX, drawY, 0xFFFF0000);
    }
    
    @Override
    public void onUpdate() {
        if (getMinecraft().player != null && getMinecraft().player.hurtTime > 0) {
            comboCount = 0;
            lastHitTime = System.currentTimeMillis();
        }
    }
    
    @Override
    public void onKeyPress(int keyCode) {}
    
    public void incrementCombo() {
        comboCount++;
        lastHitTime = System.currentTimeMillis();
    }
}