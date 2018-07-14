package com.gonggongjohn.servermaster.server;

import com.gonggongjohn.servermaster.network.MessageCheckCheat;
import com.gonggongjohn.servermaster.network.NetworkHandler;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraftforge.common.MinecraftForge;

import java.util.concurrent.ConcurrentLinkedQueue;

public class PlayerCheckManager {
    private ConcurrentLinkedQueue<CheckingPlayer> cq = new ConcurrentLinkedQueue<>();

    public PlayerCheckManager() {
        FMLCommonHandler.instance().bus().register(this);
        MinecraftForge.EVENT_BUS.register(this);
        Thread CHECKING_THREAD = new Thread(() -> {
            while (!cq.isEmpty()) {
                for (CheckingPlayer cp : cq) {
                    if (cp != null && System.currentTimeMillis() - cp.startTime > 10000) {
                        MinecraftServer.getServer().getConfigurationManager().func_152612_a(cp.name).playerNetServerHandler.kickPlayerFromServer("Server-master checker timed out.");
                    }
                }
            }
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "ServerMaster-CHECKER");
        CHECKING_THREAD.start();
    }

    @SubscribeEvent
    public void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
        NetworkHandler.instance.sendTo(new MessageCheckCheat(), (EntityPlayerMP) event.player);
        cq.add(new CheckingPlayer(event.player.getGameProfile().getName()));
    }

    public void checkPassed(String name) {
        CheckingPlayer remove = null;
        for (CheckingPlayer p : cq) {
            if (p.name.equals(name)) {
                remove = p;
                break;
            }
        }
        if (remove != null) {
            cq.remove(remove);
        }
    }

    private static class CheckingPlayer {
        String name;
        long startTime;

        CheckingPlayer(String name) {
            this.name = name;
            startTime = System.currentTimeMillis();
        }
    }
}
