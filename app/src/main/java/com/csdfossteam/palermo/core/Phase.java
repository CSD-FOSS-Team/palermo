package com.csdfossteam.palermo.core;

/**
 * TODO doc
 *
 * @author Akritas Akritidis
 */
public enum Phase {

    Day,

    Night;

    public Phase next(Rules rules) {

        if (this == Day) {
            return Night;
        } else {
            return Day;
        }
    }

    public boolean isFirst(Rules rules) {
        return this == Day;
    }
}
