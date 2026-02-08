package com.moreplusfps;

import net.fabricmc.api.ClientClientModInitializer;

public class MorePlusFPS implements ClientClientModInitializer {
    @Override
    public void onInitializeClient() {
        System.out.println("[MorePlusFPS] Client Loaded");
    }
}
