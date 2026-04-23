package com.maple.client.mods.gameplay;

import com.maple.client.mods.Mod;
import org.lwjgl.input.Keyboard;

public class ZoomMod extends Mod {
    private boolean isZoomed = false;
    private float zoomLevel = 3.0f;
    private float originalFov = 70.0f;
    
    public ZoomMod() {
        super("zoom", "Zoom", "🔍");
    }
    
    @Override
    public void onRender() {
        if (isZoomed && getMinecraft().player != null) {
            getMinecraft().options.fov().set(70 / (int) zoomLevel);
        } else {
            getMinecraft().options.fov().set(70);
        }
    }
    
    @Override
    public void onUpdate() {}
    
    @Override
    public void onKeyPress(int keyCode) {
        if (keyCode == Keyboard.KEY_Z) {
            isZoomed = !isZoomed;
        }
    }
}