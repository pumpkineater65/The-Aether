package com.legacy.aether.entities.passive;

import com.legacy.aether.entities.EntityTypesAether;
import com.legacy.aether.entities.util.EntitySaddleMount;
import com.legacy.aether.item.ItemsAether;
import com.legacy.aether.sounds.SoundsAether;
//import com.legacy.aether.world.storage.loot.AetherLootTableList;
import net.minecraft.block.BlockState;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.recipe.Ingredient;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class EntityPhyg extends EntitySaddleMount {

    public float wingFold;

    public float wingAngle;
    public int maxJumps;
    public int jumpsRemaining;
    public int ticks;
    private float aimingForFold;

    public EntityPhyg(World world) {
        super(EntityTypesAether.PHYG, world);

        this.jumpsRemaining = 0;
        this.maxJumps = 1;
        this.stepHeight = 1.0F;

        this.ignoreCameraFrustum = true;
        this.canJumpMidAir = true;
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(0, new SwimGoal(this));
        this.goalSelector.add(1, new EscapeDangerGoal(this, 1.25D));
        this.goalSelector.add(2, new AnimalMateGoal(this, 1.0D));
        this.goalSelector.add(3, new TemptGoal(this, 1.25D, Ingredient.ofItems(ItemsAether.blueberry), false));
        this.goalSelector.add(4, new LookAtEntityGoal(this, PlayerEntity.class, 6.0F));
        this.goalSelector.add(5, new LookAroundGoal(this));
        this.goalSelector.add(5, new FollowParentGoal(this, 1.1D));
        this.goalSelector.add(6, new WanderAroundFarGoal(this, 1.0D));
    }

    @Override
    protected void initAttributes() {
        this.getAttributeInstance(EntityAttributes.GENERIC_MAX_HEALTH).setBaseValue(10.0D);
        this.getAttributeInstance(EntityAttributes.GENERIC_MOVEMENT_SPEED).setBaseValue(0.25D);

        if (this.getSaddled()) {
            this.getAttributeInstance(EntityAttributes.GENERIC_MAX_HEALTH).setBaseValue(20.0D);
            this.setHealth(20);
        }
    }

    @Override
    public void tick() {
        super.tick();

        if (this.onGround) {
            this.wingAngle *= 0.8F;
            this.aimingForFold = 0.1F;
            this.jumpsRemaining = this.maxJumps;
        } else {
            this.aimingForFold = 1.0F;
        }

        this.ticks++;

        this.wingAngle = this.wingFold * (float) Math.sin(this.ticks / 31.83098862F);
        this.wingFold += (this.aimingForFold - this.wingFold) / 5F;
        this.fallDistance = 0;
        this.fall();
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundsAether.phyg_death;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundsAether.phyg_hurt;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundsAether.phyg_say;
    }

    @Override
    public double getMountedHeightOffset() {
        return 0.65D;
    }

    @Override
    public float getMountedMoveSpeed() {
        return 0.3F;
    }

    @Override
    public void setJumping(boolean jump) {
        super.setJumping(jump);
    }

    private void fall() {
        if (this.getVelocity().y < 0.0D && !this.isSneaking()) {
            this.setVelocity(this.getVelocity().multiply(1.0D, 0.6D, 1.0D));
        }

        if (!this.onGround && !this.firstUpdate) {
            if (this.onGround && !this.world.isClient) {
                this.jumpsRemaining = this.maxJumps;
            }
        }
    }

    @Override
    protected double getMountJumpStrength() {
        return 5.0D;
    }

    @Override
    protected void playStepSound(BlockPos pos, BlockState par4) {
        this.world.playSound(null, this.getX(), this.getY(), this.getZ(), SoundEvents.ENTITY_PIG_STEP, SoundCategory.NEUTRAL, 0.15F, 1.0F);
    }

    @Override
    public void readCustomDataFromTag(CompoundTag compound) {
        super.readCustomDataFromTag(compound);

        this.maxJumps = compound.getInt("maxJumps");
        this.jumpsRemaining = compound.getInt("remainingJumps");
    }

    @Override
    public void writeCustomDataToTag(CompoundTag compound) {
        super.writeCustomDataToTag(compound);

        compound.putInt("maxJumps", this.maxJumps);
        compound.putInt("remainingJumps", this.jumpsRemaining);
    }

    @Override
    public PassiveEntity createChild(ServerWorld world, PassiveEntity entityageable) {
        return new EntityPhyg(this.world);
    }

    @Override
    public Identifier getLootTableId()
    {
        return null;//AetherLootTableList.ENTITIES_PHYG;
    }

}