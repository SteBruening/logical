package de.stebruening.logical;

import de.stebruening.logical.registry.RegisterBlocks;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;

public class LogicalClient implements ClientModInitializer
{

    @Override
    public void onInitializeClient()
    {
        BlockRenderLayerMap.INSTANCE.putBlock(RegisterBlocks.LOGIC_CABLE, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(RegisterBlocks.LOGIC_CABLE_INTERFACE, RenderLayer.getTranslucent());
    }
}
