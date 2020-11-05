package com.legacy.aether.mixin;

import com.legacy.aether.util.MapDimensionData;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.network.packet.s2c.play.MapUpdateS2CPacket;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MapUpdateS2CPacket.class)
public class MixinUpdateClientPacket implements MapDimensionData {

    private RegistryKey<World> dimension;

    @Inject(method = "read", at = @At("RETURN"))
    public void readDimensionData(PacketByteBuf buf, CallbackInfo ci) {
//        this.dimension = DimensionType.id(buf.readInt());
        //TODO: migrate to new dim system
    }

    @Inject(method = "write", at = @At("RETURN"))
    public void writeDimensionData(PacketByteBuf buf, CallbackInfo ci) {
//        buf.writeInt(this.dimension.getRawId());
//        TODO: same todo as above
    }

    @Override
    public RegistryKey<World> getDimension() {
        return this.dimension;
    }

    @Override
    public void setDimension(RegistryKey<World> dimension) {
        this.dimension = dimension;
    }

}