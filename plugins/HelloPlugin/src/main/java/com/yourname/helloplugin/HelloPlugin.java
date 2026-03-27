package com.yourname.helloplugin;

import org.bukkit.plugin.java.JavaPlugin;

public class HelloPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("HelloPlugin enabled!");
        getCommand("hello").setExecutor(new HelloCommand());
    }

    @Override
    public void onDisable() {
        getLogger().info("HelloPlugin disabled!");
    }
}