package com.gonggongjohn.servermaster.network;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import com.gonggongjohn.servermaster.Checker;
import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;

public class MessageCheckCheat implements IMessage {
    @Override
    public void fromBytes(ByteBuf buf) {

    }

    @Override
    public void toBytes(ByteBuf buf) {

    }

    public static class MessageHandler implements IMessageHandler<MessageCheckCheat, MessageCheckResult> {

        @Override
        public MessageCheckResult onMessage(MessageCheckCheat message, MessageContext ctx) {
            MessageCheckResult msg = new MessageCheckResult();
            msg.player = Minecraft.getMinecraft().thePlayer.getGameProfile().getName();
            msg.result = Checker.initChecker();
            msg.gamma = Minecraft.getMinecraft().gameSettings.gammaSetting;
            return msg;
        }
    }
}
