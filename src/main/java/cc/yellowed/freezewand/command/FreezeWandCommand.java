package cc.yellowed.freezewand.command;

import cc.yellowed.freezewand.Main;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

public class FreezeWandCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if (!(commandSender instanceof Player)) {
            return false;
        }

        Player player = (Player) commandSender;

        ItemStack wand = new ItemStack(Material.STICK);
        ItemMeta meta = wand.getItemMeta();
        meta.getPersistentDataContainer().set(new NamespacedKey(Main.getMain(), "isFreezeWand"), PersistentDataType.BOOLEAN, true);
        meta.setDisplayName(ChatColor.AQUA + "Freeze Wand");
        wand.setItemMeta(meta);

        player.getInventory().addItem(wand);

        return true;
    }
}
