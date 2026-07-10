package com.rainforestkongra.client;

import com.rainforestkongra.registry.ModEntities;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.entity.GiantEntityRenderer;
import net.minecraft.client.render.entity.OcelotEntityRenderer;
import net.minecraft.client.render.entity.ParrotEntityRenderer;

public class RainforestKongraClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(ModEntities.KONGRA, GiantEntityRenderer::new);
        EntityRendererRegistry.register(ModEntities.JAGUAR, OcelotEntityRenderer::new);
        EntityRendererRegistry.register(ModEntities.MACAW, ParrotEntityRenderer::new);
    }
}