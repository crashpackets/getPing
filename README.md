[![image](https://github.com/user-attachments/assets/5fa5af61-4414-4fd8-a6f4-faf7ddedf5d6)
](https://cdn.discordapp.com/attachments/1138361189546594304/1335899503714373632/getPing_banner.png?ex=67a1d8dd&is=67a0875d&hm=f7ef124813d01976cea00b0666b09d21ac60f64050e848f8b5d701eb45d0035f&)
# getPing 🌐

![GitHub](https://img.shields.io/badge/License-MIT-green)
![GitHub stars](https://img.shields.io/github/stars/crashpackets/getPing?style=social)

**getPing** is a **lightweight, optimized, and open-source** Minecraft plugin that allows players and server administrators to check ping in multiple ways with **minimal performance impact**. It supports **Action Bar**, **Boss Bar**, and **Chat** displays, along with a **Ping Leaderboard** feature. 🚀

---

## Features ✨

- **Check Ping**: Use `/ping` to check your own ping or `/ping <player>` to check another player's ping. 🕵️‍♂️
- **Right-Click Ping Check**: Right-click on a player to instantly see their ping. 🖱️
- **Ping Leaderboard**: Use `/pingtop` to display the top players with the best ping. 🏆
- **Customizable Messages**: Fully customizable messages and colors via `config.yml`. 🎨
- **Lightweight**: Designed for minimal performance impact. ⚡
- **Open Source**: Free to use, modify, and distribute under the MIT License. 📜

---

## Installation 📥

1. Download the latest `getPing.jar` from the [Releases](https://github.com/crashpackets/getPing/releases) page.
2. Place the `.jar` file in your server's `plugins` folder.
3. Restart your server.
4. Customize the `config.yml` to your liking.

---

## Commands 🛠️

| Command       | Description                          | Permission       |
|---------------|--------------------------------------|------------------|
| `/ping`       | Check your or another player's ping. | `getping.use`    |
| `/pingtop`    | Display the ping leaderboard.        | `getping.pingtop`|
| `/pingreload` | Reload the plugin's configuration.   | `getping.reload` |

---

## Permissions 🔐

| Permission        | Description                          | Default |
|-------------------|--------------------------------------|---------|
| `getping.use`     | Allows using the `/ping` command.    | `true`  |
| `getping.pingtop` | Allows using the `/pingtop` command. | `true`  |
| `getping.reload`  | Allows reloading the configuration.  | `op`    |

---

## Configuration ⚙️

The `config.yml` file allows you to customize:

```yaml
# Ping threshold for color coding
ping_threshold: 60

# Colors for ping
color_good: "<#9BCF53>"  # Color for good ping
color_bad: "<#FF0000>"   # Color for bad ping

# Whether to send ping messages to chat in addition to the action bar
send_to_chat: false

# Cooldown for right-click checks (in milliseconds)
right_click_cooldown: 3000  # 3 seconds

# Whether to enable the cooldown message
cooldown_message_enabled: true

# Action Bar Ping Display
action_bar_ping: "<green>Your ping: <color><ping>ms</color>"

# Boss Bar Ping Display
boss_bar_ping: "<green>Your ping: <color><ping>ms</color>"

# Leaderboard Settings
leaderboard:
  title: "<green>Top %count% Players with Best Ping:</green>"
  entry_format: "<green>%position%. %player%: <color>%ping%ms</color>"
  max_entries: 10  # Maximum number of players to display in the leaderboard

# Messages
messages:
  console_error: "<red>Only players can use this command!"
  no_permission: "<red>You do not have permission to use this command!"
  player_not_found: "<red>Player not found or offline!"
  self_ping: "<green>Your ping is <color><ping>ms!</green>"
  other_ping: "<green><target>'s ping is <color><ping>ms!</green>"
  reload_success: "<green>Configuration reloaded successfully!"
  cooldown_message: "<red>Please wait before checking ping again!"
```
# Example Usage  🎮
## Check Your Ping
`/ping`: Your ping is 20ms!
## Check Another Player's Ping
`/ping Player2`: Player2's ping is 25ms!
## Ping Leaderboard
`/pingtop`: Output ⬇️
```yaml
Top 10 Players with Best Ping:
1. Player1: 20ms
2. Player2: 25ms
3. Player3: 30ms
...
```
# License 📄
This project is licensed under the MIT License. See the LICENSE file for details.
# Support 💬
If you have any questions, issues, or suggestions, feel free to open an issue on GitHub. Or message me on discord @crashpackets
# Enjoy using getPing! 🎉
