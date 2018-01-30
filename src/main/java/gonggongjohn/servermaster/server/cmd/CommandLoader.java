package gonggongjohn.servermaster.server.cmd;

import cpw.mods.fml.common.event.FMLServerStartingEvent;

public class CommandLoader {
    public CommandLoader(FMLServerStartingEvent event) {
        event.registerServerCommand(new CommandAllowCheat());
        event.registerServerCommand(new CommandShowCheaters());
    }
}
