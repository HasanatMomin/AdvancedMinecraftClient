package com.advanced.client;

import com.advanced.client.gui.AdvancedGuiMainMenu;
import com.advanced.client.mods.ModManager;
import net.minecraft.client.Minecraft;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("advancedclient")
public class AdvancedClient {

    public static final String MOD_ID = "advancedclient";

    public AdvancedClient() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientSetup);
    }

    private void clientSetup(final FMLClientSetupEvent event) {
        ModManager.getInstance().registerAllMods();
    }
}
