package com.advanced.client.mods.display;

import com.advanced.client.mods.Mod;
import net.minecraft.client.Minecraft;

public class FpsDisplayMod extends Mod {

    public FpsDisplayMod() {
        super("fpsdisplay", "FPS Display", "⚡");
    }

    @Override
    public void onRender() {
        if (getMinecraft().level != null) {
            int fps = Minecraft.getInstance().getFps();
            String text = "FPS: " + fps;
            getMinecraft().font.drawShadow(
                    new com.mojang.blaze3d.vertex.PoseStack(),
                    text, x, y, color);
        }
    }

    @Override
    public void onUpdate() {
    }

    @Override
    public void onKeyPress(int keyCode) {
    }
}
