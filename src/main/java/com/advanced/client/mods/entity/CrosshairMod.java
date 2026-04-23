package com.advanced.client.mods.entity;

import com.advanced.client.mods.Mod;
import com.advanced.client.render.RenderUtils;
import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class CrosshairMod extends Mod {

    public CrosshairMod() {
        super("crosshair", "Custom Crosshair", "➕");
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent(priority = EventPriority.HIGH)
    public void onRenderOverlay(RenderGameOverlayEvent.Pre event) {
        if (!enabled) return;
        if (event.getType() == RenderGameOverlayEvent.ElementType.CROSSHAIRS) {
            event.setCanceled(true);
            drawCustomCrosshair();
        }
    }

    private void drawCustomCrosshair() {
        Minecraft mc = getMinecraft();
        int cx = mc.displayWidth / 2 / mc.gameSettings.guiScale;
        int cy = mc.displayHeight / 2 / mc.gameSettings.guiScale;
        int size = 6;
        int thickness = 1;
        int col = 0xFFFFFFFF;
        RenderUtils.drawRect(cx - size, cy - thickness, size * 2, thickness * 2, col);
        RenderUtils.drawRect(cx - thickness, cy - size, thickness * 2, size * 2, col);
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
