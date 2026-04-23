package com.advanced.client.mods.gameplay;

import com.advanced.client.mods.Mod;

public class FullBrightMod extends Mod {

    public FullBrightMod() {
        super("fullbright", "Full Bright", "☀️");
        setSetting("brightness", 1.0f);
    }

    @Override
    public void onRender() {
    }

    @Override
    public void onUpdate() {
        if (getMinecraft().player != null) {
            float brightnessLevel = ((Number) getSetting("brightness")).floatValue();
            getMinecraft().options.gamma().set((double) brightnessLevel);
        }
    }

    @Override
    public void onKeyPress(int keyCode) {
    }
}
