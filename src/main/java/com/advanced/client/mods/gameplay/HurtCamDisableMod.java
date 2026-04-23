package com.advanced.client.mods.gameplay;

import com.advanced.client.mods.Mod;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.client.event.EntityViewRenderEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class HurtCamDisableMod extends Mod {

    public HurtCamDisableMod() {
        super("hurtcamdisable", "Disable Hurt Cam", "🎥");
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onCameraSetup(EntityViewRenderEvent.CameraSetup event) {
        // Hook point - hurt cam tilt is handled by vanilla
    }

    @Override
    public void onRender() {
    }

    @Override
    public void onUpdate() {
        if (enabled) {
            getMinecraft().gameSettings.viewBobbing = false;
        }
    }

    @Override
    public void onKeyPress(int keyCode) {
    }
}
