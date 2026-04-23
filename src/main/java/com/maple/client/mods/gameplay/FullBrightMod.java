package com.maple.client.mods.gameplay;

import com.maple.client.mods.Mod;

public class FullBrightMod extends Mod {
    private float brightnessLevel = 1.0f;
    
    public FullBrightMod() {
        super("fullbright", "Full Bright", "☀️");
        setSetting("brightness", 1.0f);
    }
    
    @Override
    public void onRender() {
        if (getMinecraft().player != null) {
            brightnessLevel = (float) getSetting("brightness");
            getMinecraft().options.gamma().set(brightnessLevel);
        }
    }
    
    @Override
    public void onUpdate() {}
    
    @Override
    public void onKeyPress(int keyCode) {}
}