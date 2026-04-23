package com.advanced.client.mods.display;

import com.advanced.client.mods.Mod;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;

public class ArmorStatusHudMod extends Mod {

    public ArmorStatusHudMod() {
        super("armorstatushud", "Armor Status", "🛡️");
    }

    @Override
    public void onRender() {
        if (getMinecraft().player != null) {
            ItemStack[] armor = {
                getMinecraft().player.getItemBySlot(EquipmentSlot.HEAD),
                getMinecraft().player.getItemBySlot(EquipmentSlot.CHEST),
                getMinecraft().player.getItemBySlot(EquipmentSlot.LEGS),
                getMinecraft().player.getItemBySlot(EquipmentSlot.FEET)
            };

            String[] names = {"Head", "Chest", "Legs", "Feet"};
            int offsetY = 0;
            com.mojang.blaze3d.vertex.PoseStack poseStack = new com.mojang.blaze3d.vertex.PoseStack();

            for (int i = 0; i < armor.length; i++) {
                if (!armor[i].isEmpty() && armor[i].getMaxDamage() > 0) {
                    int durability = armor[i].getMaxDamage() - armor[i].getDamageValue();
                    int maxDurability = armor[i].getMaxDamage();
                    int percent = (durability * 100) / maxDurability;
                    String text = names[i] + ": " + percent + "%";

                    getMinecraft().font.drawShadow(poseStack, text, x, y + offsetY, 0xFFFFFF00);
                    offsetY += 12;
                }
            }
        }
    }

    @Override
    public void onUpdate() {
    }

    @Override
    public void onKeyPress(int keyCode) {
    }
}
