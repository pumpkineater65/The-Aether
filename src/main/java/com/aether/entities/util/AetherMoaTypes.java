package com.aether.entities.util;

import com.aether.Aether;
import com.aether.api.AetherAPI;
import com.aether.api.moa.MoaProperties;
import com.aether.api.moa.MoaType;
import net.minecraft.world.item.CreativeModeTab;

public class AetherMoaTypes {

    public static MoaType blue, orange, white, black;

    public static void init() {
        blue = register("blue", 0x7777FF, new MoaProperties(3, 0.3F, Aether.locate("textures/entity/moa/moa_blue.png"), Aether.locate("textures/entity/moa/moa_saddle.png")));
        orange = register("orange", -0xC3D78, new MoaProperties(2, 0.6F, Aether.locate("textures/entity/moa/moa_orange.png"), Aether.locate("textures/entity/moa/moa_saddle.png")));
        white = register("white", 0xFFFFFF, new MoaProperties(4, 0.3F, Aether.locate("textures/entity/moa/moa_white.png"), Aether.locate("textures/entity/moa/moa_saddle.png")));
        black = register("black", 0x222222, new MoaProperties(8, 0.3F, Aether.locate("textures/entity/moa/moa_black.png"), Aether.locate("textures/entity/moa/moa_black_saddle.png")));
    }

    public static MoaType register(String name, int hexColor, MoaProperties properties) {
        MoaType moaType = new MoaType(hexColor, CreativeModeTab.TAB_MISC, properties);
        AetherAPI.instance().register(Aether.locate(name), moaType);
        return moaType;
    }
}