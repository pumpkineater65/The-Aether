package com.legacy.aether.util;

import net.minecraft.client.particle.ParticleFactory;
import net.minecraft.client.particle.SpriteProvider;
import net.minecraft.particle.ParticleEffect;

public interface AetherParticleFactory<T extends ParticleEffect> {

    ParticleFactory<T> create(SpriteProvider provider);

}