package com.advanced.client.mods.display;

import com.advanced.client.mods.Mod;

public class CoordinatesDisplayMod extends Mod {

    public CoordinatesDisplayMod() {
        super("coordinatesdisplay", "Coordinates", "📍");
    }

    @Override
    public void onRender() {
        if (getMinecraft().player != null) {
            double px = getMinecraft().player.getX();
            double py = getMinecraft().player.getY();
            double pz = getMinecraft().player.getZ();
            float yaw = getMinecraft().player.getYRot();
            String direction = getDirection(yaw);

            String text = String.format("X: %.1f Y: %.1f Z: %.1f [%s]", px, py, pz, direction);
            getMinecraft().font.drawShadow(
                    new com.mojang.blaze3d.vertex.PoseStack(),
                    text, x, y, color);
        }
    }

    @Override
    public void onUpdate() {
    }

    @Override
    public void onKeyPress(int keyCode) {
    }

    private String getDirection(float yaw) {
        float normalized = ((yaw % 360) + 360) % 360;
        if (normalized < 45 || normalized >= 315) return "South";
        if (normalized >= 45 && normalized < 135) return "West";
        if (normalized >= 135 && normalized < 225) return "North";
        return "East";
    }
}
