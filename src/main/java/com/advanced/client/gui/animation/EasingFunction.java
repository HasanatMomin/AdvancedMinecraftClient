package com.advanced.client.gui.animation;

public class EasingFunction {

    public static float easeInOut(float t) {
        return t < 0.5f ? 2 * t * t : -1 + (4 - 2 * t) * t;
    }

    public static float easeOut(float t) {
        return 1 - (1 - t) * (1 - t);
    }

    public static float easeIn(float t) {
        return t * t;
    }

    public static float linear(float t) {
        return t;
    }
}
