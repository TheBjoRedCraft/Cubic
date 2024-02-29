package dev.thebjoredcraft.cubic;

import dev.thebjoredcraft.cubic.whitelist.WhitelistManager;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;

import java.util.UUID;

public class EventManager implements Listener {
    @EventHandler
    public void onPlayerLogin(PlayerLoginEvent event) {
        UUID playerUUID = event.getPlayer().getUniqueId();
        if (!WhitelistManager.whitelist.contains(playerUUID)) {
            event.disallow(PlayerLoginEvent.Result.KICK_WHITELIST, MiniMessage.miniMessage().deserialize("                      <bold><color:#3b92d1>CUBICMC\n" +
                    "\n" +
                    "\n" +
                    "        <red><bold>DU BIST NICH GEWHITELISTED!\n" +
                    "\n" +
                    "\n" +
                    "    <gray>Bitte lasse dich in unserem Discord \n" +
                    "                    whitelisten!\n" +
                    "\n" +
                    "---------- dc.djhase.de ----------"));
        }
    }
}
