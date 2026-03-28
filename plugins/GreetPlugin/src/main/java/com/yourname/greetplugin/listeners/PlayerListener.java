package com.yourname.greetplugin.listeners;

import com.yourname.greetplugin.GreetPlugin;
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerListener implements Listener {

    private final GreetPlugin plugin;

    public PlayerListener(GreetPlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        boolean isFirstJoin = !player.hasPlayedBefore();

        if (isFirstJoin) {
            String joinMsg = plugin.getConfig()
                    .getString("messages.join-first", "§f{player} §6님이 처음으로 접속했습니다! 환영해요!")
                    .replace("{player}", player.getName());

            event.joinMessage(LegacyComponentSerializer.legacySection().deserialize(joinMsg));
            plugin.getLogger().info("[접속-첫방문] " + player.getName());

        } else {
            String joinMsg = plugin.getConfig()
                    .getString("messages.join", "§f{player} §a님이 접속했습니다!")
                    .replace("{player}", player.getName());

            event.joinMessage(LegacyComponentSerializer.legacySection().deserialize(joinMsg));
            plugin.getLogger().info("[접속] " + player.getName());
        }
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();

        String quitMsg = plugin.getConfig()
                .getString("messages.quit", "§f{player} §c님이 접속을 종료했습니다.")
                .replace("{player}", player.getName());

        event.quitMessage(LegacyComponentSerializer.legacySection().deserialize(quitMsg));
        plugin.getLogger().info("[접속종료] " + player.getName());
    }
}