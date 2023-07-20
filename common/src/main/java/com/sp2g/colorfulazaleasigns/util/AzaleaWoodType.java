package com.sp2g.colorfulazaleasigns.util;

import com.sp2g.colorfulazaleasigns.mixin.WoodTypeInvoker;
import net.minecraft.world.level.block.state.properties.WoodType;

public class AzaleaWoodType extends WoodType {

    public enum AzaleaWoodTypes {
        tecal("tecal_azalea"),
        fiss("fiss_azalea"),
        roze("roze_azalea"),
        azule("azule_azalea"),
        bright("bright_azalea"),
        walnut("walnut_azalea"),
        titanium("titanium_azalea");

        final String name;
        final WoodType woodType;

        AzaleaWoodTypes(String name) {
            this.name = name;
            this.woodType = WoodTypeInvoker.invokeRegister(new AzaleaWoodType(name));
        }

        public String getName() { return name; }

        public WoodType getWoodType() { return woodType; }
    }

    protected AzaleaWoodType(String woodType) {
        super(woodType);
    }
}
