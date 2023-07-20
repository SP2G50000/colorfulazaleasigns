package com.sp2g.colorfulazaleasigns.forge;

import com.sp2g.colorfulazaleasigns.client.ColorfulAzaleaSignsClient;
import dev.architectury.platform.forge.EventBuses;
import com.sp2g.colorfulazaleasigns.ColorfulAzaleaSigns;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(ColorfulAzaleaSigns.MOD_ID)
public class ColorfulAzaleaSignsForge {
    public ColorfulAzaleaSignsForge() {
		// Submit our event bus to let architectury register our content on the right time
        EventBuses.registerModEventBus(ColorfulAzaleaSigns.MOD_ID, FMLJavaModLoadingContext.get().getModEventBus());
        ColorfulAzaleaSigns.init();
        FMLJavaModLoadingContext.get().getModEventBus().addListener((FMLClientSetupEvent event) -> ColorfulAzaleaSignsClient.init());
    }
}