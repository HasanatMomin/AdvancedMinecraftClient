package com.advanced.client.mods.display;

import com.advanced.client.mods.Mod;
import org.lwjgl.glfw.GLFW;

public class KeystrokesDisplayMod extends Mod {

    public KeystrokesDisplayMod() {
        super("keystrokesdisplay", "Keystrokes", "⌨️");
    }

    @Override
    public void onRender() {
        long window = getMinecraft().getWindow().getWindow();
        StringBuilder text = new StringBuilder("[");
        if (GLFW.glfwGetKey(window, GLFW.GLFW_KEY_W) == GLFW.GLFW_PRESS) text.append("W ");
        if (GLFW.glfwGetKey(window, GLFW.GLFW_KEY_A) == GLFW.GLFW_PRESS) text.append("A ");
        if (GLFW.glfwGetKey(window, GLFW.GLFW_KEY_S) == GLFW.GLFW_PRESS) text.append("S ");
        if (GLFW.glfwGetKey(window, GLFW.GLFW_KEY_D) == GLFW.GLFW_PRESS) text.append("D");
        text.append("]");

        getMinecraft().font.drawShadow(
                new com.mojang.blaze3d.vertex.PoseStack(),
                text.toString(), x, y, color);
    }

    @Override
    public void onUpdate() {
    }

    @Override
    public void onKeyPress(int keyCode) {
    }
}
