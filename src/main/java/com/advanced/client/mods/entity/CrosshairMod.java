package com.advanced.client.mods.entity;

import com.advanced.client.mods.Mod;

public class CrosshairMod extends Mod {

    public CrosshairMod() {
        super("crosshair", "Crosshair", "✕");
        setSetting("style", "cross");
    }

    @Override
    public void onRender() {
    }

    @Override
    public void onUpdate() {
    }

    @Override
    public void onKeyPress(int keyCode) {
    }
}
