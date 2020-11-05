package com.legacy.aether.player;

import com.legacy.aether.api.player.IPlayerAether;
import com.legacy.aether.api.player.util.AccessoryInventory;
import com.legacy.aether.api.player.util.AetherAbility;
import com.legacy.aether.entities.util.AetherPoisonMovement;
import com.legacy.aether.inventory.AccessoriesInventory;
import com.legacy.aether.item.tool.IAetherTool;
import com.legacy.aether.item.util.AetherTier;
import com.legacy.aether.player.abilities.FloatAbility;
import com.legacy.aether.player.abilities.JumpBoostAbility;
import com.legacy.aether.player.abilities.StepHeightAbility;
import com.legacy.aether.player.perks.AetherDonationPerks;
//import com.legacy.aether.util.AetherTeleportation;
//import com.legacy.aether.world.TeleporterAether;
//import com.legacy.aether.world.WorldAether;
import net.minecraft.entity.Entity;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.UUID;

public class PlayerAether implements IPlayerAether {

    public final ArrayList<AetherAbility> abilities = new ArrayList<>();
    public final ArrayList<Entity> clouds = new ArrayList<>(2);
    private final AccessoryInventory accessories;
    public float prevPortalAnimTime, portalAnimTime;

    public int timeInPortal;

    public boolean hasTeleported = false, inPortal = false;
    public AetherDonationPerks donationPerks;
    private PlayerEntity player;
    private int shardsUsed;
    private boolean isJumping;
    private EntityAttributeModifier aetherHealth;
    private AetherPoisonMovement poisonMovement;

    public PlayerAether(PlayerEntity player) {
        this.player = player;
        this.donationPerks = new AetherDonationPerks();
        this.poisonMovement = new AetherPoisonMovement(player);
        this.accessories = new AccessoriesInventory(this);

        this.abilities.addAll(Arrays.asList(new FloatAbility(this), new JumpBoostAbility(this), new StepHeightAbility(this)));
    }

    public void tick() {
        for (AetherAbility ability : this.abilities) {
            if (ability.shouldExecute()) {
                ability.update();
            }
        }

        for (int i = 0; i < this.clouds.size(); ++i) {
            Entity entity = this.clouds.get(i);

            if (entity.removed) {
                this.clouds.remove(i);
            }
        }

        //this.updateReach();
        //this.poisonMovement.tick();

        /*if (this.getPlayer().world.getRegistryKey() == WorldAether.THE_AETHER && this.getPlayer().getY() <= -10.0F) {
            this.teleportPlayer(false);
        }*/

        if (this.getPlayer().world.isClient) {
            this.prevPortalAnimTime = this.portalAnimTime;

            if (this.inPortal) {
                this.portalAnimTime += 0.0125F;
                this.inPortal = false;
            } else {
                if (this.portalAnimTime > 0.0F) {
                    this.portalAnimTime -= 0.05F;
                }

                if (this.portalAnimTime < 0.0F) {
                    this.portalAnimTime = 0.0F;
                }
            }
        } else {
            /*if (this.inPortal && this.player.netherPortalCooldown <= 0) {
                int limit = 80;

                if (this.timeInPortal++ >= limit) {
                    this.timeInPortal = limit;
                    this.player.netherPortalCooldown = this.player.getDefaultNetherPortalCooldown();
                    this.teleportPlayer(true);
                }

                this.inPortal = false;
            } else {
                if (this.timeInPortal > 0) {
                    this.timeInPortal -= 4;
                }

                if (this.timeInPortal < 0) {
                    this.timeInPortal = 0;
                }

                if (this.player.netherPortalCooldown > 0) {
                    --this.player.netherPortalCooldown;
                }
            }*/
        }
    }

    @Override
    public boolean disableFallDamage() {
        boolean check = false;

        for (AetherAbility aetherAbility : this.abilities) {
            if (check) {
                break;
            }

            check = aetherAbility.shouldExecute() && aetherAbility.disableFallDamage();
        }

        return check;
    }

    public float setReachDistance(float distance) {
        ItemStack stack = this.getPlayer().getMainHandStack();

        if (stack.getItem() instanceof IAetherTool && ((IAetherTool) stack.getItem()).getItemMaterial() == AetherTier.Valkyrie) {
            return 10.0F;
        }

        return distance;
    }

    /*
     * The teleporter which sends the player to the Aether/Overworld
     */
    private void teleportPlayer(boolean shouldSpawnPortal) {
        if (!this.player.world.isClient) {
            MinecraftServer server = this.player.getServer();
            //RegistryKey<World> dimensionToTravel = this.player.world.getRegistryKey() == WorldAether.THE_AETHER ? World.OVERWORLD : WorldAether.THE_AETHER;

            if (server != null) {
                //AetherTeleportation.instance().teleportPlayer((ServerPlayerEntity) this.player, this.player.getServer(), dimensionToTravel, new TeleporterAether(shouldSpawnPortal, server.getWorld(dimensionToTravel)));
            }
        }
    }

    @Override
    public void increaseHealth(int amount) {
        UUID uuid = UUID.fromString("df6eabe7-6947-4a56-9099-002f90370706");

        this.shardsUsed += amount;

        this.aetherHealth = new EntityAttributeModifier(uuid, "Aether Health Modifier", (this.shardsUsed * 2.0), EntityAttributeModifier.Operation.ADDITION);

        if (this.getPlayer().getAttributeInstance(EntityAttributes.GENERIC_MAX_HEALTH).getModifier(uuid) != null) {
            this.getPlayer().getAttributeInstance(EntityAttributes.GENERIC_MAX_HEALTH).removeModifier(this.aetherHealth);
        }

        this.getPlayer().getAttributeInstance(EntityAttributes.GENERIC_MAX_HEALTH).addTemporaryModifier(this.aetherHealth);
    }

    public void writeToNBT(CompoundTag compound) {
        compound.putInt("shardsUsed", this.shardsUsed);

        compound.put("accessories", this.accessories.serialize(new CompoundTag()));
    }

    public void readFromNBT(CompoundTag compound) {
        this.shardsUsed = compound.getInt("shardsUsed");

        this.accessories.deserialize(compound.getCompound("accessories"));
    }

    public void copyFrom(PlayerAether that, boolean keepEverything) {
        CompoundTag compound = new CompoundTag();

        that.writeToNBT(compound);
        this.readFromNBT(compound);
    }

    public void damageAccessories(float damage) {
        // TODO: ???
		/*for (int i = 0; i < this.accessories.getInvSize(); ++i)
		{
			ItemStack stack = this.accessories.getInventory().get(i);

			if (!stack.isEmpty())
			{
				stack.damage((int) damage, new Random(this.getPlayer().world.getSeed()), (ServerPlayerEntity) this.getPlayer());
			}
		}*/
    }

    public void inflictCure(int ticks) {
        this.poisonMovement.applyCure(ticks);
    }

    public void inflictPoison(int ticks) {
        this.poisonMovement.inflictPoison(ticks);
    }

    @Override
    public void setInPortal() {
        /*if (this.player.netherPortalCooldown > 0) {
            this.player.netherPortalCooldown = this.player.getDefaultNetherPortalCooldown();
        } else {
            this.inPortal = true;
        }*/
    }

    public boolean isJumping() {
        return this.isJumping;
    }

    public void setJumping(boolean isJumping) {
        this.isJumping = isJumping;
    }

    public int getShardsUsed() {
        return this.shardsUsed;
    }

    @Override
    public AccessoryInventory getAccessoryInventory() {
        return this.accessories;
    }

    @Override
    public PlayerEntity getPlayer() {
        return this.player;
    }

}