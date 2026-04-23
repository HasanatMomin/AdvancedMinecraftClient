package com.advanced.client.mods.gameplay;

import com.advanced.client.mods.Mod;
import net.minecraft.client.Minecraft;
import org.lwjgl.input.Keyboard;

public class ZoomMod extends Mod {

    private boolean zooming = false;
    private float originalFov = 70.0f;
    private static final int ZOOM_KEY = Keyboard.KEY_Z;
    private static final float ZOOM_FOV = 10.0f;

    public ZoomMod() {
        super("zoom", "Zoom", "🔍");
    }

    @Override
    public void onRender() {
    }

    @Override
    public void onUpdate() {
        Minecraft mc = getMinecraft();
        boolean keyDown = Keyboard.isKeyDown(ZOOM_KEY);

        if (keyDown && !zooming) {
            zooming = true;
            originalFov = mc.gameSettings.fovSetting;
            mc.gameSettings.fovSetting = ZOOM_FOV;
        } else if (!keyDown && zooming) {
            zooming = false;
            mc.gameSettings.fovSetting = originalFov;
        }
    }

    @Override
    public void onKeyPress(int keyCode) {
    }
}
