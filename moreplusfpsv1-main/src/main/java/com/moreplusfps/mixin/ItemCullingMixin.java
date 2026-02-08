package com.moreplusfps.mixin;

import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.ItemEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.ItemEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ItemEntityRenderer.class)
public class ItemCullingMixin {
    @Inject(method = "render", at = @At("HEAD"), cancellable = true)
    private void cull(ItemEntity entity, float yaw, float tickDelta,
                      MatrixStack matrices, VertexConsumerProvider consumers, int light, CallbackInfo ci) {
        if (entity.age > 20) ci.cancel();
    }
}
