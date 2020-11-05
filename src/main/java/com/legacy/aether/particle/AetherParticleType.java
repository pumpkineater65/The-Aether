package com.legacy.aether.particle;

import com.mojang.brigadier.StringReader;
import com.mojang.serialization.Codec;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleType;
import net.minecraft.util.registry.Registry;

public class AetherParticleType extends ParticleType<AetherParticleType> implements ParticleEffect {

    private static final ParticleEffect.Factory<AetherParticleType> PARAMETER_FACTORY = new ParticleEffect.Factory<AetherParticleType>() {

        @Override
        public AetherParticleType read(ParticleType<AetherParticleType> particleType, StringReader var2) {
            return (AetherParticleType) particleType;
        }

        @Override
        public AetherParticleType read(ParticleType<AetherParticleType> particleType, PacketByteBuf var2) {
            return (AetherParticleType) particleType;
        }

    };

    private final Codec<AetherParticleType> codec = Codec.unit(this::getType);

    public AetherParticleType(boolean alwaysSpawn) {
        super(alwaysSpawn, PARAMETER_FACTORY);
    }

    @Override
    public AetherParticleType getType() {
        return this;
    }

    @Override
    public void write(PacketByteBuf var1) {
    }

    @Override
    public String asString() {
        return Registry.PARTICLE_TYPE.getId(this).toString();
    }

    @Override
    public Codec<AetherParticleType> getCodec() {
        return codec;
    }
}
