package wiki.thesarthakdev.getPing.utils;

import wiki.thesarthakdev.getPing.getPing;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class LeaderboardUtils {
    public static List<Player> getPingLeaderboard(getPing plugin) {
        return Bukkit.getOnlinePlayers().stream()
                .sorted(Comparator.comparingInt(Player::getPing))
                .collect(Collectors.toList());
    }
}