# 🏓 getPing - A Simple Minecraft Ping Checker Plugin

Welcome to **getPing**! 🎮 This plugin allows players to check their ping in Minecraft with simple commands, displaying the result either in the action bar or a boss bar. You can also view a ping leaderboard, check others' pings, and use a right-click function with a cooldown to display ping. 🚀

## 📜 Features  
✅ **Player Ping** – Check your ping or another player's ping with ease.  
✅ **Ping Leaderboard** – View the top 10 players with the best ping! 📊  
✅ **Right-Click Ping Check** – Right-click on a player to check their ping (with cooldown).  
✅ **Configurable Ping Display** – Display ping in the action bar or boss bar.  
✅ **Permission-Based Commands** – Control access to commands through permissions. 🔒  
✅ **Customizable Messages** – Edit messages and settings through the config file. 🎨  

## 🛠️ Installation  

1. **Download** the latest version of `getPing`.
2. Place the `getPing.jar` file into the `plugins` folder of your Minecraft server.  
3. Start your server to generate the configuration files.  
4. Edit `config.yml` to customize the messages, ping threshold, and cooldown settings.
5. Reload the server or plugin using the `/pingreload` command.

## 📝 Commands & Permissions

### Commands  
- **`/ping [player]`**  
  - Check your own or another player's ping.  
  - Permission: `getping.use`

- **`/pingtop`**  
  - View the leaderboard of players with the best ping.  
  - Permission: `getping.pingtop`

- **`/pingreload`**  
  - Reload the plugin's configuration.  
  - Permission: `getping.reload`

### Permissions  
- `getping.use` – Allows players to use the `/ping` command and right-click ping check.  
- `getping.pingtop` – Allows players to use the `/pingtop` command.  
- `getping.reload` – Allows players to reload the plugin configuration using `/pingreload`.  

## ⚙️ Configuration  
The plugin’s settings can be customized in the `config.yml` file. Here are some of the configurable options:

- **`ping_threshold`** – Set the threshold for good and bad ping color coding.  
- **`color_good`** – Customize the color for good ping.  
- **`color_bad`** – Customize the color for bad ping.  
- **`send_to_chat`** – Option to send ping messages to the chat as well as the action bar.  
- **`right_click_cooldown`** – Time (in milliseconds) between right-click ping checks.  
- **`cooldown_message_enabled`** – Enable/disable cooldown messages when players try to check ping too quickly.  

## 🏆 Ping Leaderboard  
The `/pingtop` command shows the top 10 players with the best ping. The leaderboard is automatically sorted based on the players' ping.

## 👨‍💻 Example Usage  
- **`/ping`** – Check your own ping.  
- **`/ping [player]`** – Check another player's ping (replace `[player]` with their name).  
- **`/pingtop`** – View the top players with the best ping.

## 📖 Messages  
You can customize various messages in the `config.yml`:

- **Action Bar** – Ping message displayed in the action bar.  
- **Boss Bar** – Ping message displayed in the boss bar.  
- **Cooldown Message** – Message sent if the player tries to check ping too quickly.  

## 📡 Support & Contact  
For any issues or feature requests, feel free to reach out! You can contact us via GitHub Issues or join our community Discord server for feedback and support.
