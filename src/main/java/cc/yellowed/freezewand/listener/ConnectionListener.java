package cc.yellowed.freezewand.listener;

import cc.yellowed.freezewand.instance.Profile;
import cc.yellowed.freezewand.manager.ProfileManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class ConnectionListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        ProfileManager.register(e.getPlayer().getUniqueId());
    }

}
