package com.sp2g.colorfulazaleasigns.fabric;

import com.sp2g.colorfulazaleasigns.client.ColorfulAzaleaSignsClient;
import net.fabricmc.api.ClientModInitializer;

public class ColorfulAzaleasSignsClientFabric implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ColorfulAzaleaSignsClient.init();
    }
}
