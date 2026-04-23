package com.advanced.client.mods.display;

import com.advanced.client.mods.Mod;
import net.minecraft.client.multiplayer.PlayerInfo;

public class PingDisplayMod extends Mod {

    public PingDisplayMod() {
        super("pingdisplay", "Ping Display", "📡");
    }

    @Override
    public void onRender() {
        if (getMinecraft().player != null && getMinecraft().getConnection() != null) {
            int ping = getPing();
            String text = "Ping: " + ping + "ms";
            getMinecraft().font.draw(
                    com.mojang.blaze3d.vertex.PoseStack::new,
                    net.minecraft.network.chat.Component.literal(text),
                    x, y, color);
        }
    }

    @Override
    public void onUpdate() {
    }

    @Override
    public void onKeyPress(int keyCode) {
    }

    private int getPing() {
        if (getMinecraft().player != null && getMinecraft().getConnection() != null) {
            PlayerInfo playerInfo = getMinecraft().getConnection()
                    .getPlayerInfo(getMinecraft().player.getUUID());
            if (playerInfo != null) {
                return playerInfo.getLatency();
            }
        }
        return 0;
    }
}