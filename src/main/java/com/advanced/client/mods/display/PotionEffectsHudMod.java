package com.advanced.client.mods.display;

import com.advanced.client.mods.Mod;
import net.minecraft.client.Minecraft;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

import java.util.Collection;

public class PotionEffectsHudMod extends Mod {

    public PotionEffectsHudMod() {
        super("potioneffects", "Potion Effects HUD", "🧪");
        this.x = 2;
        this.y = 100;
    }

    @Override
    public void onRender() {
        Minecraft mc = getMinecraft();
        if (mc.player == null) return;

        Collection<PotionEffect> effects = mc.player.getActivePotionEffects();
        int offsetY = 0;
        for (PotionEffect effect : effects) {
            Potion potion = effect.getPotion();
            String name = potion.getName();
            int duration = effect.getDuration();
            int seconds = duration / 20;
            int amplifier = effect.getAmplifier() + 1;
            String text = name + " " + amplifier + " (" + formatTime(seconds) + ")";
            mc.fontRenderer.drawStringWithShadow(text, x, y + offsetY, color);
            offsetY += 10;
        }
    }

    private String formatTime(int seconds) {
        if (seconds >= 60) return (seconds / 60) + ":" + String.format("%02d", seconds % 60);
        return seconds + "s";
    }

    @Override
    public void onUpdate() {
    }

    @Override
    public void onKeyPress(int keyCode) {
    }
}
