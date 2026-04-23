package com.maple.client.mods.entity;

import com.maple.client.mods.Mod;

public class CrosshairMod extends Mod {
    private String crosshairStyle = "cross";
    
    public CrosshairMod() {
        super("crosshair", "Crosshair", "✕");
        setSetting("style", "cross");
    }
    
    @Override
    public void onRender() {}
    
    @Override
    public void onUpdate() {}
    
    @Override
    public void onKeyPress(int keyCode) {}
}