package com.maple.client.mods.gameplay;

import com.maple.client.mods.Mod;
import org.lwjgl.input.Keyboard;

public class ToggleSneakSprintMod extends Mod {
    private boolean isSneaking = false;
    private boolean isSprinting = false;
    private long lastSprintToggle = 0;
    private long lastSneakToggle = 0;
    
    public ToggleSneakSprintMod() {
        super("togglesneaksprint", "Toggle Sneak/Sprint", "🏃", "Gameplay");
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
        if (keyCode == Keyboard.KEY_R) {
            long now = System.currentTimeMillis();
            if (now - lastSprintToggle > 200) {
                isSprinting = !isSprinting;
                lastSprintToggle = now;
            }
        }
        if (keyCode == Keyboard.KEY_LCONTROL) {
            long now = System.currentTimeMillis();
            if (now - lastSneakToggle > 200) {
                isSneaking = !isSneaking;
                lastSneakToggle = now;
            }
        }
    }
}