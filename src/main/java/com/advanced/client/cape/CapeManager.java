package com.advanced.client.cape;

import com.advanced.client.util.Logger;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.util.ResourceLocation;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class CapeManager {

    private final Map<UUID, ResourceLocation> capeTextures = new HashMap<>();
    private ResourceLocation defaultCape = null;
    private boolean capeEnabled = true;

    public CapeManager() {
    }

    public void setCapeEnabled(boolean enabled) {
        this.capeEnabled = enabled;
    }

    public boolean isCapeEnabled() {
        return capeEnabled;
    }

    public void registerCape(UUID uuid, ResourceLocation texture) {
        capeTextures.put(uuid, texture);
    }

    public ResourceLocation getCapeTexture(AbstractClientPlayer player) {
        if (!capeEnabled) return null;
        ResourceLocation tex = capeTextures.get(player.getUniqueID());
        if (tex != null) return tex;
        return defaultCape;
    }

    public boolean hasCape(AbstractClientPlayer player) {
        return capeEnabled && (capeTextures.containsKey(player.getUniqueID()) || defaultCape != null);
    }

    public void setDefaultCape(ResourceLocation location) {
        this.defaultCape = location;
    }

    public void clearCapes() {
        capeTextures.clear();
    }
}
