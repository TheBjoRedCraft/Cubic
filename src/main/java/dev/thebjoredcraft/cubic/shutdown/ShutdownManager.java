package dev.thebjoredcraft.cubic.shutdown;

import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class ShutdownManager {
    public static void kick(){
        for(Player player : Bukkit.getOnlinePlayers()){
            player.kick( MiniMessage.miniMessage().deserialize("           <bold><color:#3b92d1>CUBICMC\n" +
                    "\n" +
                    "\n" +
                    "     <red><bold>  SERVER NEUSTART!\n" +
                    "\n" +
                    "\n" +
                    "    <gray>Bitte lasse dich in unserem Discord \n" +
                    "                    whitelisten!\n" +
                    "\n" +
                    "---------- dc.djhase.de ----------"));
        }
    }
}
