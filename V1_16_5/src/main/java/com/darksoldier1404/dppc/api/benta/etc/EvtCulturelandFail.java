package com.darksoldier1404.dppc.api.benta.etc;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class EvtCulturelandFail extends Event {

    private static final HandlerList handlers = new HandlerList();

    private String identifier;

    public EvtCulturelandFail(String identifier) {
        this.identifier = identifier;

    }

    public String getIdentifier() {
        return this.identifier;
    }

    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}
