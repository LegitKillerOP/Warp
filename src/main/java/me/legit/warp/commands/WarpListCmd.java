package me.legit.warp.commands;
import me.legit.warp.Warp;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class WarpListCmd implements CommandExecutor {

    private final Warp plugin;

    public WarpListCmd(Warp plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission("warp.warplist")) {
                if (command.getName().equalsIgnoreCase("warplist")) {
                    player.sendMessage(plugin.prefix + ChatColor.GREEN + "All of your warps are listed below:");
                    for (String str : plugin.getConfig().getKeys(false)) {
                        player.sendMessage(ChatColor.WHITE + ">> " + ChatColor.GOLD + str);
                    }
                }
            } else {
                player.sendMessage(plugin.prefix + ChatColor.RED + "You do not have the required permission!");
            }
        }
        return false;
    }
}