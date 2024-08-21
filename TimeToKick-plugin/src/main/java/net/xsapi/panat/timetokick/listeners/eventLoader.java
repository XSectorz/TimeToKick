package net.xsapi.panat.timetokick.listeners;

import net.xsapi.panat.timetokick.core;
import org.bukkit.Bukkit;

public class eventLoader {

    public eventLoader() {

        Bukkit.getPluginManager().registerEvents(new onJoin(), core.getPlugin());
        Bukkit.getPluginManager().registerEvents(new onLeave(), core.getPlugin());
    }
}
