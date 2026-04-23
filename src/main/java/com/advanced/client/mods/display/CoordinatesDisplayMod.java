package com.advanced.client.mods.display;

import com.advanced.client.mods.Mod;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;

public class CoordinatesDisplayMod extends Mod {

    public CoordinatesDisplayMod() {
        super("coordinatesdisplay", "Coordinates", "🗺️");
        this.x = 2;
        this.y = 40;
    }

    @Override
    public void onRender() {
        Minecraft mc = getMinecraft();
        if (mc.player == null) return;
        EntityPlayer player = mc.player;
        String text = String.format("XYZ: %.1f / %.1f / %.1f",
                player.posX, player.posY, player.posZ);
        mc.fontRenderer.drawStringWithShadow(text, x, y, color);
    }

    @Override
    public void onUpdate() {
    }

    @Override
    public void onKeyPress(int keyCode) {
    }
}
