package com.gonggongjohn.servermaster.server.cmd;

import com.gonggongjohn.servermaster.server.ServerConstants;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.ChatComponentTranslation;

public class CommandShowCheaters extends CommandBase {
    @Override
    public String getCommandName() {
        return "showcheaters";
    }

    @Override
    public String getCommandUsage(ICommandSender p_71518_1_) {
        return null;
    }

    @Override
    public void processCommand(ICommandSender sender, String[] args) {
        ServerConstants.cheatingPlayers.forEach((s) -> CommandBase.getCommandSenderAsPlayer(sender).addChatComponentMessage(new ChatComponentTranslation(s)));
    }

    @Override
    public int getRequiredPermissionLevel() {
        return 3;
    }
}
