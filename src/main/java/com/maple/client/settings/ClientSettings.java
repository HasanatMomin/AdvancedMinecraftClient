package com.maple.client.settings;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ClientSettings {
    private static final String CONFIG_DIR = "./config/mapleclient/";
    private static final String CONFIG_FILE = CONFIG_DIR + "settings.json";
    
    private boolean rawMouseInput = true;
    private boolean borderlessFullscreen = false;
    private boolean disableHotbarScroll = false;
    private boolean capeEnabled = true;
    private int performanceLevel = 5;
    
    public ClientSettings() {
        loadSettings();
    }
    
    public void loadSettings() {
        try {
            Files.createDirectories(Paths.get(CONFIG_DIR));
            if (new File(CONFIG_FILE).exists()) {
                // Load from JSON
            } else {
                saveSettings();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void saveSettings() {
        try {
            Files.createDirectories(Paths.get(CONFIG_DIR));
            // Save to JSON
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public boolean isRawMouseInput() { return rawMouseInput; }
    public boolean isBorderlessFullscreen() { return borderlessFullscreen; }
    public boolean isDisableHotbarScroll() { return disableHotbarScroll; }
    public boolean isCapeEnabled() { return capeEnabled; }
    public int getPerformanceLevel() { return performanceLevel; }
}