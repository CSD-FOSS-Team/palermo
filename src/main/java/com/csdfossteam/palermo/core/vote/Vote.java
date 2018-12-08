package com.csdfossteam.palermo.core.vote;

import com.csdfossteam.palermo.core.Player;
import com.csdfossteam.palermo.core.Players;

import java.io.Serializable;

/**
 * An abstraction of a vote and its result
 * <p>
 * The template describes the kind of votes that each player must provide
 *
 * @author Akritas Akritidis
 */
public abstract class Vote<T extends Serializable> {

    protected final Players players;

    public Vote(Players players) {
        this.players = players;
    }

    /**
     * Set the vote of the given player.
     */
    public abstract void set(Player voter, T vote);

    /**
     * Returns the number of votes that are missing.
     */
    public abstract int missing();

    /**
     * Returns true if the result is ready to be determined.
     */
    public boolean ready() {
        return missing() == 0;
    }

    /**
     * Retrun the result of the vote.
     */
    public abstract Result result();

    /**
     * An abstraction of a result of a vote.
     */
    public static abstract class Result<T> {

        public abstract T result();

        public abstract boolean failed();

    }
}
