package gonggongjohn.servermaster.network;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import gonggongjohn.servermaster.ServerMaster;
import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;

public class MessageCheckXRay implements IMessage {
    @Override
    public void fromBytes(ByteBuf buf) {

    }

    @Override
    public void toBytes(ByteBuf buf) {

    }

    public static class MessageHandler implements IMessageHandler<MessageCheckXRay, MessageCheckResult> {

        @Override
        public MessageCheckResult onMessage(MessageCheckXRay message, MessageContext ctx) {
            return new MessageCheckResult(ServerMaster.isXrayEnabled, Minecraft.getMinecraft().thePlayer.getGameProfile().getName());
        }
    }
}
