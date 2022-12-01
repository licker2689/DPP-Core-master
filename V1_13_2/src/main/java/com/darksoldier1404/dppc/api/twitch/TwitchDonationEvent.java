package com.darksoldier1404.dppc.api.twitch;

import com.github.twitch4j.chat.events.channel.DonationEvent;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class TwitchDonationEvent extends Event {
    private static final HandlerList handlers = new HandlerList();
    private final DonationEvent event;

    public TwitchDonationEvent(DonationEvent e) {
        super(true);
        this.event = e;
    }

    public DonationEvent getEvent() {
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
