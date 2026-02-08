package com.moreplusfps.mixin;

import net.minecraft.client.gui.screen.LevelLoadingScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LevelLoadingScreen.class)
public class LoadingScreenMixin {
    @Inject(method = "render", at = @At("HEAD"), cancellable = true)
    private void skip(CallbackInfo ci) {
        ci.cancel();
    }
}
