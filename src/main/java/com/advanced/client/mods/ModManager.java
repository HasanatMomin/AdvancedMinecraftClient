package com.advanced.client.mods;

import com.advanced.client.mods.display.*;
import com.advanced.client.mods.entity.*;
import com.advanced.client.mods.gameplay.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ModManager {

    private static ModManager instance;

    private final List<Mod> mods = new ArrayList<>();

    private ModManager() {
    }

    public static ModManager getInstance() {
        if (instance == null) {
            instance = new ModManager();
        }
        return instance;
    }

    public void registerAllMods() {
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

    public List<Mod> getAllMods() {
        return Collections.unmodifiableList(mods);
    }

    public void renderAllMods() {
        for (Mod mod : mods) {
            if (mod.isEnabled()) {
                mod.onRender();
            }
        }
    }

    public void updateAllMods() {
        for (Mod mod : mods) {
            if (mod.isEnabled()) {
                mod.onUpdate();
            }
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
}
