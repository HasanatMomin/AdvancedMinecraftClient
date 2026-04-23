package com.maple.client.mods.display;

import com.maple.client.mods.Mod;
import com.maple.client.util.RenderUtils;

public class CoordinatesDisplayMod extends Mod {
    
    public CoordinatesDisplayMod() {
        super("coordinatesdisplay", "Coordinates", "📍");
        this.x = 5;
        this.y = 65;
    }
    
    @Override
    public void onRender() {
        if (getMinecraft().player != null) {
            double px = getMinecraft().player.getX();
            double py = getMinecraft().player.getY();
            double pz = getMinecraft().player.getZ();
            float yaw = getMinecraft().player.getYRot();
            String direction = getDirection(yaw);
            String text = String.format("X:%.1f Y:%.1f Z:%.1f [%s]", px, py, pz, direction);
            int drawX = (int) x;
            int drawY = (int) y;
            RenderUtils.drawText(text, drawX, drawY, 0xFFFFFFFF);
        }
    }
    
    @Override
    public void onUpdate() {}
    
    @Override
    public void onKeyPress(int keyCode) {}
    
    private String getDirection(float yaw) {
        if (yaw < 45 || yaw >= 315) return "E";
        if (yaw >= 45 && yaw < 135) return "S";
        if (yaw >= 135 && yaw < 225) return "W";
        return "N";
    }
}