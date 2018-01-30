package gonggongjohn.servermaster;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;

@Mod(modid = ServerMaster.MODID, name = ServerMaster.NAME, version = ServerMaster.VERSION, useMetadata = true)
public class ServerMaster {
    public static final String MODID = "servermaster";
    public static final String NAME = "Server Master";
    public static final String VERSION = "1.0.0";

    @SidedProxy(clientSide = "gonggongjohn.servermaster.CilentProxy", serverSide = "gonggongjohn.servermaster.ServerProxy")
    public static CommonProxy proxy;

    @Mod.Instance
    public static ServerMaster instance = new ServerMaster();

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent e) {
        proxy.preInit(e);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent e) {
        proxy.init(e);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent e) {
        proxy.postInit(e);
    }

    @Mod.EventHandler
    public void serverStarting(FMLServerStartingEvent e) {
        proxy.serverStarting(e);
    }
}
