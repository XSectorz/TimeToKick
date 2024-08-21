package net.xsapi.panat.timetokick.commands;

import net.xsapi.panat.timetokick.core;

public class commandLoader {
    public commandLoader() {
        core.getPlugin().getCommand("timetokick").setExecutor(new command());
    }
}
