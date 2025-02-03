package wiki.thesarthakdev.getPing;

import org.bukkit.plugin.java.JavaPlugin;
import wiki.thesarthakdev.getPing.commands.PingCommand;
import wiki.thesarthakdev.getPing.commands.PingReloadCommand;
import wiki.thesarthakdev.getPing.listeners.PingListener;

public class getPing extends JavaPlugin {

    @Override
    public void onEnable() {
        // Save and load configuration
        saveDefaultConfig();

        // Register commands
        getCommand("ping").setExecutor(new PingCommand(this));
        getCommand("pingreload").setExecutor(new PingReloadCommand(this));

        // Register event listener
        getServer().getPluginManager().registerEvents(new PingListener(this), this);
    }
}