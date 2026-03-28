package com.yourname.helloplugin;

import com.yourname.helloplugin.listeners.PlayerListener;
import org.bukkit.plugin.java.JavaPlugin;

public class HelloPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("HelloPlugin enabled!");

        saveDefaultConfig();

        getCommand("hello").setExecutor(new HelloCommand());

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