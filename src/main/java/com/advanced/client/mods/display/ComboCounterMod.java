package com.advanced.client.mods.display;

import com.advanced.client.mods.Mod;
import net.minecraft.client.Minecraft;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ComboCounterMod extends Mod {

    private int combo = 0;
    private long lastHitTime = 0;
    private static final long COMBO_RESET_TIME = 3000;

    public ComboCounterMod() {
        super("combocounter", "Combo Counter", "🥊");
        this.x = 2;
        this.y = 280;
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onLivingHurt(LivingHurtEvent event) {
        Minecraft mc = Minecraft.getMinecraft();
        if (mc.player == null) return;
        if (event.getSource().getTrueSource() == mc.player) {
            combo++;
            lastHitTime = System.currentTimeMillis();
        }
    }

    @Override
    public void onRender() {
        if (combo > 0) {
            String text = "Combo: " + combo + "x";
            getMinecraft().fontRenderer.drawStringWithShadow(text, x, y, color);
        }
    }

    @Override
    public void onUpdate() {
        if (combo > 0 && System.currentTimeMillis() - lastHitTime > COMBO_RESET_TIME) {
            combo = 0;
        }
    }

    @Override
    public void onKeyPress(int keyCode) {
    }
}
