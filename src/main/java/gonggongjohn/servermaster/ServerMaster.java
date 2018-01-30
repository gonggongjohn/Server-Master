package gonggongjohn.servermaster;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

import javax.swing.*;

@Mod(modid = ServerMaster.MODID, name = ServerMaster.NAME, version = ServerMaster.VERSION, useMetadata = true)
public class ServerMaster {
	public static final String MODID = "servermaster";
	public static final String NAME = "Server Master";
	public static final String VERSION = "1.0.0";
    public static boolean isXrayEnabled = false;

    @SidedProxy(clientSide="gonggongjohn.servermaster.CilentProxy", serverSide="gonggongjohn.servermaster.ServerProxy")
    public static CommonProxy proxy;

	@Mod.Instance
    public static ServerMaster instance = new ServerMaster();

	@Mod.EventHandler
    public void preInit(FMLPreInitializationEvent e){
        isXrayEnabled = Checker.initChecker();
        if(isXrayEnabled){
            JOptionPane.showMessageDialog(null,
                    "Sorry,We Have Detected X-Ray In You Pack,Delete It Now!", "Server Guard v1.0.0", JOptionPane.ERROR_MESSAGE);
            FMLCommonHandler.instance().exitJava(1, true);
        }
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent e){

    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent e){

    }
}
