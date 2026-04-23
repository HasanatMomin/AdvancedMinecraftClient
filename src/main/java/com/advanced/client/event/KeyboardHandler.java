package com.advanced.client.event;

import com.advanced.client.AdvancedClient;
import com.advanced.client.gui.GuiClientSettings;
import com.advanced.client.settings.KeybindManager;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import org.lwjgl.input.Keyboard;

public class KeyboardHandler {

    private final Minecraft mc = Minecraft.getMinecraft();

    @SubscribeEvent
    public void onKeyInput(InputEvent.KeyInputEvent event) {
        if (!Keyboard.getEventKeyState()) return;
        int keyCode = Keyboard.getEventKey();

        if (AdvancedClient.instance != null) {
            KeybindManager km = AdvancedClient.instance.getKeybindManager();
            if (km != null && keyCode == km.getOpenSettingsKey()) {
                mc.addScheduledTask(() -> mc.displayGuiScreen(new GuiClientSettings()));
                return;
            }
            if (AdvancedClient.instance.getModManager() != null) {
                AdvancedClient.instance.getModManager().onKeyPress(keyCode);
            }
        }
    }
}
