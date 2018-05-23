package com.csdfossteam.palermo.core;

import java.io.Serializable;

/**
 * Phase of the a turn.
 *
 * @author Akritas Akritidis
 */
public enum Phase implements Serializable {

    // TODO implement sub-phases

    Day,

    Night;

    public Phase next(Rules rules) {

        if (this == Day) {
            return Night;
        } else {
            return Day;
        }
    }

    /**
     * Is the first phase of a turn.
     */
    public boolean isFirst(Rules rules) {
        return this == Day;
    }
}
