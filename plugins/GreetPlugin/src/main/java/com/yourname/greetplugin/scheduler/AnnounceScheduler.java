package com.yourname.greetplugin.scheduler;

import com.yourname.greetplugin.GreetPlugin;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;
import org.bukkit.scheduler.BukkitRunnable;

public class AnnounceScheduler extends BukkitRunnable {

    private final GreetPlugin plugin;

    public AnnounceScheduler(GreetPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public void run() {
        // 온라인 플레이어가 없으면 공지 생략
        if (plugin.getServer().getOnlinePlayers().isEmpty()) return;

        String message = plugin.getConfig().getString(
                "announce.message", "§e[공지] §f서버 공지입니다!"
        );

        Component component = LegacyComponentSerializer
                .legacySection()
                .deserialize(message);

        plugin.getServer().broadcast(component);
    }
}