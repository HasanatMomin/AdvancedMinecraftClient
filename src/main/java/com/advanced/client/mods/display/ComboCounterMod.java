package com.advanced.client.mods.display;

import com.advanced.client.mods.Mod;

public class ComboCounterMod extends Mod {

    private int comboCount = 0;
    private long lastHitTime = 0;

    public ComboCounterMod() {
        super("combocounter", "Combo Counter", "💥");
    }

    @Override
    public void onRender() {
        String text = "Combo: " + comboCount;
        getMinecraft().font.drawShadow(
                new com.mojang.blaze3d.vertex.PoseStack(),
                text, x, y, 0xFFFF0000);
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
