package com.advanced.client.mods.display;

import com.advanced.client.mods.Mod;
import net.minecraft.client.network.NetworkPlayerInfo;

public class PingDisplayMod extends Mod {

    public PingDisplayMod() {
        super("pingdisplay", "Ping Display", "📡");
    }

    @Override
    public void onRender() {
        int ping = getPing();
        String text = "Ping: " + ping + "ms";
        drawText(text, (int) x, (int) y, color);
    }

    @Override
    public void onUpdate() {
    }

    @Override
    public void onKeyPress(int keyCode) {
    }

    private int getPing() {
        if (getMinecraft().player != null) {
            NetworkPlayerInfo playerInfo = getMinecraft().getConnection()
                    .getPlayerInfo(getMinecraft().player.getUUID());
            if (playerInfo != null) {
                return playerInfo.getResponseTime();
            }
        }
        return 0;
    }

    private void drawText(String text, int x, int y, int color) {
        getMinecraft().fontRenderer.drawStringWithShadow(text, x, y, color);
    }
}