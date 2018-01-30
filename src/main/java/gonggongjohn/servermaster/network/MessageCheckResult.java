package gonggongjohn.servermaster.network;

import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import gonggongjohn.servermaster.server.EventHandler;
import io.netty.buffer.ByteBuf;

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
            System.out.println("Received package");
            EventHandler.checkedPlayers.add(message.player);
            if (message.result) {
                EventHandler.cheatingPlayers.add(message.player);
            }
            return null;
        }
    }
}
