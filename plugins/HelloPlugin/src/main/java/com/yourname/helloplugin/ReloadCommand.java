package com.yourname.helloplugin;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class ReloadCommand implements CommandExecutor {

    private final HelloPlugin plugin;

    public ReloadCommand(HelloPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command,
                             String label, String[] args) {

        plugin.reloadConfig();

        sender.sendMessage(
                Component.text("[HelloPlugin] ")
                        .color(NamedTextColor.GREEN)
                        .append(Component.text("config.yml 이 재로드되었습니다!")
                                .color(NamedTextColor.WHITE))
        );

        return true;
    }
}