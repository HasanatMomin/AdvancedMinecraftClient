package com.advanced.client.mods.display;

import com.advanced.client.mods.Mod;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.RayTraceResult;

public class ReachDisplayMod extends Mod {

    private double lastReach = 0.0;

    public ReachDisplayMod() {
        super("reachdisplay", "Reach Display", "📏");
        this.x = 2;
        this.y = 260;
    }

    @Override
    public void onRender() {
        String text = String.format("Reach: %.2f", lastReach);
        getMinecraft().fontRenderer.drawStringWithShadow(text, x, y, color);
    }

    @Override
    public void onUpdate() {
        Minecraft mc = getMinecraft();
        if (mc.player == null || mc.objectMouseOver == null) {
            lastReach = 0.0;
            return;
        }
        RayTraceResult result = mc.objectMouseOver;
        if (result.typeOfHit == RayTraceResult.Type.ENTITY) {
            Entity entity = result.entityHit;
            lastReach = mc.player.getDistanceSq(entity.posX, entity.posY + entity.height / 2, entity.posZ);
            lastReach = Math.sqrt(lastReach);
        } else {
            lastReach = 0.0;
        }
    }

    @Override
    public void onKeyPress(int keyCode) {
    }
}
