package com.aether.blocks.natural;

import com.aether.entities.util.RenderUtils;
import com.aether.util.DynamicBlockColorProvider;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.color.block.BlockColor;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Vec3i;
import net.minecraft.util.Mth;
import net.minecraft.world.level.levelgen.WorldgenRandom;
import net.minecraft.world.level.levelgen.synth.ImprovedNoise;

public class AuralLeavesBlock extends AetherLeavesBlock implements DynamicBlockColorProvider {

    private final Vec3i[] gradientColors;

    public AuralLeavesBlock(Properties settings, boolean collidable, Vec3i[] gradientColors) {
        super(settings, collidable);
        if(gradientColors.length != 4) {
            throw new InstantiationError("color gradient must contain exactly four colors");
        }
        this.gradientColors = gradientColors;
    }

    @Override
    @Environment(EnvType.CLIENT)
    public BlockColor getProvider() {
        return (state, world, pos, tintIndex) -> getAuralColor(pos, gradientColors);
    }

    public static int getAuralColor(BlockPos pos, Vec3i[] gradientCols){
        float clumpSize = 12;
        // TODO: Verify ChunkRandom calls in 1.17
        ImprovedNoise perlin = new ImprovedNoise(new WorldgenRandom(1738));
        // sample perlin noise
        double percent = 0.5 * (1 + perlin.noise(pos.getX()/clumpSize,pos.getY()/clumpSize,pos.getZ()/clumpSize,4000,0));
        double contrast = 12;
        // reshape contrast curve
        double finalpercent1 = Mth.clamp((1 - Math.exp(-contrast*percent)) * (1 + Math.exp(-contrast/2))/(1 + Math.exp(-contrast * (percent - 0.5)))/(1 - Math.exp(-contrast)),0,1);
        Vec3i color1 = gradientCols[0];
        Vec3i color2 = gradientCols[1];
        // interpolate
        int r1,g1,b1;
        r1 = (int) (Mth.lerp(finalpercent1*(2-finalpercent1), color1.getX(), color2.getX()));
        g1 = (int) (Mth.lerp(finalpercent1*(2-finalpercent1), color1.getY(), color2.getY()));
        b1 = (int) (Mth.lerp(finalpercent1*(2-finalpercent1), color1.getZ(), color2.getZ()));

        // rinse, repeat.
        perlin = new ImprovedNoise(new WorldgenRandom(1337));
        double percent2 = Mth.clamp(0.5 * (1 + perlin.noise(pos.getX()/clumpSize,pos.getY()/clumpSize,pos.getZ()/clumpSize,4000,0)),0,1);
        Vec3i color3 = gradientCols[2];
        Vec3i color4 = gradientCols[3];
        // this time, we don't need to reshape the contrast curve.
        // interpolate
        int r2,g2,b2;
        r2 = (int) (Mth.lerp(percent2*(2-percent2), color3.getX(), color4.getX()));
        g2 = (int) (Mth.lerp(percent2*(2-percent2), color3.getY(), color4.getY()));
        b2 = (int) (Mth.lerp(percent2*(2-percent2), color3.getZ(), color4.getZ()));

        // This last section interpolates between r1, g1, b1, and r2, g2, b2. Makes the patches of green.
        perlin = new ImprovedNoise(new WorldgenRandom(9980));
        double percent3 = 0.5 * (1 + perlin.noise(pos.getX()/clumpSize,pos.getY()/clumpSize,pos.getZ()/clumpSize,4000,0));
        contrast = 13.3;
        double finalpercent3 = Mth.clamp((1 - Math.exp(-contrast*percent3)) * (1 + Math.exp(-contrast/2))/(1 + Math.exp(-contrast * (percent3 - 0.5)))/(1 - Math.exp(-contrast)),0,1);
        return RenderUtils.toHex(r2 + (int) (finalpercent3 * (r1 - r2)), g2 + (int) (finalpercent3 * (g1 - g2)), b2 + (int) (finalpercent3 * (b1 - b2)));
    }
}
