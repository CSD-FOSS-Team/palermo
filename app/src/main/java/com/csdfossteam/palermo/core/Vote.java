package com.csdfossteam.palermo.core;

import java.util.HashMap;

/**
 * TODO doc
 *
 * @author Akritas Akritidis
 */
public class Vote {

    private final HashMap<Player, Player> votes;

    public final boolean allowSelf;

    public Vote(Players players) {
        this(players, false);
    }

    public Vote(Players players, boolean allowSelf) {
        this.allowSelf = allowSelf;

        votes = new HashMap<>();
        for (Player i : players) {
            votes.put(i, Player.NONE);
        }
    }

    public void set(Player voter, Player vote) {
        if (!allowSelf && voter == vote) throw new RuntimeException();

        votes.put(voter, vote);
    }

    public int missing() {
        int count = 0;
        for (Player i : votes.values()) {
            if (i == Player.NONE) count += 1;
        }
        return count;
    }

    public boolean ready() {
        return missing() == 0;
    }

    public VoteResult result() {
        return new VoteResult(votes);
    }

}
