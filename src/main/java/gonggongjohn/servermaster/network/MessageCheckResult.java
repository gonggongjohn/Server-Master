package gonggongjohn.servermaster.network;

import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import io.netty.buffer.ByteBuf;

public class MessageCheckResult implements IMessage {
    boolean result;
    String player;

    public MessageCheckResult(boolean result, String player) {
        this.result = result;
        this.player = player;
    }

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

            return null;
        }
    }
}
