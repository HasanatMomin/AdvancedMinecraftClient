package com.maple.client;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafxmod.FXModLanguageProvider;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.maple.client.mods.ModManager;

@Mod("mapleclient")
public class MapleClient {
    public static final String MOD_ID = "mapleclient";
    public static final String MOD_NAME = "Maple Client";
    public static final String VERSION = "1.0.0";
    private static final Logger LOGGER = LogManager.getLogger();
    public static MapleClient instance;
    
    public MapleClient() {
        instance = this;
        LOGGER.info("[Maple Client] Initializing...");
        IEventBus modEventBus = FXModLanguageProvider.getModEventBus();
        modEventBus.addListener(this::clientSetup);
        ModManager.getInstance().registerAllMods();
    }
    
    private void clientSetup(FMLClientSetupEvent event) {
        LOGGER.info("[Maple Client] Setup Complete! Loaded " + ModManager.getInstance().getAllMods().size() + " mods");
    }
    
    public static void log(String message) {
        LOGGER.info("[Maple Client] " + message);
    }
}