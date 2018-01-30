package gonggongjohn.servermaster.network;

import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import gonggongjohn.servermaster.server.ServerConstants;
import io.netty.buffer.ByteBuf;
import net.minecraft.server.MinecraftServer;

public class MessageCheckResult implements IMessage {
    boolean result;
    String player;

    @Override
    public void fromBytes(ByteBuf buf) {
        result = buf.readBoolean();
        player = ByteBufUtils.readUTF8String(buf);
    }

    @Override
    public void toBytes(ByteBuf buf) {
        buf.writeBoolean(result);
        ByteBufUtils.writeUTF8String(buf, player);
    }

    public static class MessageHandler implements IMessageHandler<MessageCheckResult, IMessage> {

        @Override
        public IMessage onMessage(MessageCheckResult message, MessageContext ctx) {
            ServerConstants.checkedPlayers.add(message.player);
            if (message.result) {
                ServerConstants.cheatingPlayers.add(message.player);
                if (!ServerConstants.allowXRay) {
                    MinecraftServer.getServer().getConfigurationManager().func_152612_a(message.player).playerNetServerHandler.kickPlayerFromServer("Do not cheat");
                }
            }
            return null;
        }
    }
}
