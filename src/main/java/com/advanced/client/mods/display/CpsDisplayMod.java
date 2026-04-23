package com.advanced.client.mods.display;

import com.advanced.client.mods.Mod;

public class CpsDisplayMod extends Mod {

    private int leftCps = 0;
    private int rightCps = 0;
    private long lastLeftClick = 0;
    private long lastRightClick = 0;

    public CpsDisplayMod() {
        super("cpsdisplay", "CPS Display", "🖱️");
    }

    @Override
    public void onRender() {
        String text = "L: " + leftCps + " R: " + rightCps;
        getMinecraft().font.drawShadow(
                new com.mojang.blaze3d.vertex.PoseStack(),
                text, x, y, color);
    }

    @Override
    public void onUpdate() {
        long now = System.currentTimeMillis();
        if (now - lastLeftClick > 1000) leftCps = 0;
        if (now - lastRightClick > 1000) rightCps = 0;
    }

    @Override
    public void onKeyPress(int keyCode) {
    }

    public void recordLeftClick() {
        lastLeftClick = System.currentTimeMillis();
        leftCps++;
    }

    public void recordRightClick() {
        lastRightClick = System.currentTimeMillis();
        rightCps++;
    }
}
