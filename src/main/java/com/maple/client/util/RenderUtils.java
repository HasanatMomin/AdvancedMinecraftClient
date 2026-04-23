package com.maple.client.util;

import net.minecraft.client.Minecraft;

public class RenderUtils {
    
    public static void drawText(String text, int x, int y, int color) {
        Minecraft mc = Minecraft.getInstance();
        if (mc.font != null && mc.gui != null) {
            mc.font.drawInBatch(text, x, y, color, false, mc.gui.getGuiScale(), 0, 0, 0xFFFFFF, false);
        }
    }
    
    public static void drawTextWithShadow(String text, int x, int y, int color) {
        Minecraft mc = Minecraft.getInstance();
        if (mc.font != null) {
            mc.font.drawInBatch(text, x, y, color, true, mc.gui.getGuiScale(), 0, 0, 0xFFFFFF, false);
        }
    }
}