package com.advanced.client.gui.animation;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.shader.ShaderGroup;
import net.minecraft.util.ResourceLocation;

public class BlurEffect {

    private static final Minecraft mc = Minecraft.getMinecraft();
    private static ShaderGroup blurShader;
    private static boolean active = false;

    public static void enable(float radius) {
        if (!active) {
            try {
                blurShader = new ShaderGroup(mc.getTextureManager(), mc.getResourceManager(),
                        mc.getFramebuffer(), new ResourceLocation("shaders/post/blur.json"));
                blurShader.createBindFramebuffers(mc.displayWidth, mc.displayHeight);
                active = true;
            } catch (Exception e) {
                // Blur shader not available, skip
            }
        }
    }

    public static void disable() {
        if (active && blurShader != null) {
            blurShader.deleteShaderGroup();
            blurShader = null;
            active = false;
        }
    }

    public static boolean isActive() {
        return active;
    }

    public static void render(float partialTicks) {
        if (active && blurShader != null) {
            GlStateManager.matrixMode(5890);
            GlStateManager.loadIdentity();
            GlStateManager.matrixMode(5888);
            blurShader.render(partialTicks);
            mc.getFramebuffer().bindFramebuffer(true);
        }
    }
}
