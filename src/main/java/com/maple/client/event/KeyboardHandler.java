package com.maple.client.event;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import com.maple.client.mods.ModManager;
import org.lwjgl.input.Keyboard;

@Mod.EventBusSubscriber(modid = "mapleclient", bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class KeyboardHandler {
    
    @SubscribeEvent
    public static void onKeyInput(InputEvent.Key event) {
        if (event.getKey() == Keyboard.KEY_RSHIFT) {
            // Open settings
        }
        
        for (var mod : ModManager.getInstance().getAllMods()) {
            if (mod.isEnabled()) {
                mod.onKeyPress(event.getKey());
            }
        }
    }
}