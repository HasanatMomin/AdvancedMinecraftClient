package com.maple.client.event;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderGuiEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import com.maple.client.mods.ModManager;

@Mod.EventBusSubscriber(modid = "mapleclient", bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class ClientEventHandler {
    
    @SubscribeEvent
    public static void onRenderGui(RenderGuiEvent.Post event) {
        ModManager.getInstance().renderAllMods();
    }
}