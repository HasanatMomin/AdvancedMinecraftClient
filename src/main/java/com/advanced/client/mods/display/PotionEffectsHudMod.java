package com.advanced.client.mods.display;

import com.advanced.client.mods.Mod;
import net.minecraft.world.effect.MobEffectInstance;

public class PotionEffectsHudMod extends Mod {

    public PotionEffectsHudMod() {
        super("potioneffectshud", "Potion Effects", "🧪");
    }

    @Override
    public void onRender() {
        if (getMinecraft().player != null) {
            int offsetY = 0;
            com.mojang.blaze3d.vertex.PoseStack poseStack = new com.mojang.blaze3d.vertex.PoseStack();
            for (MobEffectInstance effect : getMinecraft().player.getActiveEffects()) {
                String effectName = effect.getEffect().getDisplayName().getString();
                int duration = effect.getDuration() / 20;
                String text = effectName + " " + duration + "s";

                getMinecraft().font.drawShadow(poseStack, text, x, y + offsetY, 0xFF00FF00);
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
