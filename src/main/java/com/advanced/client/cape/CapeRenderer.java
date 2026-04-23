package com.advanced.client.cape;

import com.advanced.client.AdvancedClient;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class CapeRenderer {

    private static final Minecraft mc = Minecraft.getMinecraft();

    public static void renderCape(AbstractClientPlayer player, float partialTicks) {
        CapeManager capeManager = AdvancedClient.instance != null ? AdvancedClient.instance.getCapeManager() : null;
        if (capeManager == null || !capeManager.hasCape(player)) return;

        ResourceLocation capeTexture = capeManager.getCapeTexture(player);
        if (capeTexture == null) return;

        GlStateManager.pushMatrix();
        GlStateManager.translate(0.0f, 0.0f, 0.125f);

        mc.getTextureManager().bindTexture(capeTexture);
        GlStateManager.enableBlend();
        GlStateManager.blendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);

        GlStateManager.popMatrix();
    }
}
