package com.maple.client.mods.gameplay;

import com.maple.client.mods.Mod;

public class HurtCamDisableMod extends Mod {
    
    public HurtCamDisableMod() {
        super("hurtcamdisable", "Hurt Cam Disable", "🛡️", "Gameplay");
    }
    
    @Override
    public void onRender() {
    }
    
    @Override
    public void onUpdate() {
        if (getMinecraft().player != null) {
            getMinecraft().player.hurtTime = 0;
        }
    }
    
    @Override
    public void onKeyPress(int keyCode) {
    }
}