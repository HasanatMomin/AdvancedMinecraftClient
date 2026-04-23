package com.maple.client.settings;

import com.google.gson.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ClientSettings {
    private static final String CONFIG_DIR = "./config/mapleclient/";
    private static final String CONFIG_FILE = CONFIG_DIR + "settings.json";
    
    private JsonObject settings;
    
    public ClientSettings() {
        loadSettings();
    }
    
    public void loadSettings() {
        try {
            Files.createDirectories(Paths.get(CONFIG_DIR));
            if (new File(CONFIG_FILE).exists()) {
                String content = new String(Files.readAllBytes(Paths.get(CONFIG_FILE)));
                settings = JsonParser.parseString(content).getAsJsonObject();
            } else {
                settings = new JsonObject();
                initDefaultSettings();
                saveSettings();
            }
        } catch (IOException e) {
            settings = new JsonObject();
            initDefaultSettings();
        }
    }
    
    private void initDefaultSettings() {
        settings.addProperty("rawMouseInput", true);
        settings.addProperty("borderlessFullscreen", false);
        settings.addProperty("disableHotbarScroll", false);
        settings.addProperty("capeEnabled", true);
        settings.addProperty("performanceLevel", 5);
        settings.addProperty("vsyncEnabled", false);
        settings.addProperty("particleDensity", 100);
    }
    
    public void saveSettings() {
        try {
            Files.createDirectories(Paths.get(CONFIG_DIR));
            Files.write(Paths.get(CONFIG_FILE), settings.toString().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public boolean getBoolean(String key, boolean defaultValue) {
        if (settings.has(key)) {
            return settings.get(key).getAsBoolean();
        }
        return defaultValue;
    }
    
    public int getInt(String key, int defaultValue) {
        if (settings.has(key)) {
            return settings.get(key).getAsInt();
        }
        return defaultValue;
    }
    
    public void setBoolean(String key, boolean value) {
        settings.addProperty(key, value);
        saveSettings();
    }
    
    public void setInt(String key, int value) {
        settings.addProperty(key, value);
        saveSettings();
    }
}