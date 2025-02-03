package wiki.thesarthakdev.getPing.commands;

import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import wiki.thesarthakdev.getPing.getPing;

public class PingReloadCommand implements CommandExecutor {
    private final getPing plugin;
    private final MiniMessage miniMessage;

    public PingReloadCommand(getPing plugin) {
        this.plugin = plugin;
        this.miniMessage = MiniMessage.miniMessage();
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!sender.hasPermission("getping.reload")) {
            sender.sendMessage(miniMessage.deserialize(plugin.getConfig().getString("messages.no_permission", "<red>You do not have permission to use this command!")));
            return true;
        }

        plugin.reloadConfig();
        sender.sendMessage(miniMessage.deserialize(plugin.getConfig().getString("messages.reload_success", "<green>Configuration reloaded successfully!")));
        return true;
    }
}