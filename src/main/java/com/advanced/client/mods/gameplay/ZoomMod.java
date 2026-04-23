package com.advanced.client.mods.gameplay;

import com.advanced.client.mods.Mod;
import org.lwjgl.glfw.GLFW;

public class ZoomMod extends Mod {

    private boolean isZoomed = false;
    private float zoomLevel = 3.0f;

    public ZoomMod() {
        super("zoom", "Zoom", "🔍");
    }

    @Override
    public void onRender() {
        if (getMinecraft().player != null) {
            if (isZoomed) {
                getMinecraft().options.fov().set((int) (70 / zoomLevel));
            } else {
                getMinecraft().options.fov().set(70);
            }
        }
    }

    @Override
    public void onUpdate() {
    }

    @Override
    public void onKeyPress(int keyCode) {
        if (keyCode == GLFW.GLFW_KEY_Z) {
            isZoomed = !isZoomed;
        }
    }
}
