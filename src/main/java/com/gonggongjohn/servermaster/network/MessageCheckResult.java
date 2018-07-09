package com.gonggongjohn.servermaster.network;

import com.gonggongjohn.servermaster.ServerProxy;
import com.gonggongjohn.servermaster.server.ServerConstants;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import io.netty.buffer.ByteBuf;

public class MessageCheckResult implements IMessage {
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
            String player = ctx.getServerHandler().playerEntity.getGameProfile().getName();
            ServerProxy.CHECK_MANAGER.checkPassed(player);
            if (message.result) {
                ServerConstants.cheatingPlayers.add(player);
                if (!ServerConstants.allowCheat) {
                    ctx.getServerHandler().playerEntity.playerNetServerHandler.kickPlayerFromServer("Do not cheat");
                }
            }
            return null;
        }
    }
}
