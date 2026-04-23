package com.maple.client.cape;

import com.mojang.blaze3d.vertex.PoseStack;

public class CapeRenderer {
    private CapeManager capeManager;
    
    public CapeRenderer(CapeManager capeManager) {
        this.capeManager = capeManager;
    }
    
    public void renderCape(PoseStack poseStack, float partialTick, Object player) {
        if (capeManager.isCapeEnabled()) {
            // Cape rendering code will be integrated with entity renderer
            // This renders only in F5 (3rd person) camera mode
        }
    }
}