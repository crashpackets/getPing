package wiki.thesarthakdev.getPing.utils;

import net.kyori.adventure.bossbar.BossBar;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.entity.Player;
import wiki.thesarthakdev.getPing.getPing;

public class PingDisplayUtils {
    private static final MiniMessage miniMessage = MiniMessage.miniMessage();

    public static void displayPingInActionBar(getPing plugin, Player player, int ping) {
        String color = (ping < plugin.getConfig().getInt("ping_threshold", 60)) ?
                plugin.getConfig().getString("color_good", "<#9BCF53>") :
                plugin.getConfig().getString("color_bad", "<#FF0000>");

        String message = plugin.getConfig().getString("messages.action_bar_ping", "<green>Your ping: <color>" + ping + "ms</color>")
                .replace("<ping>", String.valueOf(ping))
                .replace("<color>", color);

        player.sendActionBar(miniMessage.deserialize(message));
    }

    public static void displayPingInBossBar(getPing plugin, Player player, int ping) {
        String color = (ping < plugin.getConfig().getInt("ping_threshold", 60)) ?
                plugin.getConfig().getString("color_good", "<#9BCF53>") :
                plugin.getConfig().getString("color_bad", "<#FF0000>");

        String message = plugin.getConfig().getString("messages.boss_bar_ping", "<green>Your ping: <color>" + ping + "ms</color>")
                .replace("<ping>", String.valueOf(ping))
                .replace("<color>", color);

        BossBar bossBar = BossBar.bossBar(
                miniMessage.deserialize(message),
                Math.min((float) ping / 300, 1.0f), // Normalize ping to a value between 0 and 1
                BossBar.Color.GREEN,
                BossBar.Overlay.PROGRESS
        );

        player.showBossBar(bossBar);
    }
}