package wiki.thesarthakdev.getPing.utils;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.entity.Player;
import wiki.thesarthakdev.getPing.getPing;

public class MessageUtils {
    private static final MiniMessage miniMessage = MiniMessage.miniMessage();

    public static void sendPingMessage(getPing plugin, Player sender, Player target, String messagePath) {
        int ping = target.getPing();
        int threshold = plugin.getConfig().getInt("ping_threshold", 60);
        String color = (ping < threshold) ? plugin.getConfig().getString("color_good", "<#9BCF53>") : plugin.getConfig().getString("color_bad", "<#FF0000>");

        String message = plugin.getConfig().getString(messagePath, "<green><target>'s ping is <color><ping>ms!</green>")
                .replace("<target>", target.getName())
                .replace("<ping>", String.valueOf(ping))
                .replace("<color>", color);

        Component msg = miniMessage.deserialize(message);
        sender.sendActionBar(msg);

        // Optionally send to chat if enabled in config
        if (plugin.getConfig().getBoolean("send_to_chat", false)) {
            sender.sendMessage(msg);
        }
    }
}