package com.advanced.client.util;

public class MathUtils {

    public static float clamp(float value, float min, float max) {
        return Math.max(min, Math.min(max, value));
    }

    public static double clamp(double value, double min, double max) {
        return Math.max(min, Math.min(max, value));
    }

    public static int clamp(int value, int min, int max) {
        return Math.max(min, Math.min(max, value));
    }

    public static float lerp(float a, float b, float t) {
        return a + (b - a) * t;
    }

    public static double lerp(double a, double b, double t) {
        return a + (b - a) * t;
    }

    public static float smoothStep(float edge0, float edge1, float x) {
        x = clamp((x - edge0) / (edge1 - edge0), 0.0f, 1.0f);
        return x * x * (3 - 2 * x);
    }

    public static double distance(double x1, double y1, double x2, double y2) {
        double dx = x2 - x1;
        double dy = y2 - y1;
        return Math.sqrt(dx * dx + dy * dy);
    }

    public static double distance3D(double x1, double y1, double z1, double x2, double y2, double z2) {
        double dx = x2 - x1, dy = y2 - y1, dz = z2 - z1;
        return Math.sqrt(dx * dx + dy * dy + dz * dz);
    }

    public static float wrapDegrees(float value) {
        value = value % 360.0f;
        if (value >= 180.0f) value -= 360.0f;
        if (value < -180.0f) value += 360.0f;
        return value;
    }

    public static boolean isInBounds(float x, float y, float bx, float by, float bw, float bh) {
        return x >= bx && x <= bx + bw && y >= by && y <= by + bh;
    }
}
