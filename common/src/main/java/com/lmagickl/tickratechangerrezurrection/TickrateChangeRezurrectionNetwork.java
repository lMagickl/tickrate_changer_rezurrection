package com.lmagickl.tickratechangerrezurrection;


import me.shedaniel.architectury.networking.NetworkManager;

import static com.lmagickl.tickratechangerrezurrection.TickrateChangerRezurrection.LOGGER;

public class TickrateChangeRezurrectionNetwork {

    public static void registerPackets() {
        NetworkManager.registerReceiver(NetworkManager.Side.S2C, TickrateChangerRezurrection.TICKRATE, ((buf, context) -> {
            float tickrate = buf.readFloat();
            LOGGER.info("Packet on client received: " + tickrate);
            TickrateChangerRezurrection.INSTANCE.updateClientTickrate(tickrate, TickrateChangerRezurrection.SHOW_MESSAGES);
        }));

    }
}