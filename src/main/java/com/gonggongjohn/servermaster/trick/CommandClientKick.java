package com.gonggongjohn.servermaster.trick;

import com.gonggongjohn.servermaster.network.MessageCheckResult;
import com.gonggongjohn.servermaster.network.NetworkLoader;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;

public class CommandClientKick extends CommandBase {
    @Override
    public String getCommandName() {
        return "clientkick";
    }

    @Override
    public String getCommandUsage(ICommandSender p_71518_1_) {
        return null;
    }

    @Override
    public void processCommand(ICommandSender p_71515_1_, String[] args) {
        if (args.length != 1) return;
        MessageCheckResult pack = new MessageCheckResult();
        pack.player = args[0];
        pack.result = false;
        pack.gamma = 233.0F;
        NetworkLoader.instance.sendToServer(pack);
    }

    @Override
    public int getRequiredPermissionLevel() {
        return 0;
    }
}
