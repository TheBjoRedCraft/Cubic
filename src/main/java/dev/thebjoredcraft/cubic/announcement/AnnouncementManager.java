package dev.thebjoredcraft.cubic.announcement;

import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class AnnouncementManager {
    public static void sendActionBarAnnouncement(String toAnnounce){
        for(Player player : Bukkit.getOnlinePlayers()){
            player.sendActionBar(MiniMessage.miniMessage().deserialize(toAnnounce));
        }
    }
    public static void sendChatAnnouncement(String toAnnounce){
        for(Player player : Bukkit.getOnlinePlayers()){
            player.sendMessage(MiniMessage.miniMessage().deserialize(" \n" + toAnnounce +"\n" + " "));
            Bukkit.getConsoleSender().sendMessage(MiniMessage.miniMessage().deserialize(" \n" + toAnnounce +"\n" + " "));
        }
    }
}
