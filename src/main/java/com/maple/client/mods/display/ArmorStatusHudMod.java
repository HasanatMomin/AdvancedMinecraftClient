package com.maple.client.mods.display;

import com.maple.client.mods.Mod;
import com.maple.client.util.RenderUtils;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;

public class ArmorStatusHudMod extends Mod {
    
    public ArmorStatusHudMod() {
        super("armorstatushud", "Armor Status", "🛡️");
        this.x = 5;
        this.y = 95;
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
            
            String[] names = {"H", "C", "L", "F"};
            int offsetY = 0;
            for (int i = 0; i < armor.length; i++) {
                if (!armor[i].isEmpty()) {
                    int durability = armor[i].getMaxDamage() - armor[i].getDamageValue();
                    int maxDurability = armor[i].getMaxDamage();
                    int percent = (durability * 100) / maxDurability;
                    String text = names[i] + ":" + percent + "%";
                    int drawX = (int) x;
                    int drawY = (int) (y + offsetY);
                    int color = percent > 75 ? 0xFF00FF00 : percent > 50 ? 0xFFFFFF00 : percent > 25 ? 0xFFFF8800 : 0xFFFF0000;
                    RenderUtils.drawText(text, drawX, drawY, color);
                    offsetY += 12;
                }
            }
        }
    }
    
    @Override
    public void onUpdate() {}
    
    @Override
    public void onKeyPress(int keyCode) {}
}