package dev.thebjoredcraft.cubic;

import dev.thebjoredcraft.cubic.whitelist.WhitelistCommand;
import dev.thebjoredcraft.cubic.whitelist.WhitelistManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Cubic extends JavaPlugin {
    public static Cubic getInstance;
    @Override
    public void onLoad() {
        getInstance = this;
        // Plugin startup logic

    }

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(new EventManager(), this);
        getCommand("cwhitelist").setExecutor(new WhitelistCommand());


        saveDefaultConfig();
        WhitelistManager.onEnable();
        // Plugin startup logic

    }

    @Override
    public void onDisable() {
        saveDefaultConfig();
        WhitelistManager.onDisable();
        // Plugin shutdown logic
    }
}
