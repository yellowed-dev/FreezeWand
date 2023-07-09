package cc.yellowed.freezewand.listener;

import cc.yellowed.freezewand.Main;
import cc.yellowed.freezewand.instance.Profile;
import cc.yellowed.freezewand.manager.ProfileManager;
import org.bukkit.ChatColor;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

public class FreezeWandListener implements Listener {

    @EventHandler
    public void onPlayerIntectAtEntity(PlayerInteractAtEntityEvent e) {

        if (!(e.getRightClicked() instanceof Player)) {
            return;
        }

        if (e.getHand() != EquipmentSlot.HAND) {
            return;
        }

        Player clicker = e.getPlayer();
        Player target = (Player) e.getRightClicked();

        ItemStack itemInHand = clicker.getInventory().getItemInMainHand();
        ItemMeta meta = itemInHand.getItemMeta();
        if (meta == null || !meta.getPersistentDataContainer().has(new NamespacedKey(Main.getMain(), "isFreezeWand"), PersistentDataType.BOOLEAN)) {
            return;
        }

        Profile targetProfile = ProfileManager.getByUUID(target.getUniqueId());
        targetProfile.setFrozen(!targetProfile.getFrozen());

        target.sendMessage(ChatColor.DARK_GRAY + "You have been " + ChatColor.AQUA + (targetProfile.getFrozen() ? "" : "un") + "frozen!");
        clicker.sendMessage(ChatColor.GOLD + target.getName() + ChatColor.DARK_GRAY + " has been " + ChatColor.AQUA + (targetProfile.getFrozen() ? "" : "un") + "frozen.");

    }
}
