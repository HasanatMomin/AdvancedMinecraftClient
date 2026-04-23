package com.advanced.client.util;

import com.google.gson.*;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class JsonConfig {

    private final File file;
    private JsonObject root;
    private final Gson gson;

    public JsonConfig(File file) {
        this.file = file;
        this.gson = new GsonBuilder().setPrettyPrinting().create();
        this.root = new JsonObject();
    }

    public void load() {
        if (!file.exists()) {
            root = new JsonObject();
            return;
        }
        try (Reader reader = new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8)) {
            JsonElement element = new JsonParser().parse(reader);
            root = element.isJsonObject() ? element.getAsJsonObject() : new JsonObject();
        } catch (Exception e) {
            Logger.error("Failed to load config: " + file.getPath());
            root = new JsonObject();
        }
    }

    public void save() {
        file.getParentFile().mkdirs();
        try (Writer writer = new OutputStreamWriter(new FileOutputStream(file), StandardCharsets.UTF_8)) {
            gson.toJson(root, writer);
        } catch (Exception e) {
            Logger.error("Failed to save config: " + file.getPath());
        }
    }

    public JsonObject getRoot() { return root; }

    public void set(String key, JsonElement value) { root.add(key, value); }
    public JsonElement get(String key) { return root.get(key); }
    public boolean has(String key) { return root.has(key); }

    public void setString(String key, String value) { root.addProperty(key, value); }
    public void setBoolean(String key, boolean value) { root.addProperty(key, value); }
    public void setInt(String key, int value) { root.addProperty(key, value); }
    public void setFloat(String key, float value) { root.addProperty(key, value); }

    public String getString(String key, String def) {
        return has(key) ? get(key).getAsString() : def;
    }
    public boolean getBoolean(String key, boolean def) {
        return has(key) ? get(key).getAsBoolean() : def;
    }
    public int getInt(String key, int def) {
        return has(key) ? get(key).getAsInt() : def;
    }
    public float getFloat(String key, float def) {
        return has(key) ? get(key).getAsFloat() : def;
    }
}
