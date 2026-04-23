package com.advanced.client.mods;

import net.minecraft.client.Minecraft;

public abstract class Mod {

    protected String id;
    protected String name;
    protected String icon;
    protected boolean enabled;
    protected float x;
    protected float y;
    protected float scale;
    protected int color;
    protected int backgroundColor;
    protected float opacity;

    public Mod(String id, String name, String icon) {
        this.id = id;
        this.name = name;
        this.icon = icon;
        this.enabled = false;
        this.x = 10;
        this.y = 10;
        this.scale = 1.0f;
        this.color = 0xFFFFFF;
        this.backgroundColor = 0x000000;
        this.opacity = 1.0f;
    }

    public abstract void onRender();
    public abstract void onUpdate();
    public abstract void onKeyPress(int keyCode);

    protected Minecraft getMinecraft() {
        return Minecraft.getMinecraft();
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public String getIcon() { return icon; }
    public boolean isEnabled() { return enabled; }
    public void setEnabled(boolean enabled) { this.enabled = enabled; }
    public float getX() { return x; }
    public void setX(float x) { this.x = x; }
    public float getY() { return y; }
    public void setY(float y) { this.y = y; }
    public float getScale() { return scale; }
    public void setScale(float scale) { this.scale = scale; }
    public int getColor() { return color; }
    public void setColor(int color) { this.color = color; }
    public int getBackgroundColor() { return backgroundColor; }
    public void setBackgroundColor(int backgroundColor) { this.backgroundColor = backgroundColor; }
    public float getOpacity() { return opacity; }
    public void setOpacity(float opacity) { this.opacity = opacity; }

    public void toggle() {
        this.enabled = !this.enabled;
    }
}
