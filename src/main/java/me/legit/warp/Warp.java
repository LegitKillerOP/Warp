package me.legit.warp;

import me.legit.warp.commands.*;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public final class Warp extends JavaPlugin {

    private String msgcolor(String text){
        return net.md_5.bungee.api.ChatColor.translateAlternateColorCodes('&', text);
    }
    public String prefix = ChatColor.GOLD + "Warps " + ChatColor.WHITE + ">> ";

    @Override
    public void onEnable() {

        Bukkit.getConsoleSender().sendMessage(msgcolor(prefix+"&c------------------------------"));
        Bukkit.getConsoleSender().sendMessage(msgcolor(prefix+" "));
        Bukkit.getConsoleSender().sendMessage(msgcolor(prefix+"&eWarp Plugin Started !!"));
        Bukkit.getConsoleSender().sendMessage(msgcolor(prefix+"&ePlugin Version: &c1.0"));
        Bukkit.getConsoleSender().sendMessage(msgcolor(prefix+"&ePlugin Made By: &cLegit Killer"));
        Bukkit.getConsoleSender().sendMessage(msgcolor(prefix+" "));
        Bukkit.getConsoleSender().sendMessage(msgcolor(prefix+"&c------------------------------"));

        customConfig();

        getCommand("setwarp").setExecutor(new SetWarpCmd(this));
        getCommand("warp").setExecutor(new WarpCmd(this));
        getCommand("warplist").setExecutor(new WarpListCmd(this));
        getCommand("deletewarp").setExecutor(new DeleteWarpCmd(this));
    }

    @Override
    public void onDisable() {

        Bukkit.getConsoleSender().sendMessage(msgcolor(prefix+"&c------------------------------"));
        Bukkit.getConsoleSender().sendMessage(msgcolor(prefix+" "));
        Bukkit.getConsoleSender().sendMessage(msgcolor(prefix+"&cWarp Plugin Stoped !!"));
        Bukkit.getConsoleSender().sendMessage(msgcolor(prefix+"&cPlugin Version: &c1.0"));
        Bukkit.getConsoleSender().sendMessage(msgcolor(prefix+"&cPlugin Made By: &cLegit Killer"));
        Bukkit.getConsoleSender().sendMessage(msgcolor(prefix+" "));
        Bukkit.getConsoleSender().sendMessage(msgcolor(prefix+"&c------------------------------"));

        saveConfig();
    }

    public void customConfig() {
        this.getConfig().options().copyDefaults(true);
        saveConfig();
    }
}