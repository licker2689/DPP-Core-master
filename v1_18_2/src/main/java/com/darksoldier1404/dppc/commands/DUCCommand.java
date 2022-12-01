package com.darksoldier1404.dppc.commands;

import com.darksoldier1404.dppc.DPPCore;
import com.darksoldier1404.dppc.utils.InventoryUtils;
import com.darksoldier1404.dppc.utils.UpdateChecker;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

@SuppressWarnings("all")
public class DUCCommand implements CommandExecutor {
    private final DPPCore plugin = DPPCore.getInstance();

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!sender.isOp()) {
            sender.sendMessage("§cYou don't have permission to use this command!");
            sender.sendMessage("§c권한이 없습니다.");
            return false;
        }
        if (args.length == 0) {
            sender.sendMessage("§cUsage: /dppc uc - Check for updates");
            sender.sendMessage("§cUsage: /dppc uc - 업데이트 확인");
            return false;
        }
        if (args[0].equalsIgnoreCase("uc")) {
            if (sender instanceof Player) {
                Player p = (Player) sender;
                p.sendMessage(plugin.prefix + "설치된 모든 DP-Plugins 플러그인 업데이트 확인...");
                p.sendMessage(plugin.prefix + "Checking for all DP-Plugins update info...");
                plugin.enabledPlugins.values().forEach(o -> UpdateChecker.check(o, p));
            } else {
                sender.sendMessage(plugin.prefix + "설치된 모든 DP-Plugins 플러그인 업데이트 확인...");
                sender.sendMessage(plugin.prefix + "Checking for all DP-Plugins update info...");
                plugin.enabledPlugins.values().forEach(UpdateChecker::check);
            }
        }
        return false;
    }
}
