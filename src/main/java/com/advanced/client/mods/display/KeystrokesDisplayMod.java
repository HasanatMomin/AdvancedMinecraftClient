package com.advanced.client.mods.display;

import com.advanced.client.mods.Mod;
import com.advanced.client.render.RenderUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.GameSettings;
import org.lwjgl.input.Keyboard;

public class KeystrokesDisplayMod extends Mod {

    public KeystrokesDisplayMod() {
        super("keystrokesdisplay", "Keystrokes", "⌨️");
        this.x = 2;
        this.y = 60;
    }

    @Override
    public void onRender() {
        Minecraft mc = getMinecraft();
        GameSettings gs = mc.gameSettings;

        float bx = x, by = y;
        float bw = 20, bh = 14, gap = 2;

        boolean w = Keyboard.isKeyDown(gs.keyBindForward.getKeyCode());
        boolean a = Keyboard.isKeyDown(gs.keyBindLeft.getKeyCode());
        boolean s = Keyboard.isKeyDown(gs.keyBindBack.getKeyCode());
        boolean d = Keyboard.isKeyDown(gs.keyBindRight.getKeyCode());
        boolean space = Keyboard.isKeyDown(gs.keyBindJump.getKeyCode());
        boolean lmb = org.lwjgl.input.Mouse.isButtonDown(0);
        boolean rmb = org.lwjgl.input.Mouse.isButtonDown(1);

        drawKey("W", bx + bw + gap, by, bw, bh, w);
        drawKey("A", bx, by + bh + gap, bw, bh, a);
        drawKey("S", bx + bw + gap, by + bh + gap, bw, bh, s);
        drawKey("D", bx + (bw + gap) * 2, by + bh + gap, bw, bh, d);
        drawKey("SPACE", bx, by + (bh + gap) * 2, bw * 3 + gap * 2, bh, space);
        drawKey("LMB", bx, by - bh - gap, bw + 2, bh, lmb);
        drawKey("RMB", bx + bw + gap + 2, by - bh - gap, bw + 2, bh, rmb);
    }

    private void drawKey(String label, float x, float y, float w, float h, boolean pressed) {
        int bg = pressed ? 0xAA00FF00 : 0x88000000;
        RenderUtils.drawRect(x, y, w, h, bg);
        int textW = getMinecraft().fontRenderer.getStringWidth(label);
        getMinecraft().fontRenderer.drawStringWithShadow(label,
                x + (w - textW) / 2f, y + (h - 8) / 2f, color);
    }

    @Override
    public void onUpdate() {
    }

    @Override
    public void onKeyPress(int keyCode) {
    }
}
