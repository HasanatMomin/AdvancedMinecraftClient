package com.advanced.client.settings;

public class PerformancePresets {

    public enum Preset {
        LOW(1, "Low", 64, 2, false, false),
        MEDIUM(3, "Medium", 96, 4, true, false),
        HIGH(5, "High", 128, 8, true, true),
        ULTRA(8, "Ultra", 256, 16, true, true),
        MAX(10, "Max", 512, 32, true, true);

        public final int level;
        public final String name;
        public final int renderDistance;
        public final int maxFps;
        public final boolean fancyGraphics;
        public final boolean clouds;

        Preset(int level, String name, int renderDistance, int maxFps, boolean fancyGraphics, boolean clouds) {
            this.level = level;
            this.name = name;
            this.renderDistance = renderDistance;
            this.maxFps = maxFps;
            this.fancyGraphics = fancyGraphics;
            this.clouds = clouds;
        }
    }

    public static Preset fromLevel(int level) {
        for (Preset p : Preset.values()) {
            if (p.level == level) return p;
        }
        return Preset.HIGH;
    }

    public static void apply(Preset preset, net.minecraft.client.GameSettings gs) {
        gs.renderDistanceChunks = preset.renderDistance;
        gs.limitFramerate = preset.maxFps;
        gs.fancyGraphics = preset.fancyGraphics;
        gs.clouds = preset.clouds ? net.minecraft.client.GameSettings.Options.CLOUDS.returnEnumOrdinal() : 0;
    }
}
