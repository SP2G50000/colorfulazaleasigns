package com.sp2g.colorfulazaleasigns.mixin.client;

import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(BlockEntityRenderers.class)
public interface BlockEntityRenderersInvoker {
    @Invoker("register")
    static <T extends BlockEntity> void invokeRegister(BlockEntityType<? extends T> blockEntityType, BlockEntityRendererProvider<T> blockEntityRendererProvider) {
        throw new UnsupportedOperationException();
    }
}
