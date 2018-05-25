package com.csdfossteam.palermo.core.event;

import com.csdfossteam.palermo.core.Game;

import java.io.Serializable;

/**
 * An abstraction of an event.
 *
 * @author Akritas Akritidis
 */
public abstract class Event implements Serializable {

    private final String id;

    private final String message; // TODO move elsewhere
    private final Object[] messageArgs;

    public Event(String id, String message, Object... messageArgs) {
        this.id = id;

        this.message = message;
        this.messageArgs = messageArgs;
    }

    public abstract void apply(Game game);

    public String message() {
        return String.format(message, messageArgs);
    }

}
