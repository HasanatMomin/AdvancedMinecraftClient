package com.advanced.client.mods.gameplay;

import com.advanced.client.mods.Mod;

public class HurtCamDisableMod extends Mod {

    public HurtCamDisableMod() {
        super("hurtcamdisable", "Hurt Cam Disable", "🛡️");
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
