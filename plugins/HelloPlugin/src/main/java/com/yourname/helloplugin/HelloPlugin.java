package com.yourname.helloplugin;

import com.yourname.helloplugin.listeners.PlayerListener;
import org.bukkit.plugin.java.JavaPlugin;

public class HelloPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("HelloPlugin enabled!");

        // 커맨드 등록
        getCommand("hello").setExecutor(new HelloCommand());

        // 이벤트 리스너 등록
        getServer().getPluginManager().registerEvents(
                new PlayerListener(), this
        );

        getLogger().info("이벤트 리스너 등록 완료!");
    }

    @Override
    public void onDisable() {
        getLogger().info("HelloPlugin disabled!");
    }
}