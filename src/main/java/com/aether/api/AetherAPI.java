package com.aether.api;

import com.aether.api.moa.MoaType;
import java.util.HashMap;
import java.util.Random;
import net.minecraft.resources.ResourceLocation;

public class AetherAPI {

    private static final HashMap<ResourceLocation, MoaType> MOA_REGISTRY = new HashMap<>();
    private static final AetherAPI INSTANCE = new AetherAPI();
    private static int moaListSize;

    public AetherAPI() {

    }

    public static AetherAPI instance() {
        return INSTANCE;
    }

    public void register(ResourceLocation registryName, MoaType moa) {
        moa.setRegistryName(registryName);

        MOA_REGISTRY.put(registryName, moa);
        ++moaListSize;
    }

    public MoaType getMoa() {
        Random random = new Random();
        MoaType[] rescValues = MOA_REGISTRY.values().toArray(new MoaType[0]);

        return rescValues[random.nextInt(rescValues.length)];
    }

    public MoaType getMoa(ResourceLocation registryName) {
        return MOA_REGISTRY.get(registryName);
    }

    public MoaType getMoa(int id) {
        MoaType[] rescValues = MOA_REGISTRY.values().toArray(new MoaType[0]);

        return rescValues[id];
    }

    public int getMoaId(MoaType moa) {
        boolean isMatch = false;
        int indexNumber = -1;

        for (MoaType moaType : MOA_REGISTRY.values()) {
            indexNumber++;
            if (moa.equals(moaType)) {
                isMatch = true;
                break;
            }
        }
        return isMatch ? indexNumber : 0;
    }

    public int getMoaRegistrySize() {
        return moaListSize;
    }

}