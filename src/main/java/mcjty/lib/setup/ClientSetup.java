package mcjty.lib.setup;

import mcjty.lib.ClientEventHandler;
import mcjty.lib.keys.KeyBindings;
import mcjty.lib.keys.KeyInputHandler;
import mcjty.lib.tooltips.TooltipRender;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

public class ClientSetup {

    public static void init(FMLClientSetupEvent e) {
        MinecraftForge.EVENT_BUS.register(new TooltipRender());
        MinecraftForge.EVENT_BUS.register(new McJtyLibBlockRegister());
        MinecraftForge.EVENT_BUS.register(new ClientEventHandler());

        // @todo 1.15
//        ModelLoaderRegistry.registerLoader(new MultipartModelLoader());
        KeyBindings.init();
        MinecraftForge.EVENT_BUS.register(new KeyInputHandler());
    }

    private static class McJtyLibBlockRegister {
        @SubscribeEvent
        public void registerModels(ModelRegistryEvent event) {
            Registration.MULTIPART_BLOCK.initModel();
        }

    }

}