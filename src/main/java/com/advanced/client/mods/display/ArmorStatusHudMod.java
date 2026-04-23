package com.advanced.client.mods.display;

import com.advanced.client.mods.Mod;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public class ArmorStatusHudMod extends Mod {

    public ArmorStatusHudMod() {
        super("armorstatus", "Armor Status HUD", "🛡️");
        this.x = 2;
        this.y = 200;
    }

    @Override
    public void onRender() {
        Minecraft mc = getMinecraft();
        if (mc.player == null) return;
        EntityPlayer player = mc.player;

        String[] slotNames = {"Helmet", "Chest", "Legs", "Boots"};
        int offsetY = 0;
        for (int i = 0; i < 4; i++) {
            ItemStack stack = player.inventory.armorInventory.get(3 - i);
            if (!stack.isEmpty()) {
                int durability = stack.getMaxDamage() - stack.getItemDamage();
                int max = stack.getMaxDamage();
                String text = slotNames[i] + ": " + durability + "/" + max;
                int col = getDurabilityColor(durability, max);
                mc.fontRenderer.drawStringWithShadow(text, x, y + offsetY, col);
                offsetY += 10;
            }
        }
    }

    private int getDurabilityColor(int durability, int max) {
        if (max == 0) return 0xFFFFFF;
        float ratio = (float) durability / max;
        if (ratio > 0.5f) return 0x00FF00;
        if (ratio > 0.25f) return 0xFFFF00;
        return 0xFF0000;
    }

    @Override
    public void onUpdate() {
    }

    @Override
    public void onKeyPress(int keyCode) {
    }
}
