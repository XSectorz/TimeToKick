package net.xsapi.panat.timetokick.utils;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import net.xsapi.panat.timetokick.config.messagesConfig;
import net.xsapi.panat.timetokick.core;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class XSUtils {

    public static ConcurrentHashMap<Player,Integer> playerTime = new ConcurrentHashMap<>();

    public static String decodeText(String str) {
        Component parsedMessage = MiniMessage.builder().build().deserialize(str);
        return LegacyComponentSerializer.legacyAmpersand().serialize(parsedMessage).replace("&","§");
    }


    public static void sendActionBar(Player player, String message, String timeLeft) {

        String formattedMessage = message.replace("%time_left%", timeLeft);

        Component component = MiniMessage.miniMessage().deserialize(formattedMessage);
        core.getAdventure().player(player).sendActionBar(component);
    }

    public static void createRepeatTask() {
        Bukkit.getScheduler().scheduleSyncRepeatingTask(core.getPlugin(), new Runnable() {
            @Override
            public void run() {
                for(Map.Entry<Player,Integer> playerTimer : XSUtils.playerTime.entrySet()) {

                    Player p = playerTimer.getKey();
                    int time = playerTimer.getValue();

                    String message = messagesConfig.getConfig().getString("actionbarMessage");
                    sendActionBar(p,message, String.valueOf(time));

                    if(playerTimer.getValue() == 0) {

                        String kickMsg = "";

                        for(String s : messagesConfig.getConfig().getStringList("kickedMessage")) {
                            kickMsg += XSUtils.decodeText(s) + "\n";
                        }

                        playerTimer.getKey().kickPlayer(kickMsg);
                    }
                    playerTimer.setValue(playerTimer.getValue()-1);

                }
            }
        }, 0L, 20L);
    }

}
