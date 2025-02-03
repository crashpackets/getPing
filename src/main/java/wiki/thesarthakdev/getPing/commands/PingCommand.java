package wiki.thesarthakdev.getPing.commands;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import wiki.thesarthakdev.getPing.getPing;
import wiki.thesarthakdev.getPing.utils.MessageUtils;

public class PingCommand implements CommandExecutor {
    private final getPing plugin;
    private final MiniMessage miniMessage;

    public PingCommand(getPing plugin) {
        this.plugin = plugin;
        this.miniMessage = MiniMessage.miniMessage();
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(miniMessage.deserialize(plugin.getConfig().getString("messages.console_error", "<red>Only players can use this command!")));
            return true;
        }

        Player player = (Player) sender;
        if (!player.hasPermission("getping.use")) {
            player.sendMessage(miniMessage.deserialize(plugin.getConfig().getString("messages.no_permission", "<red>You do not have permission to use this command!")));
            return true;
        }

        if (args.length == 0) {
            MessageUtils.sendPingMessage(plugin, player, player, "messages.self_ping");
        } else {
            Player target = Bukkit.getPlayer(args[0]);
            if (target == null || !target.isOnline()) {
                player.sendMessage(miniMessage.deserialize(plugin.getConfig().getString("messages.player_not_found", "<red>Player not found or offline!")));
                return true;
            }
            MessageUtils.sendPingMessage(plugin, player, target, "messages.other_ping");
        }
        return true;
    }
}