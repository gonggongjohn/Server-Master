package com.gonggongjohn.servermaster;

import com.gonggongjohn.servermaster.server.PlayerCheckManager;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import com.gonggongjohn.servermaster.server.EventHandler;
import com.gonggongjohn.servermaster.server.cmd.CommandLoader;

public class ServerProxy extends CommonProxy {
    public static final PlayerCheckManager CHECK_MANAGER = new PlayerCheckManager();

    @Override
    public void preInit(FMLPreInitializationEvent e) {
        super.preInit(e);
    }

    @Override
    public void init(FMLInitializationEvent e) {
        super.init(e);
        new EventHandler();
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
