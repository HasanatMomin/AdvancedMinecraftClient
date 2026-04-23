package com.maple.client.mods;

import net.minecraft.client.Minecraft;
import java.util.HashMap;
import java.util.Map;

public abstract class Mod {
    protected String id;
    protected String name;
    protected String icon;
    protected boolean enabled = false;
    protected double x = 10;
    protected double y = 10;
    protected double scale = 1.0;
    protected int color = 0xFFFFFF;
    protected int backgroundColor = 0x000000;
    protected float opacity = 1.0f;
    protected String category = "Display";
    protected Map<String, Object> settings = new HashMap<>();
    
    public Mod(String id, String name, String icon, String category) {
        this.id = id;
        this.name = name;
        this.icon = icon;
        this.category = category;
    }
    
    public abstract void onRender();
    public abstract void onUpdate();
    public abstract void onKeyPress(int keyCode);
    
    public void toggle() {
        this.enabled = !this.enabled;
    }
    
    public void setPosition(double x, double y) {
        this.x = x;
        this.y = y;
    }
    
    public void setScale(double scale) {
        this.scale = Math.max(0.5, Math.min(2.0, scale));
    }
    
    public void setColor(int color) {
        this.color = color;
    }
    
    public void setOpacity(float opacity) {
        this.opacity = Math.max(0.0f, Math.min(1.0f, opacity));
    }
    
    public String getId() { return id; }
    public String getName() { return name; }
    public String getIcon() { return icon; }
    public String getCategory() { return category; }
    public boolean isEnabled() { return enabled; }
    public double getX() { return x; }
    public double getY() { return y; }
    public double getScale() { return scale; }
    public int getColor() { return color; }
    public int getBackgroundColor() { return backgroundColor; }
    public float getOpacity() { return opacity; }
    
    protected Minecraft getMinecraft() {
        return Minecraft.getInstance();
    }
    
    public void setSetting(String key, Object value) {
        settings.put(key, value);
    }
    
    public Object getSetting(String key) {
        return settings.getOrDefault(key, null);
    }
}