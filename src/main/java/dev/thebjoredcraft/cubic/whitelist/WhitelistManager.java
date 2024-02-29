package dev.thebjoredcraft.cubic.whitelist;

import dev.thebjoredcraft.cubic.Cubic;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.util.UUID;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WhitelistManager {
    public static File configFile = new File(Cubic.getInstance.getDataFolder(), "whitelist.yml");
    public static FileConfiguration config = YamlConfiguration.loadConfiguration(configFile);
    public static List<UUID> whitelist = new ArrayList<>();
    public static void add(UUID player){
        whitelist.add(player);
    }
    public static void remove(UUID player){
        whitelist.remove(player);
    }
    public static void onEnable(){
        if (!configFile.exists()) {
            Cubic.getInstance.saveResource("whitelist.yml", false);
        }

        List<String> uuidStrings = config.getStringList("whitelist");
        for (String uuidString : uuidStrings) {
            whitelist.add(UUID.fromString(uuidString));
        }
    }
    public static void onDisable(){
        List<String> uuidStrings = new ArrayList<>();
        for (UUID uuid : whitelist) {
            uuidStrings.add(uuid.toString());
        }
        config.set("whitelist", uuidStrings);
        try {
            config.save(configFile);
        } catch (IOException e) {
            Bukkit.getConsoleSender().sendMessage(e.getMessage());
        }
    }
}
