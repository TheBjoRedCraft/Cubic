package dev.thebjoredcraft.cubic.whitelist;

import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class WhitelistCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(args.length == 2 && args[0].equalsIgnoreCase("add")){
            Player player = Bukkit.getPlayer(args[1]);
            if(player != null){
                if(!WhitelistManager.whitelist.contains(player.getName())){
                    WhitelistManager.add(player.getName());
                    sender.sendMessage(MiniMessage.miniMessage().deserialize("<red>Added " + player + " to the whitelist."));
                }else{
                    sender.sendMessage(MiniMessage.miniMessage().deserialize("<red>The player is already whitelisted!"));
                }
            }else {
                String players = args[1];

                if(!WhitelistManager.whitelist.contains(players)){
                    WhitelistManager.add(players);
                    sender.sendMessage(MiniMessage.miniMessage().deserialize("<red>Added " + players + " to the whitelist."));
                }else{
                    sender.sendMessage(MiniMessage.miniMessage().deserialize("<red>The player is already whitelisted!"));
                }
            }
        }else if(args.length == 1 && args[0].equalsIgnoreCase("list")){
            if(!WhitelistManager.whitelist.isEmpty()) {
                sender.sendMessage(MiniMessage.miniMessage().deserialize("<red>Whitelisted players:"));
                for (String player : WhitelistManager.whitelist) {
                    sender.sendMessage(MiniMessage.miniMessage().deserialize("<red>" + player));
                }
            }else{
                sender.sendMessage(MiniMessage.miniMessage().deserialize("<red>There is no player on the whitelist!"));
            }
        }else if(args.length == 2 && args[0].equalsIgnoreCase("remove")){
            Player player = Bukkit.getPlayer(args[1]);
            if(player != null){
                if(!WhitelistManager.whitelist.contains(player.getName())){
                    WhitelistManager.remove(player.getName());
                    sender.sendMessage(MiniMessage.miniMessage().deserialize("<red>Removed " + player + " ("+  Bukkit.getPlayer(args[1]).getName() + ") from the whitelist."));
                }else{
                    sender.sendMessage(MiniMessage.miniMessage().deserialize("<red>The player is not whitelisted!"));
                }
            }else {
                String players = args[1];

                if(!WhitelistManager.whitelist.contains(players)){
                    WhitelistManager.remove(players);
                    sender.sendMessage(MiniMessage.miniMessage().deserialize("<red>Removed " + players +" from the whitelist."));
                }else{
                    sender.sendMessage(MiniMessage.miniMessage().deserialize("<red>The player is not whitelisted!"));
                }
            }
        }else if(args.length == 1 && args[0].equalsIgnoreCase("clear")){
            sender.sendMessage(MiniMessage.miniMessage().deserialize("<red>Are you sure? All whitelisted players will be removed from the whitelist! - Yes? - /cwhitelist clear confirm"));
        }else if(args.length == 2 && args[0].equalsIgnoreCase("clear") && args[1].equalsIgnoreCase("confirm")){
            WhitelistManager.whitelist.clear();
            sender.sendMessage(MiniMessage.miniMessage().deserialize("<red>All players have been removed from the whitelist!"));
        }else{
            sender.sendMessage(MiniMessage.miniMessage().deserialize("<red>Incorrect Usage!"));
        }
        return false;
    }
}
