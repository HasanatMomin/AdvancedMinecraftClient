package com.advanced.client.mods.gameplay;

import com.advanced.client.mods.Mod;
import net.minecraft.client.Minecraft;

public class ToggleSneakSprintMod extends Mod {

    private boolean sneaking = false;
    private boolean sprinting = false;

    public ToggleSneakSprintMod() {
        super("togglesneaksprint", "Toggle Sneak/Sprint", "🏃");
    }

    @Override
    public void onRender() {
    }

    @Override
    public void onUpdate() {
        Minecraft mc = getMinecraft();
        if (mc.player == null) return;

        mc.player.setSneaking(sneaking);
        if (sprinting && mc.player.getFoodStats().getFoodLevel() > 6) {
            mc.player.setSprinting(true);
        }
    }

    @Override
    public void onKeyPress(int keyCode) {
        Minecraft mc = getMinecraft();
        if (mc.gameSettings == null) return;

        if (keyCode == mc.gameSettings.keyBindSneak.getKeyCode()) {
            sneaking = !sneaking;
        } else if (keyCode == mc.gameSettings.keyBindSprint.getKeyCode()) {
            sprinting = !sprinting;
        }
    }
}
