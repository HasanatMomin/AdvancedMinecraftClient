package com.maple.client.mods.display;

import com.maple.client.mods.Mod;
import com.maple.client.util.RenderUtils;
import net.minecraft.world.effect.MobEffectInstance;

public class PotionEffectsHudMod extends Mod {
    
    public PotionEffectsHudMod() {
        super("potioneffectshud", "Potion Effects", "🧪", "Display");
        this.x = 10;
        this.y = 85;
        this.color = 0x00FF00;
    }
    
    @Override
    public void onRender() {
        if (getMinecraft().player != null) {
            int offsetY = 0;
            for (MobEffectInstance effect : getMinecraft().player.getActiveEffects()) {
                String effectName = effect.getEffect().getDisplayName().getString();
                int duration = effect.getDuration() / 20;
                String text = effectName + " " + duration + "s";
                
                RenderUtils.drawText(getMinecraft(), text, (int) x, (int) (y + offsetY), 0x00FF00);
                offsetY += 12;
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