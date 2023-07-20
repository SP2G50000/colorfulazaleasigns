package com.sp2g.colorfulazaleasigns;

import com.google.common.base.Suppliers;
import com.sp2g.colorfulazaleasigns.block.sign.AzaleaSignBlockEntity;
import com.sp2g.colorfulazaleasigns.block.sign.AzaleaStandingSignBlock;
import com.sp2g.colorfulazaleasigns.block.sign.AzaleaWallSignBlock;
import com.sp2g.colorfulazaleasigns.util.AzaleaWoodType;
import dev.architectury.registry.CreativeTabRegistry;
import dev.architectury.registry.registries.Registrar;
import dev.architectury.registry.registries.Registries;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.WoodType;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class AzaleaSignsRegistry {
    public static final Supplier<Registries> REGISTRIES = Suppliers.memoize(() -> Registries.get(ColorfulAzaleaSigns.MOD_ID));
    public static Registrar<Item> itemRegistrar;
    public static Registrar<Block> blockRegistrar;
    public static Registrar<BlockEntityType<?>> blockEntityTypesRegistrar;

    public static CreativeModeTab creativeModeTab;
    public static RegistrySupplier<Item> creativeTabIcon;

    public static List<RegistrySupplier<Block>> signs;

    public static RegistrySupplier<BlockEntityType<AzaleaSignBlockEntity>> signBlockEntity;

    public static void init() {
        itemRegistrar = REGISTRIES.get().get(Registry.ITEM_REGISTRY);
        blockRegistrar = REGISTRIES.get().get(Registry.BLOCK_REGISTRY);
        blockEntityTypesRegistrar = REGISTRIES.get().get(Registry.BLOCK_ENTITY_TYPE_REGISTRY);

        creativeModeTab = CreativeTabRegistry.create(new ResourceLocation(ColorfulAzaleaSigns.MOD_ID, "azalea_sign_tab"), () -> new ItemStack(creativeTabIcon.get()));

        signs = new ArrayList<>();

        for (int i = 0; i < AzaleaWoodType.AzaleaWoodTypes.values().length; i++) {
            String name = AzaleaWoodType.AzaleaWoodTypes.values()[i].getName();
            WoodType woodType = AzaleaWoodType.AzaleaWoodTypes.values()[i].getWoodType();

            RegistrySupplier<Block> signBlock = blockRegistrar.register(new ResourceLocation(ColorfulAzaleaSigns.MOD_ID, name + "_sign"),
                    () -> new AzaleaStandingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SIGN), woodType));
            RegistrySupplier<Block> wallSignBlock = blockRegistrar.register(new ResourceLocation(ColorfulAzaleaSigns.MOD_ID, name + "_wall_sign"),
                    () -> new AzaleaWallSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SIGN), woodType));
            signs.add(signBlock);
            signs.add(wallSignBlock);

            RegistrySupplier<Item> signItem = itemRegistrar.register(new ResourceLocation(ColorfulAzaleaSigns.MOD_ID, name + "_sign"),
                    () -> new SignItem(new Item.Properties().tab(creativeModeTab), signBlock.get(), wallSignBlock.get()));
            if (i == 3) {
                creativeTabIcon = signItem;
            }
        }

        signBlockEntity = blockEntityTypesRegistrar.register(new ResourceLocation(ColorfulAzaleaSigns.MOD_ID, "sign"),
                () -> BlockEntityType.Builder.of(AzaleaSignBlockEntity::new, signs.stream().map(RegistrySupplier::get).toArray(Block[]::new)).build(null));
    }
}
