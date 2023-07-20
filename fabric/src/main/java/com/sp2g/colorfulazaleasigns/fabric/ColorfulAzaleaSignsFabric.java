package com.sp2g.colorfulazaleasigns.fabric;

import com.sp2g.colorfulazaleasigns.ColorfulAzaleaSigns;
import net.fabricmc.api.ModInitializer;

public class ColorfulAzaleaSignsFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        ColorfulAzaleaSigns.init();
    }
}