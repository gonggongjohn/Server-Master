package gonggongjohn.servermaster.server;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;
import gonggongjohn.servermaster.network.MessageCheckXRay;
import gonggongjohn.servermaster.network.NetworkLoader;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.common.MinecraftForge;

import java.util.ArrayList;
import java.util.List;

public class EventHandler {
    public static List<String> checkedPlayers = new ArrayList<String>();
    public static List<String> cheatingPlayers = new ArrayList<String>();

    public EventHandler() {
        FMLCommonHandler.instance().bus().register(this);
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
        NetworkLoader.instance.sendTo(new MessageCheckXRay(), (EntityPlayerMP) event.player);
    }

    @SubscribeEvent
    public void onPlayerLoggedOut(PlayerEvent.PlayerLoggedOutEvent event) {
        if (checkedPlayers.contains(event.player.getGameProfile().getName()))
            checkedPlayers.remove(event.player.getGameProfile().getName());
    }
}