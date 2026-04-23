package com.advanced.client.event;

import com.advanced.client.mods.display.CpsDisplayMod;
import com.advanced.client.AdvancedClient;
import com.advanced.client.mods.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import org.lwjgl.input.Mouse;

public class MouseHandler {

    @SubscribeEvent
    public void onMouseInput(InputEvent.MouseInputEvent event) {
        int button = Mouse.getEventButton();
        boolean state = Mouse.getEventButtonState();

        if (!state) return;

        if (AdvancedClient.instance != null && AdvancedClient.instance.getModManager() != null) {
            Mod mod = AdvancedClient.instance.getModManager().getModById("cpsdisplay");
            if (mod instanceof CpsDisplayMod) {
                ((CpsDisplayMod) mod).registerClick(button);
            }
        }
    }
}
