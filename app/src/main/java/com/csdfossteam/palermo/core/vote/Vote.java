package com.csdfossteam.palermo.core.vote;

import com.csdfossteam.palermo.core.Players;

/**
 * TODO doc
 *
 * @author Akritas Akritidis
 */
public abstract class Vote {

    protected final Players players;

    public Vote(Players players) {
        this.players = players;
    }

    public abstract int missing();

    public boolean ready() {
        return missing() == 0;
    }

    public abstract Result result();

    public static abstract class Result {

        public abstract boolean failed();

    }
}
