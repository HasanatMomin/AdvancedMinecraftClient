package com.advanced.client.util;

public class ColorUtils {

    public static int hexToColor(String hex) {
        return (int) Long.parseLong(hex.replace("0x", "").replace("#", ""), 16);
    }

    public static String colorToHex(int color) {
        return String.format("0x%06X", (color & 0xFFFFFF));
    }

    public static int withAlpha(int color, float alpha) {
        int a = (int) (alpha * 255);
        return (a << 24) | (color & 0xFFFFFF);
    }

    public static int lerp(int colorA, int colorB, float t) {
        int r = (int) (((colorA >> 16) & 0xFF) * (1 - t) + ((colorB >> 16) & 0xFF) * t);
        int g = (int) (((colorA >> 8) & 0xFF) * (1 - t) + ((colorB >> 8) & 0xFF) * t);
        int b = (int) ((colorA & 0xFF) * (1 - t) + (colorB & 0xFF) * t);
        return (r << 16) | (g << 8) | b;
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
}
