package wiki.thesarthakdev.getPing.listeners;

import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import wiki.thesarthakdev.getPing.getPing;
import wiki.thesarthakdev.getPing.utils.MessageUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class PingListener implements Listener {
    private final getPing plugin;
    private final MiniMessage miniMessage;
    private final Map<UUID, Long> cooldowns = new HashMap<>();

    public PingListener(getPing plugin) {
        this.plugin = plugin;
        this.miniMessage = MiniMessage.miniMessage();
    }

    @EventHandler
    public void onRightClick(PlayerInteractEntityEvent event) {
        if (event.getRightClicked() instanceof Player) {
            Player player = event.getPlayer();
            if (player.hasPermission("getping.use")) {
                // Check cooldown
                long now = System.currentTimeMillis();
                long lastClick = cooldowns.getOrDefault(player.getUniqueId(), 0L);
                int cooldown = plugin.getConfig().getInt("right_click_cooldown", 3000); // Default 3 seconds

                if (now - lastClick < cooldown) {
                    // Send cooldown message if enabled
                    if (plugin.getConfig().getBoolean("cooldown_message_enabled", true)) {
                        player.sendMessage(miniMessage.deserialize(plugin.getConfig().getString("messages.cooldown_message", "<red>Please wait before checking ping again!")));
                    }
                    return;
                }

                // Update cooldown
                cooldowns.put(player.getUniqueId(), now);

                // Send ping message
                MessageUtils.sendPingMessage(plugin, player, (Player) event.getRightClicked(), "messages.other_ping");
            }
        }
    }
}