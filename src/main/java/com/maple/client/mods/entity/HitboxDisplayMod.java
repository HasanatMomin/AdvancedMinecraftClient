package com.maple.client.mods.entity;

import com.maple.client.mods.Mod;

public class HitboxDisplayMod extends Mod {
    
    public HitboxDisplayMod() {
        super("hitboxdisplay", "Hitbox Display", "⬛");
        setSetting("hitboxColor", 0xFF0000FF);
        setSetting("hitboxAlpha", 0.5f);
    }
    
    @Override
    public void onRender() {}
    
    @Override
    public void onUpdate() {}
    
    @Override
    public void onKeyPress(int keyCode) {}
}