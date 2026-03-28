package com.yourname.helloplugin.listeners;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.entity.Player;

public class PlayerListener implements Listener {

    // ① 플레이어 접속 이벤트
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        // 접속 메시지 커스텀
        event.joinMessage(
                Component.text("[+] ")
                        .color(NamedTextColor.GREEN)
                        .append(Component.text(player.getName())
                                .color(NamedTextColor.WHITE))
                        .append(Component.text(" 님이 접속했습니다!")
                                .color(NamedTextColor.GREEN))
        );

        // 접속한 플레이어에게만 개인 환영 메시지
        player.sendMessage(
                Component.text("환영합니다, ")
                        .color(NamedTextColor.YELLOW)
                        .append(Component.text(player.getName())
                                .color(NamedTextColor.GOLD))
                        .append(Component.text("님! /hello 를 입력해보세요.")
                                .color(NamedTextColor.YELLOW))
        );
    }

    // ② 블록 파괴 이벤트
    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        Player player = event.getPlayer();
        String blockType = event.getBlock().getType().name();

        player.sendMessage(
                Component.text("[블록] ")
                        .color(NamedTextColor.AQUA)
                        .append(Component.text(blockType)
                                .color(NamedTextColor.WHITE))
                        .append(Component.text(" 을(를) 파괴했습니다!")
                                .color(NamedTextColor.AQUA))
        );
    }
}