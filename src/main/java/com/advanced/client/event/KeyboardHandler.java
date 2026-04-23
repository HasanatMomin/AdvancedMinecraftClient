package com.advanced.client.event;

import com.advanced.client.mods.ModManager;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = "advancedclient", bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class KeyboardHandler {

    @SubscribeEvent
    public static void onKeyInput(InputEvent.Key event) {
        for (var mod : ModManager.getInstance().getAllMods()) {
            if (mod.isEnabled()) {
                mod.onKeyPress(event.getKey());
            }
        }
    }
}
