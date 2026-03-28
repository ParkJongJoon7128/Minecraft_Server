package com.yourname.helloplugin;

import com.yourname.helloplugin.listeners.PlayerListener;
import com.yourname.helloplugin.scheduler.AnnounceScheduler;
import org.bukkit.plugin.java.JavaPlugin;

public class HelloPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("HelloPlugin enabled!");

        // config.yml 기본값 저장 (없으면 자동 생성)
        saveDefaultConfig();

        // 커맨드 등록
        getCommand("hello").setExecutor(new HelloCommand());
        getCommand("helloplugin-reload").setExecutor(new ReloadCommand(this));

        // 이벤트 리스너 등록
        getServer().getPluginManager().registerEvents(
                new PlayerListener(this), this
        );

        // 스케줄러 시작
        boolean announceEnabled = getConfig().getBoolean("announce.enabled", true);
        if (announceEnabled) {
            int interval = getConfig().getInt("announce.interval", 600);
            new AnnounceScheduler(this).runTaskTimer(this, interval, interval);
            getLogger().info("공지 스케줄러 시작! (" + interval + "틱 간격)");
        }

        getLogger().info("HelloPlugin 초기화 완료!");
    }

    @Override
    public void onDisable() {
        getLogger().info("HelloPlugin disabled!");
    }
}