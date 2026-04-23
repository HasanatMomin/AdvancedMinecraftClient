package com.advanced.client.settings;

public class ClientSettings {

    private boolean rawMouseInput = true;
    private boolean borderlessFullscreen = false;
    private boolean disableHotbarScroll = false;
    private boolean capeEnabled = true;
    private int performanceLevel = 5;

    public ClientSettings() {
    }

    public boolean isRawMouseInput() { return rawMouseInput; }
    public void setRawMouseInput(boolean v) { rawMouseInput = v; }

    public boolean isBorderlessFullscreen() { return borderlessFullscreen; }
    public void setBorderlessFullscreen(boolean v) { borderlessFullscreen = v; }

    public boolean isDisableHotbarScroll() { return disableHotbarScroll; }
    public void setDisableHotbarScroll(boolean v) { disableHotbarScroll = v; }

    public boolean isCapeEnabled() { return capeEnabled; }
    public void setCapeEnabled(boolean v) { capeEnabled = v; }

    public int getPerformanceLevel() { return performanceLevel; }
    public void setPerformanceLevel(int v) { performanceLevel = v; }
}
