package com.yourname.helloplugin;

import com.yourname.helloplugin.listeners.PlayerListener;
import org.bukkit.plugin.java.JavaPlugin;

public class HelloPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("HelloPlugin enabled!");

        // config.yml 기본값 저장
        saveDefaultConfig();

        // 커맨드 등록
        getCommand("hello").setExecutor(new HelloCommand());
        getCommand("helloplugin-reload").setExecutor(new ReloadCommand(this));

        // 이벤트 리스너 등록
        getServer().getPluginManager().registerEvents(
                new PlayerListener(this), this
        );

        getLogger().info("HelloPlugin 초기화 완료!");
    }

    @Override
    public void onDisable() {
        getLogger().info("HelloPlugin disabled!");
    }
}