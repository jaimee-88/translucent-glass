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

    public static String ID = "translucent-glass";

    @Override
    public void onInitializeClient() {
        FabricLoader.getInstance().getModContainer(ID).ifPresent(container -> {
            ResourceManagerHelper.registerBuiltinResourcePack(asId("translucent-glass"), container, Text.literal("Translucent Glass"), ResourcePackActivationType.NORMAL);
        });
        BlockRenderLayerMap.INSTANCE.putBlock(Blocks.GLASS, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(Blocks.GLASS_PANE, RenderLayer.getTranslucent());
    }

    public static Identifier asId(String path) {
        return new Identifier(ID, path);
    }
}