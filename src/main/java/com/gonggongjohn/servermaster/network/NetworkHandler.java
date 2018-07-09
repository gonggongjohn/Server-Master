package com.gonggongjohn.servermaster.network;

import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.relauncher.Side;
import com.gonggongjohn.servermaster.ServerMaster;

public class NetworkHandler {
    public static SimpleNetworkWrapper instance = NetworkRegistry.INSTANCE.newSimpleChannel(ServerMaster.MODID);

    public NetworkHandler() {
        instance.registerMessage(MessageCheckResult.MessageHandler.class, MessageCheckResult.class, 0, Side.SERVER);
        instance.registerMessage(MessageCheckCheat.MessageHandler.class, MessageCheckCheat.class, 1, Side.CLIENT);
    }
}
