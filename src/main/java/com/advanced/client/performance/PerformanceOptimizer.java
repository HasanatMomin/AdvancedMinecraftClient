package com.advanced.client.performance;

import com.advanced.client.AdvancedClient;
import com.advanced.client.settings.ClientSettings;
import com.advanced.client.settings.PerformancePresets;
import com.advanced.client.util.Logger;
import net.minecraft.client.Minecraft;

public class PerformanceOptimizer {

    private final Minecraft mc = Minecraft.getMinecraft();

    public void apply() {
        ClientSettings settings = AdvancedClient.instance != null ? AdvancedClient.instance.getClientSettings() : null;
        if (settings == null) return;

        int level = settings.getPerformanceLevel();
        PerformancePresets.Preset preset = PerformancePresets.fromLevel(level);
        PerformancePresets.apply(preset, mc.gameSettings);
        Logger.info("Applied performance preset: " + preset.name);
    }

    public void setPerformanceLevel(int level) {
        ClientSettings settings = AdvancedClient.instance != null ? AdvancedClient.instance.getClientSettings() : null;
        if (settings != null) settings.setPerformanceLevel(level);
        apply();
    }
}
