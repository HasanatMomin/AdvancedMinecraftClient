package com.advanced.client.gui.animation;

public enum EasingFunction {

    LINEAR {
        @Override
        public float ease(float t) { return t; }
    },
    EASE_IN_QUAD {
        @Override
        public float ease(float t) { return t * t; }
    },
    EASE_OUT_QUAD {
        @Override
        public float ease(float t) { return t * (2 - t); }
    },
    EASE_IN_OUT_QUAD {
        @Override
        public float ease(float t) { return t < 0.5f ? 2 * t * t : -1 + (4 - 2 * t) * t; }
    },
    EASE_IN_CUBIC {
        @Override
        public float ease(float t) { return t * t * t; }
    },
    EASE_OUT_CUBIC {
        @Override
        public float ease(float t) { float f = t - 1; return f * f * f + 1; }
    },
    EASE_IN_OUT_CUBIC {
        @Override
        public float ease(float t) {
            return t < 0.5f ? 4 * t * t * t : (t - 1) * (2 * t - 2) * (2 * t - 2) + 1;
        }
    },
    EASE_OUT_BOUNCE {
        @Override
        public float ease(float t) {
            if (t < 1 / 2.75f) return 7.5625f * t * t;
            else if (t < 2 / 2.75f) { t -= 1.5f / 2.75f; return 7.5625f * t * t + 0.75f; }
            else if (t < 2.5f / 2.75f) { t -= 2.25f / 2.75f; return 7.5625f * t * t + 0.9375f; }
            else { t -= 2.625f / 2.75f; return 7.5625f * t * t + 0.984375f; }
        }
    };

    public abstract float ease(float t);
}
