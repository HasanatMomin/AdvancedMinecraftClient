package com.advanced.client.gui.animation;

public class Animation {

    private float start;
    private float end;
    private float current;
    private long startTime;
    private long duration;
    private EasingFunction easing;
    private boolean finished;

    public Animation(float start, float end, long durationMs, EasingFunction easing) {
        this.start = start;
        this.end = end;
        this.current = start;
        this.duration = durationMs;
        this.easing = easing;
        this.startTime = System.currentTimeMillis();
        this.finished = false;
    }

    public float getValue() {
        long elapsed = System.currentTimeMillis() - startTime;
        if (elapsed >= duration) {
            finished = true;
            current = end;
            return end;
        }
        float t = (float) elapsed / duration;
        current = start + (end - start) * easing.ease(t);
        return current;
    }

    public boolean isFinished() {
        getValue();
        return finished;
    }

    public void reset(float newStart, float newEnd) {
        this.start = newStart;
        this.end = newEnd;
        this.current = newStart;
        this.startTime = System.currentTimeMillis();
        this.finished = false;
    }

    public float getCurrent() { return current; }
    public float getEnd() { return end; }
}
