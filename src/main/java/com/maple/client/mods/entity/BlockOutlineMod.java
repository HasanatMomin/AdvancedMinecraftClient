package com.maple.client.mods.entity;

import com.maple.client.mods.Mod;

public class BlockOutlineMod extends Mod {
    
    public BlockOutlineMod() {
        super("blockoutline", "Block Outline", "□", "Entity");
        setSetting("outlineColor", 0xFFFFFFFF);
        setSetting("outlineWidth", 1.0f);
    }
    
    @Override
    public void onRender() {
    }
    
    @Override
    public void onUpdate() {
    }
    
    @Override
    public void onKeyPress(int keyCode) {
    }
}