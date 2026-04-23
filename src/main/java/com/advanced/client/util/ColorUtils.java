package com.advanced.client.util;

public class ColorUtils {

    public static int getColor(int r, int g, int b) {
        return getColor(r, g, b, 255);
    }

    public static int getColor(int r, int g, int b, int a) {
        r = Math.max(0, Math.min(255, r));
        g = Math.max(0, Math.min(255, g));
        b = Math.max(0, Math.min(255, b));
        a = Math.max(0, Math.min(255, a));
        return (a << 24) | (r << 16) | (g << 8) | b;
    }

    public static int withAlpha(int color, int alpha) {
        return (color & 0x00FFFFFF) | (alpha << 24);
    }

    public static int getRed(int color) {
        return (color >> 16) & 0xFF;
    }

    public static int getGreen(int color) {
        return (color >> 8) & 0xFF;
    }

    public static int getBlue(int color) {
        return color & 0xFF;
    }

    public static int getAlpha(int color) {
        return (color >> 24) & 0xFF;
    }

    public static int interpolate(int color1, int color2, float t) {
        int r1 = getRed(color1), g1 = getGreen(color1), b1 = getBlue(color1), a1 = getAlpha(color1);
        int r2 = getRed(color2), g2 = getGreen(color2), b2 = getBlue(color2), a2 = getAlpha(color2);
        return getColor(
            (int)(r1 + (r2 - r1) * t),
            (int)(g1 + (g2 - g1) * t),
            (int)(b1 + (b2 - b1) * t),
            (int)(a1 + (a2 - a1) * t)
        );
    }

    public static int rainbow(long speed) {
        float hue = (System.currentTimeMillis() % speed) / (float) speed;
        return java.awt.Color.HSBtoRGB(hue, 1.0f, 1.0f);
    }

    public static String toHexString(int color) {
        return String.format("0x%08X", color);
    }

    public static int fromHexString(String hex) {
        hex = hex.replace("0x", "").replace("#", "");
        return (int) Long.parseLong(hex, 16);
    }
}
