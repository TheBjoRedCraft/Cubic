package dev.thebjoredcraft.cubic;

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


        saveDefaultConfig();
        // Plugin startup logic

    }

    @Override
    public void onDisable() {
        saveDefaultConfig();
        // Plugin shutdown logic
    }
}
