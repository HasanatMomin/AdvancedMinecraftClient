package com.maple.client.gui;

import net.minecraft.client.gui.screens.TitleScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.network.chat.Component;

public class MapleGuiMainMenu extends TitleScreen {
    
    @Override
    protected void init() {
        super.init();
        this.clearWidgets();
        
        this.addRenderableWidget(Button.builder(Component.literal("🍁 Launch Game"), (button) -> {
            this.minecraft.setScreen(null);
        }).bounds(this.width / 2 - 100, this.height / 2, 200, 20).build());
        
        this.addRenderableWidget(Button.builder(Component.literal("🍁 Maple Client Settings"), (button) -> {
            this.minecraft.setScreen(new MapleGuiClientSettings());
        }).bounds(this.width / 2 - 100, this.height / 2 + 30, 200, 20).build());
    }
}