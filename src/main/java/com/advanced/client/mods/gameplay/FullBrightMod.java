package com.advanced.client.mods.gameplay;

import com.advanced.client.mods.Mod;
import net.minecraft.client.Minecraft;

public class FullBrightMod extends Mod {

    private float originalGamma = 1.0f;
    private boolean wasEnabled = false;

    public FullBrightMod() {
        super("fullbright", "Full Bright", "☀️");
    }

    @Override
    public void onRender() {
    }

    @Override
    public void onUpdate() {
        Minecraft mc = getMinecraft();
        if (enabled && !wasEnabled) {
            originalGamma = mc.gameSettings.gammaSetting;
            mc.gameSettings.gammaSetting = 100.0f;
            wasEnabled = true;
        } else if (!enabled && wasEnabled) {
            mc.gameSettings.gammaSetting = originalGamma;
            wasEnabled = false;
        }
    }

    @Override
    public void onKeyPress(int keyCode) {
    }

    @Override
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
