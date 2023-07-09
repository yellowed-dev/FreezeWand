package cc.yellowed.freezewand;

import cc.yellowed.freezewand.command.FreezeWandCommand;
import cc.yellowed.freezewand.listener.ConnectionListener;
import cc.yellowed.freezewand.listener.FreezeWandListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    private static Main main;

    @Override
    public void onEnable() {
        main = this;

        getCommand("freezewand").setExecutor(new FreezeWandCommand());

        Bukkit.getPluginManager().registerEvents(new ConnectionListener(), this);
        Bukkit.getPluginManager().registerEvents(new FreezeWandListener(), this);


    }

    public static Main getMain() {
        return main;
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
