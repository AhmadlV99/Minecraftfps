package com.moreplusfps.mixin;

import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ParticleManager.class)
public class ParticleDisableMixin {

    @Inject(method = "addParticle(Lnet/minecraft/client/particle/Particle;)V", at = @At("HEAD"), cancellable = true)
    private void moreplusfps$disableParticles(Particle particle, CallbackInfo ci) {
        // Hard-disable ALL particles for maximum FPS
        ci.cancel();
    }
}