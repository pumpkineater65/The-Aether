package com.aether.items;

import com.aether.Aether;
import com.aether.blocks.AetherBlocks;
import com.aether.entities.AetherEntityTypes;
import com.aether.items.accessories.AccessoryType;
import com.aether.items.accessories.ItemAccessory;
import com.aether.items.armor.AetherArmorType;
import com.aether.items.food.*;
import com.aether.items.resources.AmbrosiumShard;
import com.aether.items.staff.CloudStaff;
import com.aether.items.staff.NatureStaff;
import com.aether.items.tools.*;
import com.aether.items.utils.AetherTiers;
import com.aether.items.weapons.*;
import com.aether.util.item.AetherRarity;
import net.minecraft.ChatFormatting;
import net.minecraft.core.Registry;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraft.world.level.material.Fluids;

public class AetherItems {
    public static final Item ZANITE_GEM, ZANITE_FRAGMENT, GRAVITITE_GEM, AMBROSIUM_SHARD, GOLDEN_AMBER, AECHOR_PETAL, SWET_BALL;
    //public static final Item SKYROOT_STICK, VICTORY_MEDAL;
    //public static final Item SKYROOT_PICKAXE, SKYROOT_AXE, SKYROOT_SHOVEL, SKYROOT_SWORD, SKYROOT_HOE;
    //public static final Item HOLYSTONE_PICKAXE, HOLYSTONE_AXE, HOLYSTONE_SHOVEL, HOLYSTONE_SWORD, HOLYSTONE_HOE;
    public static final Item ZANITE_PICKAXE, ZANITE_AXE, ZANITE_SHOVEL, ZANITE_SWORD, ZANITE_HOE;
    public static final Item GRAVITITE_PICKAXE, GRAVITITE_AXE, GRAVITITE_SHOVEL, GRAVITITE_SWORD, GRAVITITE_HOE;
    public static final Item VALKYRIE_PICKAXE, VALKYRIE_AXE, VALKYRIE_SHOVEL, VALKYRIE_HOE;
    public static final Item  ZANITE_HELMET, ZANITE_CHESTPLATE, ZANITE_LEGGINGS, ZANITE_BOOTS;
    public static final ArmorItem GRAVITITE_HELMET, GRAVITITE_CHESTPLATE, GRAVITITE_LEGGINGS, GRAVITITE_BOOTS;
    public static final ArmorItem NEPTUNE_HELMET, NEPTUNE_CHESTPLATE, NEPTUNE_LEGGINGS, NEPTUNE_BOOTS;
    public static final ArmorItem PHOENIX_HELMET, PHOENIX_CHESTPLATE, PHOENIX_LEGGINGS, PHOENIX_BOOTS;
    public static final ArmorItem OBSIDIAN_HELMET, OBSIDIAN_CHESTPLATE, OBSIDIAN_LEGGINGS, OBSIDIAN_BOOTS;
    public static final ArmorItem VALKYRIE_HELMET, VALKYRIE_CHESTPLATE, VALKYRIE_LEGGINGS, VALKYRIE_BOOTS;
    public static final Item BLUEBERRY, ENCHANTED_BLUEBERRY, BLUE_GUMMY_SWET, GOLDEN_GUMMY_SWET, HEALING_STONE, AETHER_MILK, WHITE_APPLE, GINGERBREAD_MAN, CANDY_CANE;
    public static final Item SKYROOT_BUCKET, SKYROOT_WATER_BUCKET, SKYROOT_POISON_BUCKET, SKYROOT_REMEDY_BUCKET, SKYROOT_MILK_BUCKET;
    public static final Item CLOUD_PARACHUTE, GOLDEN_CLOUD_PARACHUTE;
    public static final Item BRONZE_KEY, SILVER_KEY, GOLDEN_KEY;
    public static final Item NATURE_STAFF, CLOUD_STAFF, MOA_EGG;
    public static final Dart GOLDEN_DART, ENCHANTED_DART, POISON_DART;
    public static final Item GOLDEN_DART_SHOOTER, ENCHANTED_DART_SHOOTER, POISON_DART_SHOOTER;
    public static final Item PHOENIX_BOW;
    public static final Item FLAMING_SWORD, LIGHTNING_SWORD, HOLY_SWORD;
    public static final Item VAMPIRE_BLADE, PIG_SLAYER, CANDY_CANE_SWORD, /*NOTCH_HAMMER,*/
            VALKYRIE_LANCE;
    public static final Item LEATHER_GLOVES, IRON_GLOVES, GOLDEN_GLOVES, CHAIN_GLOVES, DIAMOND_GLOVES;
    public static final Item ZANITE_GLOVES, GRAVITITE_GLOVES, NEPTUNE_GLOVES, PHOENIX_GLOVES, OBSIDIAN_GLOVES, VALKYRIE_GLOVES;
    public static final Item IRON_RING, GOLDEN_RING, ZANITE_RING, ICE_RING, IRON_PENDANT, GOLDEN_PENDANT, ZANITE_PENDANT, ICE_PENDANT;
    public static final Item RED_CAPE, BLUE_CAPE, YELLOW_CAPE, WHITE_CAPE, SWET_CAPE, INVISIBILITY_CAPE, AGILITY_CAPE;
    public static final Item GOLDEN_FEATHER, REGENERATION_STONE, IRON_BUBBLE;
    public static final Item LIFE_SHARD;
    public static final ArmorItem SENTRY_BOOTS/*, LIGHTNING_KNIFE*/;
    //    PUBLIC STATIC ITEM AETHER_TUNE, ASCENDING_DAWN, WELCOMING_SKIES, LEGACY;
//    PUBLIC STATIC ITEM REPULSION_SHIELD;
    public static final Item LORE_BOOK;
    public static final Item QUICKSOIL_VIAL, AERCLOUD_VIAL;
    public static final Item AECHOR_PLANT_SPAWN_EGG, CHEST_MIMIC_SPAWN_EGG,
            COCKATRICE_SPAWN_EGG, AERBUNNY_SPAWN_EGG, FLYING_COW_SPAWN_EGG,
            MOA_SPAWN_EGG, PHYG_SPAWN_EGG, SHEEPUFF_SPAWN_EGG, GOLD_AERDUST, FROZEN_AERDUST;

    public static final Item AETHER_PORTAL;

    public static final AetherRarity AETHER_LOOT = new AetherRarity(ChatFormatting.GREEN);

    static {
        // Resources
        final Item.Properties RESOURCES = new Item.Properties().tab(AetherItemGroups.Resources);
        ZANITE_GEM = register("zanite_gemstone", new Item(RESOURCES));
        ZANITE_FRAGMENT = register("zanite_fragment", new Item(RESOURCES));
        GRAVITITE_GEM = register("gravitite_gemstone", new Item(RESOURCES));
        AMBROSIUM_SHARD = register("ambrosium_shard", new AmbrosiumShard(RESOURCES));
        GOLDEN_AMBER = register("golden_amber", new Item(RESOURCES));
        AECHOR_PETAL = register("aechor_petal", new Item(RESOURCES));
        SWET_BALL = register("swet_ball", new Item(RESOURCES));
        //SKYROOT_STICK = register("skyroot_stick", new Item(RESOURCES));
        GOLD_AERDUST = register("gold_aerdust", new Item(RESOURCES));
        FROZEN_AERDUST = register("frozen_aerdust", new Item(RESOURCES));

        // Tools
        final Item.Properties TOOLS = new Item.Properties().tab(AetherItemGroups.Tools);
        final Item.Properties WEAPONS = new Item.Properties().tab(AetherItemGroups.Tools);
        /*SKYROOT_SHOVEL = register("skyroot_shovel", new AetherShovel(AetherTiers.Skyroot, TOOLS, 1.5F, -3.0F));
        SKYROOT_PICKAXE = register("skyroot_pickaxe", new AetherPickaxe(AetherTiers.Skyroot, TOOLS, 1, -2.8F));
        SKYROOT_AXE = register("skyroot_axe", new AetherAxe(AetherTiers.Skyroot, TOOLS, 6.0F, -3.2F));
        SKYROOT_SWORD = register("skyroot_sword", new AetherSword(AetherTiers.Skyroot, -2.4F, 3, WEAPONS));
        SKYROOT_HOE = register("skyroot_hoe", new AetherHoe(AetherTiers.Skyroot, TOOLS, 1));

        HOLYSTONE_SHOVEL = register("holystone_shovel", new AetherShovel(AetherTiers.Holystone, TOOLS,1.5F, -3.0F));
        HOLYSTONE_PICKAXE = register("holystone_pickaxe", new AetherPickaxe(AetherTiers.Holystone, TOOLS, 1, -2.8F));
        HOLYSTONE_AXE = register("holystone_axe", new AetherAxe(AetherTiers.Holystone, TOOLS, 7.0F, -3.2F));
        HOLYSTONE_SWORD = register("holystone_sword", new AetherSword(AetherTiers.Holystone, -2.4F, 3, WEAPONS));
        HOLYSTONE_HOE = register("holystone_hoe", new AetherHoe(AetherTiers.Holystone, TOOLS, 2));
        */
        ZANITE_SHOVEL = register("zanite_shovel", new AetherShovel(AetherTiers.Zanite, TOOLS, 1.5F, -3.0F));
        ZANITE_PICKAXE = register("zanite_pickaxe", new AetherPickaxe(AetherTiers.Zanite, TOOLS,  1, -2.8F));
        ZANITE_AXE = register("zanite_axe", new AetherAxe(AetherTiers.Zanite, TOOLS, 6.0F, -3.1F));
        ZANITE_SWORD = register("zanite_sword", new AetherSword(AetherTiers.Zanite, -2.4F, 3, WEAPONS));
        ZANITE_HOE = register("zanite_hoe", new AetherHoe(AetherTiers.Zanite, TOOLS, 3));

        final Item.Properties GRAVITITE_TOOLS = new AetherItemSettings().rarity(Rarity.RARE).tab(AetherItemGroups.Tools);
        GRAVITITE_SHOVEL = register("gravitite_shovel", new AetherShovel(AetherTiers.Gravitite, GRAVITITE_TOOLS, 1.5F, -3.0F));
        GRAVITITE_PICKAXE = register("gravitite_pickaxe", new AetherPickaxe(AetherTiers.Gravitite, GRAVITITE_TOOLS, 1, -2.8F));
        GRAVITITE_AXE = register("gravitite_axe", new AetherAxe(AetherTiers.Gravitite, GRAVITITE_TOOLS, 5.0F, -3.0F));
        GRAVITITE_SWORD = register("gravitite_sword", new AetherSword(AetherTiers.Gravitite, -2.4F, 3, new AetherItemSettings().rarity(Rarity.RARE).tab(AetherItemGroups.Tools)));
        GRAVITITE_HOE = register("gravitite_hoe", new AetherHoe(AetherTiers.Gravitite, GRAVITITE_TOOLS, 4));

        final Item.Properties VALKYRIE_TOOLS = new AetherItemSettings().rarity(AETHER_LOOT).tab(AetherItemGroups.Tools);
        VALKYRIE_SHOVEL = register("valkyrie_shovel", new AetherShovel(AetherTiers.Valkyrie, VALKYRIE_TOOLS, 1.5F, -3.0F));
        VALKYRIE_PICKAXE = register("valkyrie_pickaxe", new AetherPickaxe(AetherTiers.Valkyrie, VALKYRIE_TOOLS, 1, -2.8F));
        VALKYRIE_AXE = register("valkyrie_axe", new AetherAxe(AetherTiers.Valkyrie, VALKYRIE_TOOLS, 4.0F, -2.9F));
        VALKYRIE_LANCE = register("valkyrie_lance", new ValkyrieLance(new AetherItemSettings().rarity(Rarity.EPIC).tab(AetherItemGroups.Tools)));
        VALKYRIE_HOE = register("valkyrie_hoe", new AetherHoe(AetherTiers.Valkyrie, VALKYRIE_TOOLS, 5));

        // Armor
        final AetherItemSettings ARMOR = new AetherItemSettings().tab(AetherItemGroups.Wearable);
        ZANITE_HELMET = register("zanite_helmet", new ArmorItem(AetherArmorType.Zanite.getMaterial(), EquipmentSlot.HEAD, ARMOR));
        ZANITE_CHESTPLATE = register("zanite_chestplate", new ArmorItem(AetherArmorType.Zanite.getMaterial(), EquipmentSlot.CHEST, ARMOR));
        ZANITE_LEGGINGS = register("zanite_leggings", new ArmorItem(AetherArmorType.Zanite.getMaterial(), EquipmentSlot.LEGS, ARMOR));
        ZANITE_BOOTS = register("zanite_boots", new ArmorItem(AetherArmorType.Zanite.getMaterial(), EquipmentSlot.FEET, ARMOR));
//
        final AetherItemSettings GRAVITITE_ARMOR = new AetherItemSettings().tab(AetherItemGroups.Wearable).rarity(Rarity.RARE);
        GRAVITITE_HELMET = register("gravitite_helmet", new ArmorItem(AetherArmorType.Gravitite.getMaterial(), EquipmentSlot.HEAD, GRAVITITE_ARMOR));
        GRAVITITE_CHESTPLATE = register("gravitite_chestplate", new ArmorItem(AetherArmorType.Gravitite.getMaterial(), EquipmentSlot.CHEST, GRAVITITE_ARMOR));
        GRAVITITE_LEGGINGS = register("gravitite_leggings", new ArmorItem(AetherArmorType.Gravitite.getMaterial(), EquipmentSlot.LEGS, GRAVITITE_ARMOR));
        GRAVITITE_BOOTS = register("gravitite_boots", new ArmorItem(AetherArmorType.Gravitite.getMaterial(), EquipmentSlot.FEET, GRAVITITE_ARMOR));
//
        final AetherItemSettings LOOT_ARMOR = new AetherItemSettings().rarity(AETHER_LOOT).tab(AetherItemGroups.Wearable);
        NEPTUNE_HELMET = register("neptune_helmet", new ArmorItem(AetherArmorType.Neptune.getMaterial(), EquipmentSlot.HEAD, LOOT_ARMOR));
        NEPTUNE_CHESTPLATE = register("neptune_chestplate", new ArmorItem(AetherArmorType.Neptune.getMaterial(), EquipmentSlot.CHEST, LOOT_ARMOR));
        NEPTUNE_LEGGINGS = register("neptune_leggings", new ArmorItem(AetherArmorType.Neptune.getMaterial(), EquipmentSlot.LEGS, LOOT_ARMOR));
        NEPTUNE_BOOTS = register("neptune_boots", new ArmorItem(AetherArmorType.Neptune.getMaterial(), EquipmentSlot.FEET, LOOT_ARMOR));
//
        PHOENIX_HELMET = register("phoenix_helmet", new ArmorItem(AetherArmorType.Phoenix.getMaterial(), EquipmentSlot.HEAD, LOOT_ARMOR));
        PHOENIX_CHESTPLATE = register("phoenix_chestplate", new ArmorItem(AetherArmorType.Phoenix.getMaterial(), EquipmentSlot.CHEST, LOOT_ARMOR));
        PHOENIX_LEGGINGS = register("phoenix_leggings", new ArmorItem(AetherArmorType.Phoenix.getMaterial(), EquipmentSlot.LEGS, LOOT_ARMOR));
        PHOENIX_BOOTS = register("phoenix_boots", new ArmorItem(AetherArmorType.Phoenix.getMaterial(), EquipmentSlot.FEET, LOOT_ARMOR));
//
        OBSIDIAN_HELMET = register("obsidian_helmet", new ArmorItem(AetherArmorType.Obsidian.getMaterial(), EquipmentSlot.HEAD, LOOT_ARMOR));
        OBSIDIAN_CHESTPLATE = register("obsidian_chestplate", new ArmorItem(AetherArmorType.Obsidian.getMaterial(), EquipmentSlot.CHEST, LOOT_ARMOR));
        OBSIDIAN_LEGGINGS = register("obsidian_leggings", new ArmorItem(AetherArmorType.Obsidian.getMaterial(), EquipmentSlot.LEGS, LOOT_ARMOR));
        OBSIDIAN_BOOTS = register("obsidian_boots", new ArmorItem(AetherArmorType.Obsidian.getMaterial(), EquipmentSlot.FEET, LOOT_ARMOR));
//
        VALKYRIE_HELMET = register("valkyrie_helmet", new ArmorItem(AetherArmorType.Valkyrie.getMaterial(), EquipmentSlot.HEAD, LOOT_ARMOR));
        VALKYRIE_CHESTPLATE = register("valkyrie_chestplate", new ArmorItem(AetherArmorType.Valkyrie.getMaterial(), EquipmentSlot.CHEST, LOOT_ARMOR));
        VALKYRIE_LEGGINGS = register("valkyrie_leggings", new ArmorItem(AetherArmorType.Valkyrie.getMaterial(), EquipmentSlot.LEGS, LOOT_ARMOR));
        VALKYRIE_BOOTS = register("valkyrie_boots", new ArmorItem(AetherArmorType.Valkyrie.getMaterial(), EquipmentSlot.FEET, LOOT_ARMOR));
//
        SENTRY_BOOTS = register("sentry_boots", new ArmorItem(AetherArmorType.Sentry.getMaterial(), EquipmentSlot.FEET, LOOT_ARMOR));

        // Food
        AetherItemSettings LOOT_FOOD = new AetherItemSettings().tab(AetherItemGroups.Food).rarity(AetherItems.AETHER_LOOT);
        BLUEBERRY = register("blue_berry", new BlockItem(AetherBlocks.BLUEBERRY_BUSH, new Item.Properties().tab(AetherItemGroups.Food).food(AetherFood.DEFAULT)));
        ENCHANTED_BLUEBERRY = register("enchanted_blueberry", new Item(new Item.Properties().tab(AetherItemGroups.Food).rarity(Rarity.RARE).food(AetherFood.ENCHANTED_BLUEBERRY)));
        WHITE_APPLE = register("white_apple", new WhiteApple(new Item.Properties().tab(AetherItemGroups.Food).food(AetherFood.WHITE_APPLE)));
        BLUE_GUMMY_SWET = register("blue_gummy_swet", new GummySwet(LOOT_FOOD));
        GOLDEN_GUMMY_SWET = register("golden_gummy_swet", new GummySwet(LOOT_FOOD));
        AETHER_MILK = register("valkyrie_milk", new Item(new Item.Properties().rarity(Rarity.EPIC).food(AetherFood.MILK).stacksTo(16)));
        HEALING_STONE = register("healing_stone", new HealingStone(new Item.Properties().tab(AetherItemGroups.Food).rarity(Rarity.RARE).food(AetherFood.HEALING_STONE)));
        CANDY_CANE = register("candy_cane", new Item(new Item.Properties().tab(AetherItemGroups.Food).food(AetherFood.DEFAULT)));
        GINGERBREAD_MAN = register("ginger_bread_man", new Item(new Item.Properties().tab(AetherItemGroups.Food).food(AetherFood.DEFAULT)));

        // Misc + Materials
        final AetherItemSettings LOOT_ACCESSORY = new AetherItemSettings().rarity(AETHER_LOOT).tab(AetherItemGroups.Wearable);
        GOLDEN_FEATHER = register("golden_feather", new ItemAccessory(AccessoryType.MISC, LOOT_ACCESSORY));
        REGENERATION_STONE = register("regeneration_stone", new ItemAccessory(AccessoryType.MISC, LOOT_ACCESSORY));
        IRON_BUBBLE = register("iron_bubble", new ItemAccessory(AccessoryType.MISC, LOOT_ACCESSORY));
        LIFE_SHARD = register("life_shard", new LifeShard(new AetherItemSettings().rarity(AetherItems.AETHER_LOOT).stacksTo(1).tab(AetherItemGroups.Misc)));
        CLOUD_STAFF = register("cloud_staff", new CloudStaff(new Item.Properties().stacksTo(1).durability(60).tab(AetherItemGroups.Misc)));
        NATURE_STAFF = register("nature_staff", new NatureStaff(new Item.Properties().stacksTo(1).durability(100).tab(AetherItemGroups.Misc)));
        MOA_EGG = register("moa_egg", new MoaEgg(new Item.Properties().stacksTo(1).tab(AetherItemGroups.Misc)));
        LORE_BOOK = register("lore_book", new BookOfLore((new Item.Properties()).stacksTo(1).tab(AetherItemGroups.Misc)));
        SKYROOT_BUCKET = register("skyroot_bucket", new SkyrootBucket(new Item.Properties().stacksTo(16).tab(AetherItemGroups.Misc)));

        final Item.Properties BUCKET = new Item.Properties().stacksTo(1).tab(AetherItemGroups.Misc).craftRemainder(SKYROOT_BUCKET);
        SKYROOT_WATER_BUCKET = register("skyroot_water_bucket", new SkyrootBucket(Fluids.WATER, BUCKET));
        SKYROOT_MILK_BUCKET = register("skyroot_milk_bucket", new SkyrootBucket(BUCKET));
        SKYROOT_POISON_BUCKET = register("skyroot_poison_bucket", new SkyrootBucket(BUCKET));
        SKYROOT_REMEDY_BUCKET = register("skyroot_remedy_bucket", new SkyrootBucket(BUCKET));
        QUICKSOIL_VIAL = register("quicksoil_vial", new VialItem(Fluids.EMPTY, new Item.Properties().tab(AetherItemGroups.Misc)));
        AERCLOUD_VIAL = register("aercloud_vial", new VialItem(AetherBlocks.DENSE_AERCLOUD_STILL, new Item.Properties().tab(AetherItemGroups.Misc)));

        CLOUD_PARACHUTE = register("cold_parachute", new Parachute(new Item.Properties().stacksTo(1).tab(AetherItemGroups.Misc)));
        GOLDEN_CLOUD_PARACHUTE = register("golden_parachute", new Parachute(new Item.Properties().stacksTo(1).durability(20).tab(AetherItemGroups.Misc)));

        final AetherItemSettings KEYS = new AetherItemSettings().tab(AetherItemGroups.Misc).rarity(AETHER_LOOT);
        BRONZE_KEY = register("bronze_key", new Item(KEYS));
        SILVER_KEY = register("silver_key", new Item(KEYS));
        GOLDEN_KEY = register("golden_key", new Item(KEYS));

        // Materials


        // Weapons
        final AetherItemSettings LOOT_WEAPON = new AetherItemSettings().rarity(AETHER_LOOT).tab(AetherItemGroups.Tools);
        GOLDEN_DART = register("golden_dart", new Dart(new Item.Properties().tab(AetherItemGroups.Tools)));
        ENCHANTED_DART = register("enchanted_dart", new Dart(new Item.Properties().rarity(Rarity.RARE).tab(AetherItemGroups.Tools)));
        POISON_DART = register("poison_dart", new Dart(new Item.Properties().tab(AetherItemGroups.Tools)));

        GOLDEN_DART_SHOOTER = register("golden_dart_shooter", new DartShooter(GOLDEN_DART, new Item.Properties().stacksTo(1).tab(AetherItemGroups.Tools)));
        ENCHANTED_DART_SHOOTER = register("enchanted_dart_shooter", new DartShooter(ENCHANTED_DART, new Item.Properties().stacksTo(1).rarity(Rarity.RARE).tab(AetherItemGroups.Tools)));
        POISON_DART_SHOOTER = register("poison_dart_shooter", new DartShooter(POISON_DART, new Item.Properties().stacksTo(1).tab(AetherItemGroups.Tools)));

        PHOENIX_BOW = register("phoenix_bow", new BowItem(new Item.Properties().durability(384).tab(AetherItemGroups.Tools)));

        FLAMING_SWORD = register("flaming_sword", new ElementalSword(LOOT_WEAPON));
        LIGHTNING_SWORD = register("lightning_sword", new ElementalSword(LOOT_WEAPON));
        HOLY_SWORD = register("holy_sword", new ElementalSword(LOOT_WEAPON));

        VAMPIRE_BLADE = register("vampire_blade", new VampireBlade(LOOT_WEAPON));
        PIG_SLAYER = register("pig_slayer", new PigSlayer(LOOT_WEAPON));
        CANDY_CANE_SWORD = register("candy_cane_sword", new CandyCaneSword(WEAPONS));

        // Spawn Eggs
        AECHOR_PLANT_SPAWN_EGG = register("aechor_plant_spawn_egg", new SpawnEggItem(AetherEntityTypes.AECHOR_PLANT, 0x97ded4, 0x31897d, new Item.Properties().tab(AetherItemGroups.Misc)));
        CHEST_MIMIC_SPAWN_EGG = null;
        COCKATRICE_SPAWN_EGG = register("cockatrice_spawn_egg", new SpawnEggItem(AetherEntityTypes.COCKATRICE, 0x9fc3f7, 0x3d2338, new Item.Properties().tab(AetherItemGroups.Misc)));
        AERBUNNY_SPAWN_EGG = register("aerbunny_spawn_egg", new SpawnEggItem(AetherEntityTypes.AERBUNNY, 0xc5d6ed, 0x82a6d9, new Item.Properties().tab(AetherItemGroups.Misc)));
        FLYING_COW_SPAWN_EGG = null;
        MOA_SPAWN_EGG = null;
        PHYG_SPAWN_EGG = null;
        SHEEPUFF_SPAWN_EGG = null;

        // Accessories
        LEATHER_GLOVES = register("leather_gloves", new ItemAccessory(AccessoryType.GLOVES, new AetherItemSettings().tab(AetherItemGroups.Wearable).enchantmentGlintColor(0xC65C35)).setDamageMultiplier(1.5F));
        IRON_GLOVES = register("iron_gloves", new ItemAccessory(AccessoryType.GLOVES, new AetherItemSettings()).setDamageMultiplier(2.5F));
        GOLDEN_GLOVES = register("golden_gloves", new ItemAccessory(AccessoryType.GLOVES, new AetherItemSettings().tab(AetherItemGroups.Wearable).enchantmentGlintColor(0xFBF424)).setDamageMultiplier(2.0F));
        CHAIN_GLOVES = register("chain_gloves", new ItemAccessory(AccessoryType.GLOVES, "chain", new AetherItemSettings()).setDamageMultiplier(2.0F));
        DIAMOND_GLOVES = register("diamond_gloves", new ItemAccessory(AccessoryType.GLOVES, new AetherItemSettings().tab(AetherItemGroups.Wearable).enchantmentGlintColor(0x33EBCB)).setDamageMultiplier(4.5F));
        ZANITE_GLOVES = register("zanite_gloves", new ItemAccessory(AccessoryType.GLOVES, new AetherItemSettings().tab(AetherItemGroups.Wearable).enchantmentGlintColor(0x711AE8)).setDamageMultiplier(3.0F));
        GRAVITITE_GLOVES = register("gravitite_gloves", new ItemAccessory(AccessoryType.GLOVES, new AetherItemSettings().tab(AetherItemGroups.Wearable).enchantmentGlintColor(0xE752DB).rarity(Rarity.RARE)).setDamageMultiplier(4.0F));
        NEPTUNE_GLOVES = register("neptune_gloves", new ItemAccessory(AccessoryType.GLOVES, new AetherItemSettings().tab(AetherItemGroups.Wearable).enchantmentGlintColor(0x2654FF).rarity(AETHER_LOOT)).setDamageMultiplier(4.5F));
        PHOENIX_GLOVES = register("phoenix_gloves", new ItemAccessory(AccessoryType.GLOVES, "phoenix", new AetherItemSettings().tab(AetherItemGroups.Wearable).enchantmentGlintColor(0xff7700).rarity(AETHER_LOOT)).setDamageMultiplier(4.0F));
        OBSIDIAN_GLOVES = register("obsidian_gloves", new ItemAccessory(AccessoryType.GLOVES, new AetherItemSettings().tab(AetherItemGroups.Wearable).enchantmentGlintColor(0x1B1447)).setDamageMultiplier(5.0F));
        VALKYRIE_GLOVES = register("valkyrie_gloves", new ItemAccessory(AccessoryType.GLOVES, "valkyrie", new AetherItemSettings().tab(AetherItemGroups.Wearable).rarity(AETHER_LOOT)).setDamageMultiplier(5.0F));

        IRON_RING = register("iron_ring", new ItemAccessory(AccessoryType.RING, new AetherItemSettings().tab(AetherItemGroups.Wearable)));
        GOLDEN_RING = register("golden_ring", new ItemAccessory(AccessoryType.RING, new AetherItemSettings().tab(AetherItemGroups.Wearable).enchantmentGlintColor(0xEAEE57)));
        ZANITE_RING = register("zanite_ring", new ItemAccessory(AccessoryType.RING, new AetherItemSettings().tab(AetherItemGroups.Wearable).enchantmentGlintColor(0x711AE8)));
        ICE_RING = register("ice_ring", new ItemAccessory(AccessoryType.RING, new AetherItemSettings().tab(AetherItemGroups.Wearable).enchantmentGlintColor(0x95E6E7).rarity(Rarity.RARE)));

        IRON_PENDANT = register("iron_pendant", new ItemAccessory(AccessoryType.PENDANT, new AetherItemSettings()));
        GOLDEN_PENDANT = register("golden_pendant", new ItemAccessory(AccessoryType.PENDANT, new AetherItemSettings().tab(AetherItemGroups.Wearable).enchantmentGlintColor(0xEAEE57)));
        ZANITE_PENDANT = register("zanite_pendant", new ItemAccessory(AccessoryType.PENDANT, new AetherItemSettings().tab(AetherItemGroups.Wearable).enchantmentGlintColor(0x711AE8)));
        ICE_PENDANT = register("ice_pendant", new ItemAccessory(AccessoryType.PENDANT, new AetherItemSettings().tab(AetherItemGroups.Wearable).enchantmentGlintColor(0x95E6E7).rarity(Rarity.RARE)));

        WHITE_CAPE = register("white_cape", new ItemAccessory(AccessoryType.CAPE, new AetherItemSettings()));
        RED_CAPE = register("red_cape", new ItemAccessory(AccessoryType.CAPE, new AetherItemSettings().tab(AetherItemGroups.Wearable).enchantmentGlintColor(0xE81111)));
        BLUE_CAPE = register("blue_cape", new ItemAccessory(AccessoryType.CAPE, new AetherItemSettings().tab(AetherItemGroups.Wearable).enchantmentGlintColor(0x137FB7)));
        YELLOW_CAPE = register("yellow_cape", new ItemAccessory(AccessoryType.CAPE, new AetherItemSettings().tab(AetherItemGroups.Wearable).enchantmentGlintColor(0xCDCB0E)));
        SWET_CAPE = register("swet_cape", new ItemAccessory(AccessoryType.CAPE, "swet", new AetherItemSettings().rarity(AETHER_LOOT)));
        AGILITY_CAPE = register("agility_cape", new ItemAccessory(AccessoryType.CAPE, "agility", new AetherItemSettings().rarity(AETHER_LOOT)));
        INVISIBILITY_CAPE = register("invisibility_cape", new ItemAccessory(AccessoryType.CAPE, new AetherItemSettings().rarity(AETHER_LOOT)));

        AETHER_PORTAL = register("aether_portal", new AetherPortalItem(new Item.Properties().tab(AetherItemGroups.Misc)));
    }

    private static <T extends Item> T register(String id, T item) {
        return Registry.register(Registry.ITEM, Aether.locate(id), item);
    }

    public static void init() {
        // Empty void. Eternal emptiness
    }

    public static void initClient() {
        // Empty void. Eternal emptiness
    }
}
