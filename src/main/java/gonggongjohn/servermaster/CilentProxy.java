package gonggongjohn.servermaster;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;


public class CilentProxy extends CommonProxy{



    @Override
    public void preInit(FMLPreInitializationEvent e) {
        super.preInit(e);
        ServerMaster.isXrayEnabled = Checker.initChecker();
    }

    @Override
    public void init(FMLInitializationEvent e) {
        super.init(e);
    }

    @Override
    public void postInit(FMLPostInitializationEvent e) {
        super.postInit(e);
    }
}
