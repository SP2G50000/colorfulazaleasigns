package com.sp2g.colorfulazaleasigns.block.sign;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.StandingSignBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.WoodType;
import org.jetbrains.annotations.NotNull;

public class AzaleaStandingSignBlock extends StandingSignBlock {
    public AzaleaStandingSignBlock(Properties $$0, WoodType $$1) {
        super($$0, $$1);
    }

    @Override
    public BlockEntity newBlockEntity(@NotNull BlockPos blockPos, @NotNull BlockState blockState) {
        return new AzaleaSignBlockEntity(blockPos, blockState);
    }
}
