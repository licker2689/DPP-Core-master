package com.darksoldier1404.dppc.api.twitch;

import com.github.twitch4j.common.events.domain.EventChannel;
import com.github.twitch4j.events.ChannelGoLiveEvent;
import com.github.twitch4j.helix.domain.Stream;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class TwitchLiveEvent extends Event {
    private static final HandlerList handlers = new HandlerList();
    private final EventChannel channel;
    private final Stream stream;
    private final ChannelGoLiveEvent event;

    public TwitchLiveEvent(EventChannel ec, Stream s, ChannelGoLiveEvent e) {
        super(true);
        this.channel = ec;
        this.stream = s;
        this.event = e;
    }

    public EventChannel getChannel() {
        return channel;
    }

    public Stream getStream() {
        return stream;
    }

    public ChannelGoLiveEvent getEvent() {
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
