package com.gonggongjohn.servermaster.network;

import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import com.gonggongjohn.servermaster.server.ServerConstants;
import io.netty.buffer.ByteBuf;
import net.minecraft.server.MinecraftServer;

public class MessageCheckResult implements IMessage {
    public boolean result;
    public float gamma;
    public String player;

    @Override
    public void fromBytes(ByteBuf buf) {
        result = buf.readBoolean();
        gamma = buf.readFloat();
        player = ByteBufUtils.readUTF8String(buf);
    }

    @Override
    public void toBytes(ByteBuf buf) {
        buf.writeBoolean(result);
        buf.writeFloat(gamma);
        ByteBufUtils.writeUTF8String(buf, player);
    }

    public static class MessageHandler implements IMessageHandler<MessageCheckResult, IMessage> {

        @Override
        public IMessage onMessage(MessageCheckResult message, MessageContext ctx) {
            if (ServerConstants.checkedPlayers.contains(message.player)) {
                return null;
            }

            ServerConstants.checkedPlayers.add(message.player);
            if (message.result || message.gamma > 1.0) {
                ServerConstants.cheatingPlayers.add(message.player);
                if (!ServerConstants.allowCheat) {
                    MinecraftServer.getServer().getConfigurationManager().func_152612_a(message.player).playerNetServerHandler.kickPlayerFromServer("Do not cheat");
                }
            }
            return null;
        }
    }
}
