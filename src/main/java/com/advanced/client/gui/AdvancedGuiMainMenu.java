package com.advanced.client.gui;

import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.TitleScreen;
import net.minecraft.network.chat.Component;

public class AdvancedGuiMainMenu extends TitleScreen {

    @Override
    protected void init() {
        super.init();
        this.clearWidgets();

        // Launch Game Button
        this.addRenderableWidget(Button.builder(Component.literal("Launch Game"), (button) -> {
            this.minecraft.setScreen(null);
        }).bounds(this.width / 2 - 100, this.height / 2, 200, 20).build());

        // Client Settings Button
        this.addRenderableWidget(Button.builder(Component.literal("Client Settings"), (button) -> {
            this.minecraft.setScreen(new GuiClientSettings());
        }).bounds(this.width / 2 - 100, this.height / 2 + 30, 200, 20).build());
    }
}
