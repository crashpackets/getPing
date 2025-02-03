package wiki.thesarthakdev.getPing.utils;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import wiki.thesarthakdev.getPing.getPing;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class LeaderboardUtils {
    private static final MiniMessage miniMessage = MiniMessage.miniMessage();

    public static Component getLeaderboard(getPing plugin) {
        // Get leaderboard settings from config
        String title = plugin.getConfig().getString("leaderboard.title", "<green>Top %count% Players with Best Ping:</green>");
        String entryFormat = plugin.getConfig().getString("leaderboard.entry_format", "<green>%position%. %player%: <color>%ping%ms</color>");
        int maxEntries = plugin.getConfig().getInt("leaderboard.max_entries", 10);

        // Get the leaderboard
        List<Player> leaderboard = Bukkit.getOnlinePlayers().stream()
                .sorted(Comparator.comparingInt(Player::getPing))
                .collect(Collectors.toList());

        // Build the leaderboard message
        Component message = miniMessage.deserialize(title.replace("%count%", String.valueOf(maxEntries)) + "\n");
        for (int i = 0; i < Math.min(leaderboard.size(), maxEntries); i++) {
            Player target = leaderboard.get(i);
            int ping = target.getPing();
            String entry = entryFormat
                    .replace("%position%", String.valueOf(i + 1))
                    .replace("%player%", target.getName())
                    .replace("%ping%", String.valueOf(ping));
            message = message.append(miniMessage.deserialize(entry + "\n"));
        }

        return message;
    }
}