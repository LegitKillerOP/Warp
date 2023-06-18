package me.legit.warp;

import me.legit.warp.commands.*;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public final class Warp extends JavaPlugin {

    public String prefix = ChatColor.GOLD + "Warps " + ChatColor.WHITE + ">> ";

    @Override
    public void onEnable() {
        customConfig();

        getCommand("setwarp").setExecutor(new SetWarpCmd(this));
        getCommand("warp").setExecutor(new WarpCmd(this));
        getCommand("warplist").setExecutor(new WarpListCmd(this));
        getCommand("deletewarp").setExecutor(new DeleteWarpCmd(this));
    }

    @Override
    public void onDisable() {
        saveConfig();
    }

    public void customConfig() {
        this.getConfig().options().copyDefaults(true);
        saveConfig();
    }
}