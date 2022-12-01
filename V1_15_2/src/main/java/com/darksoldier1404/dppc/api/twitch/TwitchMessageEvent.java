package com.darksoldier1404.dppc.api.twitch;

import com.github.twitch4j.chat.events.channel.ChannelMessageEvent;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class TwitchMessageEvent extends Event {
    private static final HandlerList handlers = new HandlerList();
    private final ChannelMessageEvent event;

    public TwitchMessageEvent(ChannelMessageEvent e) {
        super(true);
        this.event = e;
    }

    public ChannelMessageEvent getEvent() {
        return event;
    }

    @Override
    public @NotNull
    HandlerList getHandlers() {
        return handlers;
    }

    @NotNull
    public static HandlerList getHandlerList() {
        return handlers;
    }
}
