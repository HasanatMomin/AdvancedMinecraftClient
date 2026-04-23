package com.advanced.client.mods;

import com.advanced.client.mods.display.*;
import com.advanced.client.mods.gameplay.*;
import com.advanced.client.mods.entity.*;

import java.util.ArrayList;
import java.util.List;

public class ModManager {

    private final List<Mod> mods = new ArrayList<>();

    public void initMods() {
        // Display mods
        register(new FpsDisplayMod());
        register(new PingDisplayMod());
        register(new CpsDisplayMod());
        register(new KeystrokesDisplayMod());
        register(new CoordinatesDisplayMod());
        register(new PotionEffectsHudMod());
        register(new ArmorStatusHudMod());
        register(new ReachDisplayMod());
        register(new ComboCounterMod());

        // Gameplay mods
        register(new ToggleSneakSprintMod());
        register(new ZoomMod());
        register(new FullBrightMod());
        register(new HurtCamDisableMod());

        // Entity mods
        register(new NametagsMod());
        register(new CrosshairMod());
        register(new BlockOutlineMod());
        register(new HitboxDisplayMod());
    }

    private void register(Mod mod) {
        mods.add(mod);
    }

    public void onRender() {
        for (Mod mod : mods) {
            if (mod.isEnabled()) {
                mod.onRender();
            }
        }
    }

    public void onUpdate() {
        for (Mod mod : mods) {
            if (mod.isEnabled()) {
                mod.onUpdate();
            }
        }
    }

    public void onKeyPress(int keyCode) {
        for (Mod mod : mods) {
            mod.onKeyPress(keyCode);
        }
    }

    public Mod getModById(String id) {
        for (Mod mod : mods) {
            if (mod.getId().equals(id)) {
                return mod;
            }
        }
        return null;
    }

    public List<Mod> getMods() {
        return mods;
    }
}
