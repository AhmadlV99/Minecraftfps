package com.moreplusfps.mixin;

import com.moreplusfps.util.CullingUtil;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(EntityRenderDispatcher.class)
public class EntityCullingMixin {
    @Inject(method = "render", at = @At("HEAD"), cancellable = true)
    private void cull(Entity entity, double x, double y, double z, float yaw, float tickDelta,
                      MatrixStack matrices, VertexConsumerProvider consumers, int light, CallbackInfo ci) {
        if (CullingUtil.shouldCull(entity)) ci.cancel();
    }
}
