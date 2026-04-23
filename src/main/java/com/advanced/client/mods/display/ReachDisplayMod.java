package com.advanced.client.mods.display;

import com.advanced.client.mods.Mod;

public class ReachDisplayMod extends Mod {

    private double lastReach = 0;

    public ReachDisplayMod() {
        super("reachdisplay", "Reach Display", "🎯");
    }

    @Override
    public void onRender() {
        String text = "Reach: " + String.format("%.2f", lastReach);
        getMinecraft().font.drawShadow(
                new com.mojang.blaze3d.vertex.PoseStack(),
                text, x, y, color);
    }

    @Override
    public void onUpdate() {
    }

    @Override
    public void onKeyPress(int keyCode) {
    }

    public void setReach(double reach) {
        this.lastReach = reach;
    }
}
