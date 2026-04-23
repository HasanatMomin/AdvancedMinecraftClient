package com.advanced.client.cape;

import com.mojang.blaze3d.vertex.PoseStack;

public class CapeRenderer {

    private final CapeManager capeManager;

    public CapeRenderer(CapeManager capeManager) {
        this.capeManager = capeManager;
    }

    public void renderCape(PoseStack poseStack, float partialTick) {
        if (capeManager.isCapeLoaded()) {
            // Cape rendering in F5 mode is handled via mixin or layer injection
        }
    }
}
