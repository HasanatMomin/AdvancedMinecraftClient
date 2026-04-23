package com.advanced.client.event;

import com.advanced.client.AdvancedClient;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class RenderHandler {

    @SubscribeEvent
    public void onRenderOverlay(RenderGameOverlayEvent.Post event) {
        if (event.getType() != RenderGameOverlayEvent.ElementType.ALL) return;

        if (AdvancedClient.instance != null && AdvancedClient.instance.getModManager() != null) {
            AdvancedClient.instance.getModManager().onRender();
        }
    }
}
