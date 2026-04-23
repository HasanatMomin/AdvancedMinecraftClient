package com.advanced.client.cape;

import net.minecraft.resources.ResourceLocation;

public class CapeManager {

    private ResourceLocation capeTexture = null;
    private boolean capeLoaded = false;

    public boolean isCapeLoaded() {
        return capeLoaded;
    }

    public ResourceLocation getCapeTexture() {
        return capeTexture;
    }

    public void loadCape(ResourceLocation location) {
        this.capeTexture = location;
        this.capeLoaded = (location != null);
    }

    public void unloadCape() {
        this.capeTexture = null;
        this.capeLoaded = false;
    }
}
