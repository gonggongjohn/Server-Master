package com.gonggongjohn.servermaster;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import com.gonggongjohn.servermaster.network.NetworkLoader;

public class CommonProxy {
    public void preInit(FMLPreInitializationEvent e) {
        new NetworkLoader();
    }

    public void init(FMLInitializationEvent e) {

    }

    public void postInit(FMLPostInitializationEvent e) {

    }

    public void serverStarting(FMLServerStartingEvent e) {

    }
}
