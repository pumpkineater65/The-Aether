package com.legacy.aether.item.tool;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.legacy.aether.item.AetherItemGroup;
import com.legacy.aether.item.util.AetherTier;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.HoeItem;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Rarity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;

import java.util.Map;

public class ItemAetherHoe extends HoeItem implements IAetherTool {

    protected static final Map<Block, BlockState> convertableBlocks = Maps.newHashMap(ImmutableMap.of(/*BlocksAether.aether_grass, BlocksAether.aether_farmland.getDefaultState(), BlocksAether.aether_grass_path, BlocksAether.aether_farmland.getDefaultState(), BlocksAether.aether_dirt, BlocksAether.aether_farmland.getDefaultState(), */Blocks.GRASS_BLOCK, Blocks.FARMLAND.getDefaultState(), Blocks.GRASS_PATH, Blocks.FARMLAND.getDefaultState(), Blocks.DIRT, Blocks.FARMLAND.getDefaultState(), Blocks.COARSE_DIRT, Blocks.DIRT.getDefaultState()));

    private AetherTier material;

    public ItemAetherHoe(AetherTier material, int attackDamage, float attackSpeed) {
        super(material.getDefaultTier(), attackDamage, attackSpeed, new Settings().group(AetherItemGroup.AETHER_TOOLS));

        this.material = material;
    }

    public ItemAetherHoe(AetherTier material, Rarity rarity, int attackDamage, float attackSpeed) {
        super(material.getDefaultTier(), attackDamage, attackSpeed, new Settings().group(AetherItemGroup.AETHER_TOOLS).rarity(rarity));

        this.material = material;
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        BlockPos blockpos = context.getBlockPos();

        if (context.getSide() != Direction.DOWN && world.isAir(blockpos.up())) {
            BlockState iblockstate = convertableBlocks.get(world.getBlockState(blockpos).getBlock());

            if (iblockstate != null) {
                PlayerEntity entityplayer = context.getPlayer();

                world.playSound(entityplayer, blockpos, SoundEvents.ITEM_HOE_TILL, SoundCategory.BLOCKS, 1.0F, 1.0F);

                if (!world.isClient) {
                    world.setBlockState(blockpos, iblockstate, 11);

                    if (entityplayer != null) {
                        context.getStack().damage(1, entityplayer, null);
                    }
                }

                return ActionResult.SUCCESS;
            }
        }

        return ActionResult.PASS;
    }

    @Override
    public AetherTier getItemMaterial() {
        return this.material;
    }

}