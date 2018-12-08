package com.csdfossteam.palermo.core.event;

import com.csdfossteam.palermo.core.Game;

import java.io.Serializable;
import java.text.MessageFormat;

/**
 * An abstraction of an event.
 *
 * @author Akritas Akritidis
 */
public abstract class Event implements Serializable {

    private final String message; // TODO move elsewhere
    private final Object[] messageArgs;

    public Event(String message, Object... messageArgs) {
        this.message = message;
        this.messageArgs = messageArgs;
    }

    public abstract void apply(Game game);

    public final String message() {
        return MessageFormat.format(message, messageArgs);
    }

}
