package com.legacy.aether.client.rendering;

import com.legacy.aether.client.rendering.entity.*;
import com.legacy.aether.entities.EntityTypesAether;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;

public class AetherEntityRenderer {

    public static void registerRenderers() {
        register(EntityTypesAether.MOA, (entityRenderDispatcher, context) -> new MoaRenderer(entityRenderDispatcher));
        register(EntityTypesAether.FLOATING_BLOCK, (entityRenderDispatcher, context) -> new FloatingBlockRenderer(entityRenderDispatcher));
        register(EntityTypesAether.FLYING_COW, (entityRenderDispatcher, context) -> new FlyingCowRenderer(entityRenderDispatcher));
        register(EntityTypesAether.SHEEPUFF, (entityRenderDispatcher, context) -> new SheepuffRenderer(entityRenderDispatcher));
        register(EntityTypesAether.AERBUNNY, (entityRenderDispatcher, context) -> new AerbunnyRenderer(entityRenderDispatcher));
        register(EntityTypesAether.AECHOR_PLANT, (entityRenderDispatcher, context) -> new AechorPlantRenderer(entityRenderDispatcher));
        register(EntityTypesAether.PHYG, (entityRenderDispatcher, context) -> new PhygRenderer(entityRenderDispatcher));
        register(EntityTypesAether.COCKATRICE, (entityRenderDispatcher, context) -> new CockatriceRenderer(entityRenderDispatcher));

        register(EntityTypesAether.ENCHANTED_DART, (entityRenderDispatcher, context) -> new DartRenderer(entityRenderDispatcher));
        register(EntityTypesAether.GOLDEN_DART, (entityRenderDispatcher, context) -> new DartRenderer(entityRenderDispatcher));
        register(EntityTypesAether.POISON_DART, (entityRenderDispatcher, context) -> new DartRenderer(entityRenderDispatcher));
        register(EntityTypesAether.POISON_NEEDLE, (entityRenderDispatcher, context) -> new DartRenderer(entityRenderDispatcher));

        //entityRenderMap.put(EntityMiniCloud.class, new MiniCloudRenderer(renderManager));
        //entityRenderMap.put(EntityAerwhale.class, new AerwhaleRenderer(renderManager));
        register(EntityTypesAether.CHEST_MIMIC, (entityRendererDispatcher, context) -> new ChestMimicRenderer(entityRendererDispatcher));
        //entityRenderMap.put(EntityWhirlwind.class, new WhirlwindRenderer(renderManager));
        //entityRenderMap.put(EntityPhoenixArrow.class, new PhoenixArrowRenderer(renderManager));

    }

    private static void register(EntityType<? extends Entity> clazz, EntityRendererRegistry.Factory factory) {
        EntityRendererRegistry.INSTANCE.register(clazz, factory);
    }

}