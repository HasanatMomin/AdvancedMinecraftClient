package com.advanced.client.event;

import com.advanced.client.AdvancedClient;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class ClientEventHandler {

    private final Minecraft mc = Minecraft.getMinecraft();

    @SubscribeEvent
    public void onClientTick(TickEvent.ClientTickEvent event) {
        if (event.phase != TickEvent.Phase.END) return;
        if (mc.player == null || mc.world == null) return;

        if (AdvancedClient.instance != null && AdvancedClient.instance.getModManager() != null) {
            AdvancedClient.instance.getModManager().onUpdate();
        }
    }
}
