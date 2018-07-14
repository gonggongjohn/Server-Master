package com.gonggongjohn.servermaster;

import com.gonggongjohn.servermaster.server.PlayerCheckManager;
import com.gonggongjohn.servermaster.server.cmd.CommandLoader;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;

public class ServerProxy extends CommonProxy {
    public static final PlayerCheckManager CHECK_MANAGER = new PlayerCheckManager();

    @Override
    public void preInit(FMLPreInitializationEvent e) {
        super.preInit(e);
    }

    @Override
    public void init(FMLInitializationEvent e) {
        super.init(e);
    }

    @Override
    public void postInit(FMLPostInitializationEvent e) {
        super.postInit(e);
    }

    @Override
    public void serverStarting(FMLServerStartingEvent e) {
        super.serverStarting(e);
        new CommandLoader(e);
    }
}
