package com.csdfossteam.palermo.core;

import java.util.HashMap;

/**
 * TODO doc
 *
 * @author Akritas Akritidis
 */
public class Vote {

    // TODO find vote result

    private final HashMap<Player, Player> votes;

    public Vote(Players players) {

        votes = new HashMap<>();
        for (Player i : players) {
            votes.put(i, Player.NONE);
        }
    }

    public void set(Player voter, Player vote) {
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
}
