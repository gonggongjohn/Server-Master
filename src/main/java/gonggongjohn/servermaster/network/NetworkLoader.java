package gonggongjohn.servermaster.network;

import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.relauncher.Side;
import gonggongjohn.servermaster.ServerMaster;

public class NetworkLoader {
    public static SimpleNetworkWrapper instance = NetworkRegistry.INSTANCE.newSimpleChannel(ServerMaster.MODID);
    private static int channel = 0;

    public NetworkLoader() {
        registerMessage(MessageCheckResult.MessageHandler.class, MessageCheckResult.class, Side.SERVER);
        registerMessage(MessageCheckXRay.MessageHandler.class, MessageCheckXRay.class, Side.CLIENT);
    }

    private static <REQ extends IMessage, REPLY extends IMessage> void registerMessage(Class<? extends IMessageHandler<REQ, REPLY>> messageHandler, Class<REQ> requestMessage, cpw.mods.fml.relauncher.Side side) {
        instance.registerMessage(messageHandler, requestMessage, channel++, side);
    }
}
