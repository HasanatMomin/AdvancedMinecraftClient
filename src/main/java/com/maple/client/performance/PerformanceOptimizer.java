package com.maple.client.performance;

import java.util.HashMap;
import java.util.Map;

public class PerformanceOptimizer {
    
    public static class PerformancePreset {
        public int renderDistance;
        public int particleDensity;
        public boolean cloudRendering;
        public boolean weatherParticles;
        public int entityRenderDistance;
        public int mipmapLevel;
        public boolean vsyncEnabled;
        public float graphicsLevel;
        
        public PerformancePreset(int renderDistance, int particleDensity, boolean cloudRendering,
                                 boolean weatherParticles, int entityRenderDistance,
                                 int mipmapLevel, boolean vsyncEnabled, float graphicsLevel) {
            this.renderDistance = renderDistance;
            this.particleDensity = particleDensity;
            this.cloudRendering = cloudRendering;
            this.weatherParticles = weatherParticles;
            this.entityRenderDistance = entityRenderDistance;
            this.mipmapLevel = mipmapLevel;
            this.vsyncEnabled = vsyncEnabled;
            this.graphicsLevel = graphicsLevel;
        }
    }
    
    private static final Map<Integer, PerformancePreset> PRESETS = new HashMap<>();
    
    static {
        PRESETS.put(1, new PerformancePreset(32, 100, true, true, 128, 4, true, 1.0f));
        PRESETS.put(2, new PerformancePreset(28, 90, true, true, 120, 4, true, 1.0f));
        PRESETS.put(3, new PerformancePreset(24, 80, true, true, 100, 3, false, 0.9f));
        PRESETS.put(4, new PerformancePreset(20, 70, true, true, 80, 2, false, 0.8f));
        PRESETS.put(5, new PerformancePreset(16, 60, true, false, 64, 2, false, 0.7f));
        PRESETS.put(6, new PerformancePreset(14, 50, false, false, 48, 1, false, 0.6f));
        PRESETS.put(7, new PerformancePreset(12, 40, false, false, 40, 1, false, 0.5f));
        PRESETS.put(8, new PerformancePreset(10, 30, false, false, 32, 0, false, 0.4f));
        PRESETS.put(9, new PerformancePreset(8, 20, false, false, 24, 0, false, 0.2f));
        PRESETS.put(10, new PerformancePreset(6, 10, false, false, 16, 0, false, 0.1f));
    }
    
    public static PerformancePreset getPreset(int level) {
        level = Math.max(1, Math.min(10, level));
        return PRESETS.getOrDefault(level, PRESETS.get(5));
    }
}