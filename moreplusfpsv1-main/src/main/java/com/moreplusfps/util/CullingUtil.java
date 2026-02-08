package com.moreplusfps.util;

import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.Entity;

public class CullingUtil {
    private static final double MAX_DISTANCE = 48.0;

    public static boolean shouldCull(Entity entity) {
        MinecraftClient mc = MinecraftClient.getInstance();
        if (mc.player == null) return false;
        if (!entity.isAlive()) return true;
        return entity.squaredDistanceTo(mc.player) > (MAX_DISTANCE * MAX_DISTANCE);
    }
}
