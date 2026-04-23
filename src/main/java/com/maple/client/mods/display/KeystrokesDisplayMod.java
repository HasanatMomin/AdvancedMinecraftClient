package com.maple.client.mods.display;

import com.maple.client.mods.Mod;
import com.maple.client.util.RenderUtils;
import org.lwjgl.input.Keyboard;

public class KeystrokesDisplayMod extends Mod {
    
    public KeystrokesDisplayMod() {
        super("keystrokesdisplay", "Keystrokes", "⌨️");
        this.x = 5;
        this.y = 50;
    }
    
    @Override
    public void onRender() {
        StringBuilder text = new StringBuilder("[");
        if (Keyboard.isKeyDown(Keyboard.KEY_W)) text.append("W ");
        if (Keyboard.isKeyDown(Keyboard.KEY_A)) text.append("A ");
        if (Keyboard.isKeyDown(Keyboard.KEY_S)) text.append("S ");
        if (Keyboard.isKeyDown(Keyboard.KEY_D)) text.append("D");
        text.append("]");
        
        int drawX = (int) x;
        int drawY = (int) y;
        RenderUtils.drawText(text.toString(), drawX, drawY, 0xFFFFFFFF);
    }
    
    @Override
    public void onUpdate() {}
    
    @Override
    public void onKeyPress(int keyCode) {}
}