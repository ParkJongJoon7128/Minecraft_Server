package com.yourname.spawnplugin;

import com.yourname.spawnplugin.commands.SpawnCommand;
import org.bukkit.plugin.java.JavaPlugin;

public class SpawnPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("SpawnPlugin enabled!");

        saveDefaultConfig();

        getCommand("spawn").setExecutor(new SpawnCommand(this));

        getLogger().info("SpawnPlugin 초기화 완료!");
    }

    @Override
    public void onDisable() {
        getLogger().info("SpawnPlugin disabled!");
    }
}