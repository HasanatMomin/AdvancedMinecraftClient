package com.advanced.client.gui.animation;

public abstract class Animation {

    protected long startTime;
    protected long duration;

    public Animation(long duration) {
        this.duration = duration;
        this.startTime = System.currentTimeMillis();
    }

    public float getProgress() {
        long elapsed = System.currentTimeMillis() - startTime;
        return Math.min(1.0f, (float) elapsed / duration);
    }

    public boolean isFinished() {
        return getProgress() >= 1.0f;
    }

    public void reset() {
        this.startTime = System.currentTimeMillis();
    }

    public abstract void update();
}
