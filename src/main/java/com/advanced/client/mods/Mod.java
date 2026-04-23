package com.advanced.client.mods;

import net.minecraft.client.Minecraft;

import java.util.HashMap;
import java.util.Map;

public abstract class Mod {

    protected final String id;
    protected final String name;
    protected final String icon;

    protected float x = 5;
    protected float y = 5;
    protected int color = 0xFFFFFFFF;
    protected boolean enabled = true;

    private final Map<String, Object> settings = new HashMap<>();

    public Mod(String id, String name, String icon) {
        this.id = id;
        this.name = name;
        this.icon = icon;
    }

    public abstract void onRender();

    public abstract void onUpdate();

    public abstract void onKeyPress(int keyCode);

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getIcon() {
        return icon;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public void setSetting(String key, Object value) {
        settings.put(key, value);
    }

    public Object getSetting(String key) {
        return settings.get(key);
    }

    public Minecraft getMinecraft() {
        return Minecraft.getInstance();
    }
}
