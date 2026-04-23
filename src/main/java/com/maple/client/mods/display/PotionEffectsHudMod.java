package com.maple.client.mods.display;

import com.maple.client.mods.Mod;
import com.maple.client.util.RenderUtils;
import net.minecraft.world.effect.MobEffectInstance;

public class PotionEffectsHudMod extends Mod {
    
    public PotionEffectsHudMod() {
        super("potioneffectshud", "Potion Effects", "🧪");
        this.x = 5;
        this.y = 80;
    }
    
    @Override
    public void onRender() {
        if (getMinecraft().player != null) {
            int offsetY = 0;
            for (MobEffectInstance effect : getMinecraft().player.getActiveEffects()) {
                String effectName = effect.getEffect().getDisplayName().getString();
                int duration = effect.getDuration() / 20;
                String text = effectName + " " + duration + "s";
                int drawX = (int) x;
                int drawY = (int) (y + offsetY);
                RenderUtils.drawText(text, drawX, drawY, 0xFF00FF00);
                offsetY += 12;
            }
        }
    }
    
    @Override
    public void onUpdate() {}
    
    @Override
    public void onKeyPress(int keyCode) {}
}