package com.maple.client;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafxmod.FXModLanguageProvider;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.maple.client.mods.ModManager;
import com.maple.client.settings.ClientSettings;

@Mod("mapleclient")
public class MapleClient {
    public static final String MOD_ID = "mapleclient";
    public static final String MOD_NAME = "Maple Client";
    public static final String VERSION = "1.0.0";
    
    private static final Logger LOGGER = LogManager.getLogger();
    public static MapleClient instance;
    public static ClientSettings settings;
    
    public MapleClient() {
        instance = this;
        LOGGER.info("🍁 Maple Client v" + VERSION + " initializing...");
        
        IEventBus modEventBus = net.minecraftforge.fml.javafxmod.FXModLanguageProvider.getModEventBus();
        modEventBus.addListener(this::clientSetup);
    }
    
    private void clientSetup(FMLClientSetupEvent event) {
        LOGGER.info("🍁 Maple Client Setup Complete!");
        settings = new ClientSettings();
        ModManager.getInstance().registerAllMods();
    }
    
    public static void log(String message) {
        LOGGER.info("[🍁 Maple] " + message);
    }
    
    public static void logError(String message) {
        LOGGER.error("[🍁 Maple] " + message);
    }
}