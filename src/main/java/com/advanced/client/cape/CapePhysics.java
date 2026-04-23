package com.advanced.client.cape;

import net.minecraft.entity.player.EntityPlayer;

public class CapePhysics {

    private float capeMotionX = 0.0f;
    private float capeMotionY = 0.0f;
    private float capeMotionZ = 0.0f;
    private float prevCapeX = 0.0f;
    private float prevCapeY = 0.0f;
    private float prevCapeZ = 0.0f;
    private float capeX = 0.0f;
    private float capeY = 0.0f;
    private float capeZ = 0.0f;

    public void update(EntityPlayer player) {
        prevCapeX = capeX;
        prevCapeY = capeY;
        prevCapeZ = capeZ;

        double dx = player.posX - capeX;
        double dy = player.posY - capeY;
        double dz = player.posZ - capeZ;

        double dist = Math.sqrt(dx * dx + dy * dy + dz * dz);
        if (dist > 10.0) {
            capeX = (float) player.posX;
            capeY = (float) player.posY;
            capeZ = (float) player.posZ;
        } else {
            capeMotionX += (float)(dx * 0.1);
            capeMotionY += (float)(dy * 0.1);
            capeMotionZ += (float)(dz * 0.1);
            capeMotionX *= 0.8f;
            capeMotionY *= 0.8f;
            capeMotionZ *= 0.8f;
            capeX += capeMotionX;
            capeY += capeMotionY;
            capeZ += capeMotionZ;
        }
    }

    public float getCapeX() { return capeX; }
    public float getCapeY() { return capeY; }
    public float getCapeZ() { return capeZ; }
    public float getPrevCapeX() { return prevCapeX; }
    public float getPrevCapeY() { return prevCapeY; }
    public float getPrevCapeZ() { return prevCapeZ; }
}
