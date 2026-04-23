package com.advanced.client.render;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;

public class TextureManager {

    private static final Minecraft mc = Minecraft.getMinecraft();

    public static void bindTexture(ResourceLocation location) {
        mc.getTextureManager().bindTexture(location);
    }

    public static void bindTexture(String domain, String path) {
        bindTexture(new ResourceLocation(domain, path));
    }

    public static void enableAlpha() {
        GlStateManager.enableAlpha();
    }

    public static void disableAlpha() {
        GlStateManager.disableAlpha();
    }

    public static void enableBlend() {
        GlStateManager.enableBlend();
    }

    public static void disableBlend() {
        GlStateManager.disableBlend();
    }

    public static void setColor(float r, float g, float b, float a) {
        GlStateManager.color(r, g, b, a);
    }

    public static void resetColor() {
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
    }
}
