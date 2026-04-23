package com.advanced.client.performance;

import net.minecraft.client.Minecraft;
import net.minecraft.world.chunk.Chunk;
import net.minecraftforge.event.world.ChunkEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ChunkLoadOptimizer {

    private final Minecraft mc = Minecraft.getMinecraft();
    private int chunksLoadedThisTick = 0;
    private static final int MAX_CHUNKS_PER_TICK = 2;

    @SubscribeEvent
    public void onChunkLoad(ChunkEvent.Load event) {
        chunksLoadedThisTick++;
    }

    @SubscribeEvent
    public void onChunkUnload(ChunkEvent.Unload event) {
        // Track unloads
    }

    public void resetTick() {
        chunksLoadedThisTick = 0;
    }

    public boolean canLoadMoreChunks() {
        return chunksLoadedThisTick < MAX_CHUNKS_PER_TICK;
    }

    public int getChunksLoadedThisTick() {
        return chunksLoadedThisTick;
    }
}
