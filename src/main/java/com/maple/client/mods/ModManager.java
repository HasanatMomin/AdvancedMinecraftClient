package com.maple.client.mods;

import java.util.*;
import com.maple.client.mods.display.*;
import com.maple.client.mods.gameplay.*;
import com.maple.client.mods.entity.*;

public class ModManager {
    private static final ModManager INSTANCE = new ModManager();
    private Map<String, Mod> mods = new HashMap<>();
    private List<Mod> modList = new ArrayList<>();
    
    public static ModManager getInstance() {
        return INSTANCE;
    }
    
    public void registerAllMods() {
        // Display Mods
        registerMod(new FpsDisplayMod());
        registerMod(new PingDisplayMod());
        registerMod(new CpsDisplayMod());
        registerMod(new KeystrokesDisplayMod());
        registerMod(new CoordinatesDisplayMod());
        registerMod(new PotionEffectsHudMod());
        registerMod(new ArmorStatusHudMod());
        registerMod(new ReachDisplayMod());
        registerMod(new ComboCounterMod());
        
        // Gameplay Mods
        registerMod(new ToggleSneakSprintMod());
        registerMod(new ZoomMod());
        registerMod(new FullBrightMod());
        registerMod(new HurtCamDisableMod());
        
        // Entity Mods
        registerMod(new NametagsMod());
        registerMod(new CrosshairMod());
        registerMod(new BlockOutlineMod());
        registerMod(new HitboxDisplayMod());
    }
    
    public void registerMod(Mod mod) {
        mods.put(mod.getId(), mod);
        modList.add(mod);
    }
    
    public Mod getMod(String id) {
        return mods.get(id);
    }
    
    public List<Mod> getAllMods() {
        return new ArrayList<>(modList);
    }
    
    public void toggleMod(String id) {
        Mod mod = mods.get(id);
        if (mod != null) {
            mod.toggle();
        }
    }
    
    public void updateAllMods() {
        for (Mod mod : modList) {
            if (mod.isEnabled()) {
                mod.onUpdate();
            }
        }
    }
    
    public void renderAllMods() {
        for (Mod mod : modList) {
            if (mod.isEnabled()) {
                mod.onRender();
            }
        }
    }
    
    public void keyPressAllMods(int keyCode) {
        for (Mod mod : modList) {
            if (mod.isEnabled()) {
                mod.onKeyPress(keyCode);
            }
        }
    }
    
    public int getEnabledModCount() {
        return (int) modList.stream().filter(Mod::isEnabled).count();
    }
    
    public List<Mod> getModsByCategory(String category) {
        List<Mod> result = new ArrayList<>();
        for (Mod mod : modList) {
            if (mod.getCategory().equals(category)) {
                result.add(mod);
            }
        }
        return result;
    }
}