package wiki.thesarthakdev.getPing.commands;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import wiki.thesarthakdev.getPing.getPing;
import wiki.thesarthakdev.getPing.utils.LeaderboardUtils;

import java.util.List;

public class PingTopCommand implements CommandExecutor {
    private final getPing plugin;
    private final MiniMessage miniMessage;

    public PingTopCommand(getPing plugin) {
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
        if (!player.hasPermission("getping.pingtop")) {
            player.sendMessage(miniMessage.deserialize(plugin.getConfig().getString("messages.no_permission", "<red>You do not have permission to use this command!")));
            return true;
        }

        // Get the leaderboard
        List<Player> leaderboard = LeaderboardUtils.getPingLeaderboard(plugin);

        // Display the leaderboard
        Component message = miniMessage.deserialize("<green>Top 10 Players with Best Ping:</green>\n");
        for (int i = 0; i < Math.min(leaderboard.size(), 10); i++) {
            Player target = leaderboard.get(i);
            int ping = target.getPing();
            message = message.append(miniMessage.deserialize("<green>" + (i + 1) + ". " + target.getName() + ": <color>" + ping + "ms</color>\n"));
        }

        player.sendMessage(message);
        return true;
    }
}