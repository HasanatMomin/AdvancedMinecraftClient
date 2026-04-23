package com.advanced.client.mods.display;

import com.advanced.client.mods.Mod;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CpsDisplayMod extends Mod {

    private final List<Long> leftClicks = new ArrayList<>();
    private final List<Long> rightClicks = new ArrayList<>();

    public CpsDisplayMod() {
        super("cpsdisplay", "CPS Display", "🖱️");
        this.x = 2;
        this.y = 20;
    }

    @Override
    public void onRender() {
        int lCps = getCps(leftClicks);
        int rCps = getCps(rightClicks);
        String text = "CPS: " + lCps + " | " + rCps;
        getMinecraft().fontRenderer.drawStringWithShadow(text, x, y, color);
    }

    @Override
    public void onUpdate() {
        long now = System.currentTimeMillis();
        prune(leftClicks, now);
        prune(rightClicks, now);
    }

    @Override
    public void onKeyPress(int keyCode) {
    }

    public void registerClick(int button) {
        long now = System.currentTimeMillis();
        if (button == 0) leftClicks.add(now);
        else if (button == 1) rightClicks.add(now);
    }

    private int getCps(List<Long> clicks) {
        long now = System.currentTimeMillis();
        prune(clicks, now);
        return clicks.size();
    }

    private void prune(List<Long> clicks, long now) {
        Iterator<Long> it = clicks.iterator();
        while (it.hasNext()) {
            if (now - it.next() > 1000) it.remove();
        }
    }
}
