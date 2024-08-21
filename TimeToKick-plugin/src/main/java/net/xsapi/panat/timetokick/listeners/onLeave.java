package net.xsapi.panat.timetokick.listeners;

import net.xsapi.panat.timetokick.utils.XSUtils;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class onLeave implements Listener {

    @EventHandler
    public void onLeave(PlayerQuitEvent e) {

        XSUtils.playerTime.remove(e.getPlayer());
    }
}
