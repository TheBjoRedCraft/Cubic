package dev.thebjoredcraft.cubic.announcement;

import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.util.StringUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class AnnouncementCommand implements CommandExecutor, TabCompleter {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        try {
            AnnouncementType aT = AnnouncementType.valueOf(args[0].toUpperCase());
            String toAnnounce = "";

            for( int i = 1; i < args.length; i++) {
                toAnnounce = toAnnounce + args[i]+" ";
            }

            if (aT.equals(AnnouncementType.AB) || aT.equals(AnnouncementType.ACTIONBAR)) {
                AnnouncementManager.sendActionBarAnnouncement(toAnnounce);
            } else if (aT.equals(AnnouncementType.C) || aT.equals(AnnouncementType.CHAT)) {
                AnnouncementManager.sendChatAnnouncement(toAnnounce);
            }
        }catch (IllegalArgumentException e){
            sender.sendMessage(MiniMessage.miniMessage().deserialize("<red>Allowed types: CHAT, C, ACTIONBAR, AB"));
        }

        return false;
    }
    private final String[] sub = new String[]{"chat","actionbar"};
    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        List<String> completions = new ArrayList<>();
        if(args.length == 1) {
            StringUtil.copyPartialMatches(args[0], Arrays.asList(sub), completions);
        }
        Collections.sort(completions);
        return completions;
    }
}
