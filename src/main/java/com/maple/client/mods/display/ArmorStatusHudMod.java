package com.maple.client.mods.display;

import com.maple.client.mods.Mod;
import com.maple.client.util.RenderUtils;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;

public class ArmorStatusHudMod extends Mod {
    
    public ArmorStatusHudMod() {
        super("armorstatushud", "Armor Status", "🛡️", "Display");
        this.x = 10;
        this.y = 100;
        this.color = 0xFFFFFF;
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
            
            for (int i = 0; i < armor.length; i++) {
                if (!armor[i].isEmpty()) {
                    int durability = armor[i].getMaxDamage() - armor[i].getDamageValue();
                    int maxDurability = armor[i].getMaxDamage();
                    int percent = (durability * 100) / maxDurability;
                    String text = names[i] + ": " + percent + "%";
                    
                    int displayColor = 0x00FF00;
                    if (percent < 25) displayColor = 0xFF0000;
                    else if (percent < 50) displayColor = 0xFFFF00;
                    else if (percent < 75) displayColor = 0xFF8800;
                    
                    RenderUtils.drawText(getMinecraft(), text, (int) x, (int) (y + offsetY), displayColor);
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