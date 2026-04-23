package com.advanced.client.mods.gameplay;

import com.advanced.client.mods.Mod;
import org.lwjgl.glfw.GLFW;

public class ToggleSneakSprintMod extends Mod {

    private boolean isSneaking = false;
    private boolean isSprinting = false;
    private long lastSprintToggle = 0;
    private long lastSneakToggle = 0;

    public ToggleSneakSprintMod() {
        super("togglesneaksprint", "Toggle Sneak/Sprint", "🏃");
    }

    @Override
    public void onRender() {
    }

    @Override
    public void onUpdate() {
        if (getMinecraft().player != null) {
            if (isSprinting) {
                getMinecraft().player.setSprinting(true);
            }
            if (isSneaking) {
                getMinecraft().player.setShiftKeyDown(true);
            }
        }
    }

    @Override
    public void onKeyPress(int keyCode) {
        long now = System.currentTimeMillis();
        if (keyCode == GLFW.GLFW_KEY_R) {
            if (now - lastSprintToggle > 200) {
                isSprinting = !isSprinting;
                lastSprintToggle = now;
            }
        }
        if (keyCode == GLFW.GLFW_KEY_LEFT_CONTROL) {
            if (now - lastSneakToggle > 200) {
                isSneaking = !isSneaking;
                lastSneakToggle = now;
            }
        }
    }
}
