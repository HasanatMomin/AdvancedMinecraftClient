package com.advanced.client.mods.entity;

import com.advanced.client.mods.Mod;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;

import java.util.List;

public class NametagsMod extends Mod {

    public NametagsMod() {
        super("nametags", "Nametags", "🏷️");
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

    public boolean shouldRenderNameplate(EntityPlayer player) {
        if (!enabled) return false;
        Minecraft mc = getMinecraft();
        if (mc.player == null) return false;
        return !player.equals(mc.player);
    }
}
