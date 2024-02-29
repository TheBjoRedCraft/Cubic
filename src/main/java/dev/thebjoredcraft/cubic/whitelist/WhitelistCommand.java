package dev.thebjoredcraft.cubic.whitelist;

import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public class WhitelistCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(args.length == 2 && args[0].equalsIgnoreCase("add")){
            UUID player = UUID.fromString(args[1]);

            WhitelistManager.add(player);
            sender.sendMessage(MiniMessage.miniMessage().deserialize("<red>Added " + player + " to the whitelist."));
        }else if(args.length == 2 && args[0].equalsIgnoreCase("list")){
            for(UUID player : WhitelistManager.whitelist){
                sender.sendMessage(MiniMessage.miniMessage().deserialize("<red>" + player));
            }
        }else if(args.length == 2 && args[0].equalsIgnoreCase("remove")){
            UUID player = UUID.fromString(args[1]);

            WhitelistManager.remove(player);
            sender.sendMessage(MiniMessage.miniMessage().deserialize("<red>Removed " + player + " from the whitelist."));
        }
        return false;
    }
}
