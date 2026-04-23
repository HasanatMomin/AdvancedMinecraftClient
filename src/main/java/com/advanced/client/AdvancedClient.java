package com.advanced.client;

import com.advanced.client.event.ClientEventHandler;
import com.advanced.client.event.KeyboardHandler;
import com.advanced.client.event.RenderHandler;
import com.advanced.client.event.MouseHandler;
import com.advanced.client.mods.ModManager;
import com.advanced.client.settings.ClientSettings;
import com.advanced.client.settings.Config;
import com.advanced.client.settings.KeybindManager;
import com.advanced.client.cape.CapeManager;
import com.advanced.client.performance.PerformanceOptimizer;
import com.advanced.client.util.Logger;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = AdvancedClient.MODID, name = AdvancedClient.NAME, version = AdvancedClient.VERSION, clientSideOnly = true)
public class AdvancedClient {

    public static final String MODID = "advancedclient";
    public static final String NAME = "Advanced Minecraft Client";
    public static final String VERSION = "1.0.0";

    public static AdvancedClient instance;

    private ModManager modManager;
    private ClientSettings clientSettings;
    private Config config;
    private KeybindManager keybindManager;
    private CapeManager capeManager;
    private PerformanceOptimizer performanceOptimizer;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        instance = this;
        Logger.init(MODID);
        Logger.info("Advanced Minecraft Client pre-initializing...");
        config = new Config();
        clientSettings = new ClientSettings();
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        Logger.info("Advanced Minecraft Client initializing...");

        modManager = new ModManager();
        modManager.initMods();

        keybindManager = new KeybindManager();
        keybindManager.registerKeybinds();

        capeManager = new CapeManager();
        performanceOptimizer = new PerformanceOptimizer();

        MinecraftForge.EVENT_BUS.register(new ClientEventHandler());
        MinecraftForge.EVENT_BUS.register(new KeyboardHandler());
        MinecraftForge.EVENT_BUS.register(new RenderHandler());
        MinecraftForge.EVENT_BUS.register(new MouseHandler());

        config.load();

        Logger.info("Advanced Minecraft Client initialized successfully!");
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        Logger.info("Advanced Minecraft Client post-initializing...");
        performanceOptimizer.apply();
    }

    public ModManager getModManager() { return modManager; }
    public ClientSettings getClientSettings() { return clientSettings; }
    public Config getConfig() { return config; }
    public KeybindManager getKeybindManager() { return keybindManager; }
    public CapeManager getCapeManager() { return capeManager; }
    public PerformanceOptimizer getPerformanceOptimizer() { return performanceOptimizer; }
}
