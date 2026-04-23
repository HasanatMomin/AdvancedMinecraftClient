package com.advanced.client.settings;

import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import org.lwjgl.input.Keyboard;

public class KeybindManager {

    private static final String CATEGORY = "Advanced Client";

    private KeyBinding openSettingsKey;
    private KeyBinding zoomKey;

    private int openSettingsKeyCode = Keyboard.KEY_RSHIFT;
    private int zoomKeyCode = Keyboard.KEY_Z;

    public void registerKeybinds() {
        openSettingsKey = new KeyBinding("key.advancedclient.settings", openSettingsKeyCode, CATEGORY);
        zoomKey = new KeyBinding("key.advancedclient.zoom", zoomKeyCode, CATEGORY);
        ClientRegistry.registerKeyBinding(openSettingsKey);
        ClientRegistry.registerKeyBinding(zoomKey);
    }

    public int getOpenSettingsKey() {
        return openSettingsKey != null ? openSettingsKey.getKeyCode() : openSettingsKeyCode;
    }

    public int getZoomKey() {
        return zoomKey != null ? zoomKey.getKeyCode() : zoomKeyCode;
    }

    public KeyBinding getOpenSettingsBinding() { return openSettingsKey; }
    public KeyBinding getZoomBinding() { return zoomKey; }
}
