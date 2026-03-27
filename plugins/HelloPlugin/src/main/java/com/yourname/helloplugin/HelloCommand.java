package com.yourname.helloplugin;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;

public class HelloCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command,
                             String label, String[] args) {

        if (!(sender instanceof Player player)) {
            sender.sendMessage("플레이어만 사용할 수 있습니다!");
            return true;
        }

        player.sendMessage(
                Component.text("안녕하세요, ")
                        .color(NamedTextColor.YELLOW)
                        .append(Component.text(player.getName())
                                .color(NamedTextColor.GOLD))
                        .append(Component.text("님!")
                                .color(NamedTextColor.YELLOW))
        );

        return true;
    }
}