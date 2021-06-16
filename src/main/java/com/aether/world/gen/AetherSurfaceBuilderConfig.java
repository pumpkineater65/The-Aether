package com.aether.world.gen;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.PrimitiveCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.surfacebuilders.SurfaceBuilderConfiguration;

public class AetherSurfaceBuilderConfig implements SurfaceBuilderConfiguration {
    public static final Codec<AetherSurfaceBuilderConfig> CODEC = RecordCodecBuilder.create((instance) -> instance.group(BlockState.CODEC.fieldOf("top_material")
            .forGetter(config -> config.topMaterial), BlockState.CODEC.fieldOf("under_material")
            .forGetter(config -> config.underMaterial), BlockState.CODEC.fieldOf("underwater_material")
            .forGetter(config -> config.underwaterMaterial), PrimitiveCodec.BOOL.fieldOf("generate_quick_soil")
            .forGetter(config -> config.generateQuickSoil)).apply(instance, AetherSurfaceBuilderConfig::new));

    private final BlockState topMaterial;
    private final BlockState underMaterial;
    private final BlockState underwaterMaterial;
    private final boolean generateQuickSoil;

    public AetherSurfaceBuilderConfig(BlockState topMaterial, BlockState underMaterial, BlockState underwaterMaterial, boolean generateQuickSoil) {
        this.topMaterial = topMaterial;
        this.underMaterial = underMaterial;
        this.underwaterMaterial = underwaterMaterial;
        this.generateQuickSoil = generateQuickSoil;
    }

    @Override
    public BlockState getTopMaterial() {
        return this.topMaterial;
    }

    @Override
    public BlockState getUnderMaterial() {
        return this.underMaterial;
    }

    public BlockState getUnderwaterMaterial() {
        return this.underwaterMaterial;
    }

    public boolean shouldGenerateQuicksoil() {
        return this.generateQuickSoil;
    }
}
