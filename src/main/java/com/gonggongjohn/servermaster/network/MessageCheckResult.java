package com.gonggongjohn.servermaster.network;

import com.gonggongjohn.servermaster.ServerProxy;
import com.gonggongjohn.servermaster.server.ServerConstants;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;

public class MessageCheckResult implements IMessage {
    /**
     * true:玩家作弊
     * false:玩家正常
     */
    boolean result;

    @Override
    public void fromBytes(ByteBuf buf) {
        result = buf.readBoolean();
    }

    @Override
    public void toBytes(ByteBuf buf) {
        buf.writeBoolean(result);
    }

    public static class MessageHandler implements IMessageHandler<MessageCheckResult, IMessage> {

        @Override
        public IMessage onMessage(MessageCheckResult message, MessageContext ctx) {
            EntityPlayer player = ctx.getServerHandler().playerEntity;
            ServerProxy.CHECK_MANAGER.checkPassed(player.getGameProfile().getName());
            if (message.result) {
                ServerConstants.cheatingPlayers.add(player.getGameProfile().getName());
                if (!ServerConstants.allowCheat) {
                    ((EntityPlayerMP) player).playerNetServerHandler.kickPlayerFromServer("Do not cheat");
                }
            }
            return null;
        }
    }
}
