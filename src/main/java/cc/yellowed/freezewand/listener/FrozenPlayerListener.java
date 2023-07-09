package cc.yellowed.freezewand.listener;

import cc.yellowed.freezewand.instance.Profile;
import cc.yellowed.freezewand.manager.ProfileManager;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerMoveEvent;

public class FrozenPlayerListener implements Listener {

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent e) {
        Player player = e.getPlayer();
        Profile profile = ProfileManager.getByUUID(player.getUniqueId());

        if (profile.getFrozen()) {
            e.setCancelled(true);
            player.sendMessage(ChatColor.RED + "You can't move while " + ChatColor.AQUA + "frozen.");
        }
    }

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent e) {
        Player player = e.getPlayer();
        Profile profile = ProfileManager.getByUUID(player.getUniqueId());

        if (profile.getFrozen()) {
            e.setCancelled(true);
            player.sendMessage(ChatColor.RED + "You can't place a block while " + ChatColor.AQUA + "frozen.");
        }
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent e) {
        Player player = e.getPlayer();
        Profile profile = ProfileManager.getByUUID(player.getUniqueId());

        if (profile.getFrozen()) {
            e.setCancelled(true);
            player.sendMessage(ChatColor.RED + "You can't break a block while " + ChatColor.AQUA + "frozen.");
        }
    }

    @EventHandler
    public void onEntityDamageByEntity(EntityDamageByEntityEvent e) {
        if (!(e.getDamager() instanceof Player)) {
            return;
        }

        Player player = (Player) e.getDamager();
        Profile profile = ProfileManager.getByUUID(player.getUniqueId());

        if (profile.getFrozen()) {
            e.setCancelled(true);
            player.sendMessage(ChatColor.RED + "You can't attack while " + ChatColor.AQUA + "frozen.");
        }

    }


}
