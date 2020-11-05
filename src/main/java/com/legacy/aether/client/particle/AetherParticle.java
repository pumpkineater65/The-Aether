package com.legacy.aether.client.particle;

import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleTextureSheet;
import net.minecraft.client.render.Camera;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.world.World;

public class AetherParticle extends Particle {

    public AetherParticle(ClientWorld worldIn, double posXIn, double posYIn, double posZIn) {
        super(worldIn, posXIn, posYIn, posZIn);
    }

    public AetherParticle(ClientWorld worldIn, double xCoordIn, double yCoordIn, double zCoordIn, double xSpeedIn, double ySpeedIn, double zSpeedIn) {
        super(worldIn, xCoordIn, yCoordIn, zCoordIn, xSpeedIn, ySpeedIn, zSpeedIn);
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    public double getZ() {
        return this.z;
    }

    public double getMotionX() {
        return this.velocityX;
    }

    public void setMotionX(double motionX) {
        this.velocityX = motionX;
    }

    public double getMotionY() {
        return this.velocityY;
    }

    public void setMotionY(double motionY) {
        this.velocityY = motionY;
    }

    public double getMotionZ() {
        return this.velocityZ;
    }

    public void setMotionZ(double motionZ) {
        this.velocityZ = motionZ;
    }

    @Override
    public void buildGeometry(VertexConsumer builder, Camera camera, float var3) {

    }

    @Override
    public ParticleTextureSheet getType() {
        return ParticleTextureSheet.PARTICLE_SHEET_OPAQUE;
    }

}