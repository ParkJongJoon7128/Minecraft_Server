package com.yourname.spawnplugin.commands;

import com.yourname.spawnplugin.SpawnPlugin;
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SpawnCommand implements CommandExecutor {

    private final SpawnPlugin plugin;

    public SpawnCommand(SpawnPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command,
                             String label, String[] args) {

        if (!(sender instanceof Player player)) {
            sender.sendMessage(
                    LegacyComponentSerializer.legacySection().deserialize(
                            plugin.getConfig().getString("messages.player-only",
                                    "§c플레이어만 사용할 수 있습니다!")
                    )
            );
            return true;
        }

        // 침대/앵커 스폰 지점 확인
        Location spawnLocation = player.getBedSpawnLocation();

        if (spawnLocation != null) {
            // 침대/앵커 스폰 지점으로 이동
            player.teleport(spawnLocation);
            player.sendMessage(
                    LegacyComponentSerializer.legacySection().deserialize(
                            plugin.getConfig().getString("messages.teleport-success",
                                    "§a스폰 지점으로 이동했습니다!")
                    )
            );
            plugin.getLogger().info("[SpawnPlugin] " + player.getName()
                    + " - 침대/앵커 스폰 지점으로 이동: "
                    + spawnLocation.getWorld().getName()
                    + " (" + spawnLocation.getBlockX()
                    + ", " + spawnLocation.getBlockY()
                    + ", " + spawnLocation.getBlockZ() + ")");

        } else {
            // 침대/앵커 없으면 월드 기본 스폰으로 이동
            Location worldSpawn = player.getWorld().getSpawnLocation();
            player.teleport(worldSpawn);
            player.sendMessage(
                    LegacyComponentSerializer.legacySection().deserialize(
                            plugin.getConfig().getString("messages.teleport-world-spawn",
                                    "§e설정된 스폰 지점이 없어 월드 스폰으로 이동했습니다!")
                    )
            );
            plugin.getLogger().info("[SpawnPlugin] " + player.getName()
                    + " - 월드 기본 스폰으로 이동: "
                    + worldSpawn.getWorld().getName()
                    + " (" + worldSpawn.getBlockX()
                    + ", " + worldSpawn.getBlockY()
                    + ", " + worldSpawn.getBlockZ() + ")");
        }

        return true;
    }
}