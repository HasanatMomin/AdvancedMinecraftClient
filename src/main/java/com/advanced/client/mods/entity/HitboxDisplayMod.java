package com.advanced.client.mods.entity;

import com.advanced.client.mods.Mod;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderGlobal;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.lwjgl.opengl.GL11;

import java.util.List;

public class HitboxDisplayMod extends Mod {

    public HitboxDisplayMod() {
        super("hitboxdisplay", "Hitbox Display", "📦");
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onRenderWorldLast(RenderWorldLastEvent event) {
        if (!enabled) return;
        Minecraft mc = getMinecraft();
        if (mc.world == null || mc.player == null) return;

        double px = mc.player.lastTickPosX + (mc.player.posX - mc.player.lastTickPosX) * event.getPartialTicks();
        double py = mc.player.lastTickPosY + (mc.player.posY - mc.player.lastTickPosY) * event.getPartialTicks();
        double pz = mc.player.lastTickPosZ + (mc.player.posZ - mc.player.lastTickPosZ) * event.getPartialTicks();

        GlStateManager.pushMatrix();
        GlStateManager.translate(-px, -py, -pz);
        GlStateManager.disableTexture2D();
        GlStateManager.enableBlend();
        GlStateManager.blendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        GlStateManager.disableDepth();
        GL11.glLineWidth(1.5f);

        List<Entity> entities = mc.world.loadedEntityList;
        for (Entity entity : entities) {
            if (entity == mc.player) continue;
            AxisAlignedBB bb = entity.getEntityBoundingBox();
            RenderGlobal.drawSelectionBoundingBox(bb,
                    ((color >> 16) & 0xFF) / 255.0f,
                    ((color >> 8) & 0xFF) / 255.0f,
                    (color & 0xFF) / 255.0f,
                    opacity);
        }

        GlStateManager.enableDepth();
        GlStateManager.disableBlend();
        GlStateManager.enableTexture2D();
        GlStateManager.popMatrix();
    }

    @Override
    public void onRender() {
    }

    @Override
    public void onUpdate() {
    }

    @Override
    public void onKeyPress(int keyCode) {
    }
}
