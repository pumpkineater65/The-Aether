package com.legacy.aether.item.food;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;

public class AetherFood {

    public static final FoodComponent DEFAULT = new FoodComponent.Builder().hunger(2).saturationModifier(1.5F).build();

    public static final FoodComponent ENCHANTED_BLUEBERRY = new FoodComponent.Builder().hunger(8).saturationModifier(10.0F).build();

    public static final FoodComponent WHITE_APPLE = new FoodComponent.Builder().saturationModifier(10.0F).alwaysEdible().snack().build();

    public static final FoodComponent HEALING_STONE = new FoodComponent.Builder().saturationModifier(2.5F).alwaysEdible().snack().statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 610, 0), 1.0F).build();

}