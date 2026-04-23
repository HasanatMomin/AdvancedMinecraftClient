package com.advanced.client.render;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import org.lwjgl.opengl.GL11;

public class RenderUtils {

    private static final Minecraft mc = Minecraft.getMinecraft();

    public static void drawRect(float x, float y, float width, float height, int color) {
        float a = ((color >> 24) & 0xFF) / 255.0f;
        float r = ((color >> 16) & 0xFF) / 255.0f;
        float g = ((color >> 8) & 0xFF) / 255.0f;
        float b = (color & 0xFF) / 255.0f;

        GlStateManager.enableBlend();
        GlStateManager.disableTexture2D();
        GlStateManager.blendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        GlStateManager.color(r, g, b, a);

        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder buffer = tessellator.getBuffer();
        buffer.begin(GL11.GL_QUADS, DefaultVertexFormats.POSITION);
        buffer.pos(x, y + height, 0).endVertex();
        buffer.pos(x + width, y + height, 0).endVertex();
        buffer.pos(x + width, y, 0).endVertex();
        buffer.pos(x, y, 0).endVertex();
        tessellator.draw();

        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();
    }

    public static void drawRoundedRect(float x, float y, float width, float height, float radius, int color) {
        drawRect(x + radius, y, width - 2 * radius, height, color);
        drawRect(x, y + radius, radius, height - 2 * radius, color);
        drawRect(x + width - radius, y + radius, radius, height - 2 * radius, color);
        drawCircleQuadrant(x + radius, y + radius, radius, color, 180);
        drawCircleQuadrant(x + width - radius, y + radius, radius, color, 270);
        drawCircleQuadrant(x + radius, y + height - radius, radius, color, 90);
        drawCircleQuadrant(x + width - radius, y + height - radius, radius, color, 0);
    }

    private static void drawCircleQuadrant(float cx, float cy, float r, int color, int startAngle) {
        float a = ((color >> 24) & 0xFF) / 255.0f;
        float red = ((color >> 16) & 0xFF) / 255.0f;
        float green = ((color >> 8) & 0xFF) / 255.0f;
        float blue = (color & 0xFF) / 255.0f;

        GlStateManager.enableBlend();
        GlStateManager.disableTexture2D();
        GlStateManager.blendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);

        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder buffer = tessellator.getBuffer();
        buffer.begin(GL11.GL_TRIANGLE_FAN, DefaultVertexFormats.POSITION_COLOR);
        buffer.pos(cx, cy, 0).color(red, green, blue, a).endVertex();
        for (int i = 0; i <= 8; i++) {
            double angle = Math.toRadians(startAngle + i * 90.0 / 8);
            buffer.pos(cx + r * Math.cos(angle), cy + r * Math.sin(angle), 0).color(red, green, blue, a).endVertex();
        }
        tessellator.draw();

        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();
    }

    public static void drawOutline(float x, float y, float width, float height, float lineWidth, int color) {
        GL11.glLineWidth(lineWidth);
        float a = ((color >> 24) & 0xFF) / 255.0f;
        float r = ((color >> 16) & 0xFF) / 255.0f;
        float g = ((color >> 8) & 0xFF) / 255.0f;
        float b = (color & 0xFF) / 255.0f;

        GlStateManager.enableBlend();
        GlStateManager.disableTexture2D();

        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder buffer = tessellator.getBuffer();
        buffer.begin(GL11.GL_LINE_LOOP, DefaultVertexFormats.POSITION_COLOR);
        buffer.pos(x, y, 0).color(r, g, b, a).endVertex();
        buffer.pos(x + width, y, 0).color(r, g, b, a).endVertex();
        buffer.pos(x + width, y + height, 0).color(r, g, b, a).endVertex();
        buffer.pos(x, y + height, 0).color(r, g, b, a).endVertex();
        tessellator.draw();

        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();
    }

    public static void drawGradientRect(float x, float y, float width, float height, int topColor, int bottomColor) {
        float a1 = ((topColor >> 24) & 0xFF) / 255.0f;
        float r1 = ((topColor >> 16) & 0xFF) / 255.0f;
        float g1 = ((topColor >> 8) & 0xFF) / 255.0f;
        float b1 = (topColor & 0xFF) / 255.0f;
        float a2 = ((bottomColor >> 24) & 0xFF) / 255.0f;
        float r2 = ((bottomColor >> 16) & 0xFF) / 255.0f;
        float g2 = ((bottomColor >> 8) & 0xFF) / 255.0f;
        float b2 = (bottomColor & 0xFF) / 255.0f;

        GlStateManager.enableBlend();
        GlStateManager.disableTexture2D();
        GlStateManager.blendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        GlStateManager.shadeModel(GL11.GL_SMOOTH);

        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder buffer = tessellator.getBuffer();
        buffer.begin(GL11.GL_QUADS, DefaultVertexFormats.POSITION_COLOR);
        buffer.pos(x, y + height, 0).color(r2, g2, b2, a2).endVertex();
        buffer.pos(x + width, y + height, 0).color(r2, g2, b2, a2).endVertex();
        buffer.pos(x + width, y, 0).color(r1, g1, b1, a1).endVertex();
        buffer.pos(x, y, 0).color(r1, g1, b1, a1).endVertex();
        tessellator.draw();

        GlStateManager.shadeModel(GL11.GL_FLAT);
        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();
    }

    public static void setupRender() {
        GlStateManager.pushMatrix();
        GlStateManager.enableBlend();
        GlStateManager.blendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
    }

    public static void restoreRender() {
        GlStateManager.disableBlend();
        GlStateManager.popMatrix();
    }
}
