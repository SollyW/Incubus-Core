package net.id.incubus_core;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.BlockEntityRendererRegistry;
import net.id.incubus_core.render.HardBloomShaderManager;
import net.id.incubus_core.render.RenderTestBlockEntityRenderer;
import net.id.incubus_core.render.SoftBloomShaderManager;
import net.minecraft.client.render.RenderLayer;

public class IncubusCoreClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        BlockEntityRendererRegistry.register(IncubusCore.RENDER_TEST_BLOCK_ENTITY_TYPE, context -> new RenderTestBlockEntityRenderer());
        HardBloomShaderManager.init();
        SoftBloomShaderManager.init();


        BlockRenderLayerMap.INSTANCE.putBlock(IncubusCore.RENDER_TEST_BLOCK, RenderLayer.getTranslucent());
    }
}
