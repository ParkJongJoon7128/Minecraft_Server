package com.yourname.greetplugin;

import com.yourname.greetplugin.listeners.PlayerListener;
import org.bukkit.plugin.java.JavaPlugin;

public class GreetPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("GreetPlugin enabled!");

        saveDefaultConfig();

        getCommand("hello").setExecutor(new GreetCommand());

        getServer().getPluginManager().registerEvents(
                new PlayerListener(this), this
        );

        getLogger().info("GreetPlugin 초기화 완료!");
    }

    @Override
    public void onDisable() {
        getLogger().info("GreetPlugin disabled!");
    }
}