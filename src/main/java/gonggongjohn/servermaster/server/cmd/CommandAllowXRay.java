package gonggongjohn.servermaster.server.cmd;

import gonggongjohn.servermaster.server.ServerConstants;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;

public class CommandAllowXRay extends CommandBase {

    @Override
    public String getCommandName() {
        return "allowxray";
    }

    @Override
    public String getCommandUsage(ICommandSender p_71518_1_) {
        return null;
    }

    @Override
    public void processCommand(ICommandSender sender, String[] args) {
        ServerConstants.allowXRay = args[0].equals("true");
    }

    @Override
    public int getRequiredPermissionLevel() {
        return 3;
    }
}
