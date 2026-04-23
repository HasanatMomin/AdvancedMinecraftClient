package com.advanced.client.mods.entity;

import com.advanced.client.mods.Mod;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderGlobal;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraftforge.client.event.DrawBlockHighlightEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.lwjgl.opengl.GL11;

public class BlockOutlineMod extends Mod {

    public BlockOutlineMod() {
        super("blockoutline", "Block Outline", "🔲");
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onDrawBlockHighlight(DrawBlockHighlightEvent event) {
        if (!enabled) return;
        event.setCanceled(true);
        RayTraceResult result = event.getTarget();
        if (result == null || result.typeOfHit != RayTraceResult.Type.BLOCK) return;

        BlockPos pos = result.getBlockPos();
        double px = event.getPlayer().lastTickPosX + (event.getPlayer().posX - event.getPlayer().lastTickPosX) * event.getPartialTicks();
        double py = event.getPlayer().lastTickPosY + (event.getPlayer().posY - event.getPlayer().lastTickPosY) * event.getPartialTicks();
        double pz = event.getPlayer().lastTickPosZ + (event.getPlayer().posZ - event.getPlayer().lastTickPosZ) * event.getPartialTicks();

        GlStateManager.enableBlend();
        GlStateManager.blendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        GlStateManager.disableTexture2D();
        GlStateManager.depthMask(false);
        GL11.glLineWidth(2.0f);

        RenderGlobal.drawSelectionBoundingBox(
                Minecraft.getMinecraft().world.getBlockState(pos).getSelectedBoundingBox(Minecraft.getMinecraft().world, pos)
                        .grow(0.002).offset(-px, -py, -pz),
                ((color >> 16) & 0xFF) / 255.0f,
                ((color >> 8) & 0xFF) / 255.0f,
                (color & 0xFF) / 255.0f,
                opacity
        );

        GlStateManager.depthMask(true);
        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();
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
