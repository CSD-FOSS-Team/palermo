package com.csdfossteam.palermo.core.vote;

import com.csdfossteam.palermo.core.Player;
import com.csdfossteam.palermo.core.Players;

/**
 * TODO doc
 * <p>
 * The template describes the kind of votes that each player must provide
 *
 * @author Akritas Akritidis
 */
public abstract class Vote<T> {

    protected final Players players;

    public Vote(Players players) {
        this.players = players;
    }

    public abstract void set(Player voter, T vote);

    public abstract int missing();

    public boolean ready() {
        return missing() == 0;
    }

    public abstract Result result();

    public static abstract class Result {

        public abstract boolean failed();

    }
}
