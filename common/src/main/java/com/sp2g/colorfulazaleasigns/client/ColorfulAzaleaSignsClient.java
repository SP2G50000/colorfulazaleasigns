package com.sp2g.colorfulazaleasigns.client;

import com.sp2g.colorfulazaleasigns.AzaleaSignsRegistry;
import com.sp2g.colorfulazaleasigns.ColorfulAzaleaSigns;
import com.sp2g.colorfulazaleasigns.mixin.client.BlockEntityRenderersInvoker;
import com.sp2g.colorfulazaleasigns.util.AzaleaWoodType;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.blockentity.SignRenderer;
import net.minecraft.client.resources.model.Material;
import net.minecraft.resources.ResourceLocation;

public class ColorfulAzaleaSignsClient {
    public static final String SIGN_RES_PREFIX = "entity/signs/";
    public static void init() {
        BlockEntityRenderersInvoker.invokeRegister(AzaleaSignsRegistry.signBlockEntity.get(), SignRenderer::new);

        for (AzaleaWoodType.AzaleaWoodTypes type : AzaleaWoodType.AzaleaWoodTypes.values()) {
            Sheets.SIGN_MATERIALS.put(type.getWoodType(), new Material(Sheets.SIGN_SHEET, new ResourceLocation(ColorfulAzaleaSigns.MOD_ID, SIGN_RES_PREFIX + type.getName())));
        }
    }
}
