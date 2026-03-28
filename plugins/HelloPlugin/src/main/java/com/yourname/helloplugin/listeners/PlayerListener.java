package com.yourname.helloplugin.listeners;

import com.yourname.helloplugin.HelloPlugin;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.entity.Player;

public class PlayerListener implements Listener {

    private final HelloPlugin plugin;

    public PlayerListener(HelloPlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        // config 에서 메시지 읽기
        String joinMsg = plugin.getConfig()
                .getString("messages.join", "§a{player} 님이 접속했습니다!")
                .replace("{player}", player.getName());

        String welcomeMsg = plugin.getConfig()
                .getString("messages.welcome", "§e환영합니다, {player}님!")
                .replace("{player}", player.getName());

        // 전체 접속 메시지
        event.joinMessage(
                LegacyComponentSerializer.legacySection().deserialize(joinMsg)
        );

        // 개인 환영 메시지
        player.sendMessage(
                LegacyComponentSerializer.legacySection().deserialize(welcomeMsg)
        );
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        Player player = event.getPlayer();
        String blockType = event.getBlock().getType().name();

        String blockMsg = plugin.getConfig()
                .getString("messages.block-break", "§b[블록] §f{block} 을(를) 파괴했습니다!")
                .replace("{block}", blockType);

        player.sendMessage(
                LegacyComponentSerializer.legacySection().deserialize(blockMsg)
        );
    }
}