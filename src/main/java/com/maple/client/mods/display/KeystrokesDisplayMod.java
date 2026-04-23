package com.maple.client.mods.display;

import com.maple.client.mods.Mod;
import com.maple.client.util.RenderUtils;
import org.lwjgl.input.Keyboard;

public class KeystrokesDisplayMod extends Mod {
    
    public KeystrokesDisplayMod() {
        super("keystrokesdisplay", "Keystrokes", "⌨️", "Display");
        this.x = 10;
        this.y = 55;
        this.color = 0xFFFFFF;
    }
    
    @Override
    public void onRender() {
        StringBuilder keys = new StringBuilder("[");
        if (Keyboard.isKeyDown(Keyboard.KEY_W)) keys.append("W ");
        if (Keyboard.isKeyDown(Keyboard.KEY_A)) keys.append("A ");
        if (Keyboard.isKeyDown(Keyboard.KEY_S)) keys.append("S ");
        if (Keyboard.isKeyDown(Keyboard.KEY_D)) keys.append("D");
        keys.append("]");
        
        RenderUtils.drawText(getMinecraft(), keys.toString(), (int) x, (int) y, color);
    }
    
    @Override
    public void onUpdate() {
    }
    
    @Override
    public void onKeyPress(int keyCode) {
    }
}