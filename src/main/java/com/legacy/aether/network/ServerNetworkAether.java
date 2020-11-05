package com.legacy.aether.network;

import com.legacy.aether.Aether;
import com.legacy.aether.api.AetherAPI;
import com.legacy.aether.api.player.IPlayerAether;
import net.fabricmc.fabric.api.container.ContainerProviderRegistry;
import net.fabricmc.fabric.api.network.PacketConsumer;
import net.fabricmc.fabric.api.network.PacketContext;
import net.fabricmc.fabric.api.network.ServerSidePacketRegistry;
import net.minecraft.network.PacketByteBuf;

public class ServerNetworkAether {

    public static void initializePacketHandler() {
        register("poison", ServerNetworkAether::onPlayerPoisoned);
        register("cure", ServerNetworkAether::onPlayerCured);
        register("open_accessories", (contextIn, byteBuf) -> onPlayerOpenedAccessoriesGUI(contextIn));
    }

    private static void register(String name, PacketConsumer consumer) {
        ServerSidePacketRegistry.INSTANCE.register(Aether.locate(name), consumer);
    }

    private static void onPlayerPoisoned(PacketContext contextIn, PacketByteBuf byteBuf) {
        IPlayerAether playerAether = AetherAPI.get(contextIn.getPlayer());
        int poisonTicks = byteBuf.readInt();

        playerAether.inflictPoison(poisonTicks);
    }

    private static void onPlayerCured(PacketContext contextIn, PacketByteBuf byteBuf) {
        IPlayerAether playerAether = AetherAPI.get(contextIn.getPlayer());
        int poisonTicks = byteBuf.readInt();

        playerAether.inflictCure(poisonTicks);
    }

    private static void onPlayerOpenedAccessoriesGUI(PacketContext contextIn) {
        ContainerProviderRegistry.INSTANCE.openContainer(Aether.locate("accessories"), contextIn.getPlayer(), (buffer) -> {
        });
    }

}