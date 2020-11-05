package com.legacy.aether.item.material;

import com.legacy.aether.blocks.BlocksAether;
import com.legacy.aether.item.AetherItemGroup;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class ItemAmbrosiumShard extends Item {

    public ItemAmbrosiumShard() {
        super(new Settings().group(AetherItemGroup.AETHER_MATERIALS));
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        if (context.getWorld().getBlockState(context.getBlockPos()).getBlock() == BlocksAether.aether_grass) {
            if (!context.getPlayer().isCreative()) {
                context.getStack().setCount(context.getStack().getCount() - 1);
            }

            context.getWorld().setBlockState(context.getBlockPos(), BlocksAether.enchanted_aether_grass.getDefaultState());

            return ActionResult.SUCCESS;
        }

        return ActionResult.PASS;
    }

    @Override
    public TypedActionResult<ItemStack> use(World worldIn, PlayerEntity playerIn, Hand handIn) {
        ItemStack heldItem = playerIn.getStackInHand(handIn);

        if (playerIn.canFoodHeal()) {
            if (!playerIn.isCreative()) {
                heldItem.setCount(heldItem.getCount() - 1);
            }

            playerIn.heal(2.0F);

            return new TypedActionResult<ItemStack>(ActionResult.SUCCESS, heldItem);
        }

        return new TypedActionResult<ItemStack>(ActionResult.PASS, heldItem);
    }

}