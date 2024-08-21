package net.xsapi.panat.timetokick.listeners;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import net.xsapi.panat.timetokick.config.mainConfig;
import net.xsapi.panat.timetokick.utils.XSUtils;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class onJoin implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();

        XSUtils.playerTime.put(p, mainConfig.getConfig().getInt("settings.time"));


    }
}
