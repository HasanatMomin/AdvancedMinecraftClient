package com.advanced.client.settings;

import com.advanced.client.AdvancedClient;
import com.advanced.client.mods.Mod;
import com.advanced.client.util.JsonConfig;
import com.advanced.client.util.Logger;
import com.google.gson.JsonObject;

import java.io.File;

public class Config {

    private static final String CONFIG_PATH = "./config/advancedclient/settings.json";
    private JsonConfig jsonConfig;

    public Config() {
        jsonConfig = new JsonConfig(new File(CONFIG_PATH));
    }

    public void load() {
        jsonConfig.load();
        loadMods();
        loadSettings();
        Logger.info("Config loaded.");
    }

    public void save() {
        saveMods();
        saveSettings();
        jsonConfig.save();
        Logger.info("Config saved.");
    }

    private void loadMods() {
        if (!jsonConfig.has("mods")) return;
        JsonObject modsObj = jsonConfig.get("mods").getAsJsonObject();
        if (AdvancedClient.instance == null || AdvancedClient.instance.getModManager() == null) return;
        for (Mod mod : AdvancedClient.instance.getModManager().getMods()) {
            if (!modsObj.has(mod.getId())) continue;
            JsonObject modObj = modsObj.get(mod.getId()).getAsJsonObject();
            if (modObj.has("enabled")) mod.setEnabled(modObj.get("enabled").getAsBoolean());
            if (modObj.has("x")) mod.setX(modObj.get("x").getAsFloat());
            if (modObj.has("y")) mod.setY(modObj.get("y").getAsFloat());
            if (modObj.has("scale")) mod.setScale(modObj.get("scale").getAsFloat());
            if (modObj.has("opacity")) mod.setOpacity(modObj.get("opacity").getAsFloat());
        }
    }

    private void saveMods() {
        if (AdvancedClient.instance == null || AdvancedClient.instance.getModManager() == null) return;
        JsonObject modsObj = new JsonObject();
        for (Mod mod : AdvancedClient.instance.getModManager().getMods()) {
            JsonObject modObj = new JsonObject();
            modObj.addProperty("enabled", mod.isEnabled());
            modObj.addProperty("x", mod.getX());
            modObj.addProperty("y", mod.getY());
            modObj.addProperty("scale", mod.getScale());
            modObj.addProperty("opacity", mod.getOpacity());
            modsObj.add(mod.getId(), modObj);
        }
        jsonConfig.set("mods", modsObj);
    }

    private void loadSettings() {
        if (!jsonConfig.has("settings")) return;
        ClientSettings cs = AdvancedClient.instance != null ? AdvancedClient.instance.getClientSettings() : null;
        if (cs == null) return;
        JsonObject s = jsonConfig.get("settings").getAsJsonObject();
        if (s.has("rawMouseInput")) cs.setRawMouseInput(s.get("rawMouseInput").getAsBoolean());
        if (s.has("borderlessFullscreen")) cs.setBorderlessFullscreen(s.get("borderlessFullscreen").getAsBoolean());
        if (s.has("disableHotbarScroll")) cs.setDisableHotbarScroll(s.get("disableHotbarScroll").getAsBoolean());
        if (s.has("capeEnabled")) cs.setCapeEnabled(s.get("capeEnabled").getAsBoolean());
        if (s.has("performanceLevel")) cs.setPerformanceLevel(s.get("performanceLevel").getAsInt());
    }

    private void saveSettings() {
        ClientSettings cs = AdvancedClient.instance != null ? AdvancedClient.instance.getClientSettings() : null;
        if (cs == null) return;
        JsonObject s = new JsonObject();
        s.addProperty("rawMouseInput", cs.isRawMouseInput());
        s.addProperty("borderlessFullscreen", cs.isBorderlessFullscreen());
        s.addProperty("disableHotbarScroll", cs.isDisableHotbarScroll());
        s.addProperty("capeEnabled", cs.isCapeEnabled());
        s.addProperty("performanceLevel", cs.getPerformanceLevel());
        jsonConfig.set("settings", s);
    }
}
