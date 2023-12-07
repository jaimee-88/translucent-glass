package barker.justin.trglass;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.api.resource.ResourcePackActivationType;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.block.Blocks;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class Main implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        FabricLoader.getInstance().getModContainer("translucent-glass").ifPresent(container -> {
            ResourceManagerHelper.registerBuiltinResourcePack(new Identifier("translucent-glass", "translucent-glass"), container, Text.literal("Translucent Glass"), ResourcePackActivationType.DEFAULT_ENABLED);
        });
        BlockRenderLayerMap.INSTANCE.putBlock(Blocks.GLASS, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(Blocks.GLASS_PANE, RenderLayer.getTranslucent());
    }
}