package wiki.thesarthakdev.getPing.commands;

import net.kyori.adventure.text.Component;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import wiki.thesarthakdev.getPing.getPing;
import wiki.thesarthakdev.getPing.utils.LeaderboardUtils;

public class PingTopCommand implements CommandExecutor {
    private final getPing plugin;

    public PingTopCommand(getPing plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(plugin.getConfig().getString("messages.console_error", "<red>Only players can use this command!"));
            return true;
        }

        Player player = (Player) sender;
        if (!player.hasPermission("getping.pingtop")) {
            player.sendMessage(plugin.getConfig().getString("messages.no_permission", "<red>You do not have permission to use this command!"));
            return true;
        }

        // Get and display the leaderboard
        Component leaderboard = LeaderboardUtils.getLeaderboard(plugin);
        player.sendMessage(leaderboard);
        return true;
    }
}