package gonggongjohn.servermaster.network;

import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.relauncher.Side;
import gonggongjohn.servermaster.ServerMaster;

public class NetworkLoader {
    public static SimpleNetworkWrapper instance = NetworkRegistry.INSTANCE.newSimpleChannel(ServerMaster.MODID);

    public NetworkLoader() {
        instance.registerMessage(MessageCheckResult.MessageHandler.class, MessageCheckResult.class, 0, Side.SERVER);
        instance.registerMessage(MessageCheckXRay.MessageHandler.class, MessageCheckXRay.class, 1, Side.CLIENT);
    }
}
