package com.maple.client.mods.display;

import com.maple.client.mods.Mod;
import com.maple.client.util.RenderUtils;

public class ComboCounterMod extends Mod {
    private int comboCount = 0;
    private long lastHitTime = 0;
    
    public ComboCounterMod() {
        super("combocounter", "Combo Counter", "💥", "Display");
        this.x = 10;
        this.y = 130;
        this.color = 0xFF0000;
    }
    
    @Override
    public void onRender() {
        String text = "Combo: " + comboCount;
        RenderUtils.drawText(getMinecraft(), text, (int) x, (int) y, color);
    }
    
    @Override
    public void onUpdate() {
        if (getMinecraft().player != null && getMinecraft().player.hurtTime > 0) {
            comboCount = 0;
            lastHitTime = System.currentTimeMillis();
        }
    }
    
    @Override
    public void onKeyPress(int keyCode) {
    }
    
    public void incrementCombo() {
        comboCount++;
        lastHitTime = System.currentTimeMillis();
    }
}