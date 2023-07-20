package com.sp2g.colorfulazaleasigns.block.sign;

import com.sp2g.colorfulazaleasigns.AzaleaSignsRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.SignBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

public class AzaleaSignBlockEntity extends SignBlockEntity {

    public AzaleaSignBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(blockPos, blockState);
    }

    @Override
    public @NotNull BlockEntityType<?> getType() {
        return AzaleaSignsRegistry.signBlockEntity.get();
    }
}
