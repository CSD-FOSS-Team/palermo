package com.csdfossteam.palermo.core;

import com.csdfossteam.palermo.core.vote.Vote;

import java.util.ArrayList;

/**
 * TODO doc
 *
 * @author Akritas Akritidis
 */
public class Game {

    public final Players players;
    public final Rules rules;

    public int turn;
    public Phase phase;

    /** The currently active vote */
    public Vote vote;

    public Game() {
        players = new Players();
        rules = Rules.STANDARD;

        turn = 1;
        phase = Phase.Day;

        vote = null;
    }

    public void nextPhase() {

        phase = phase.next(rules);
        if (phase.isFirst(rules)) {
            turn += 1;
        }
    }

    public ArrayList<Role> nightRolesWithPhase() {

        Players aliveWithPhase = players.alive(Role.Tag.Phase);

        ArrayList<Role> roles = new ArrayList<>();
        // iterating through values will get the roles in the correct order
        for (Role role : Role.values()) {
            if (aliveWithPhase.contains(role)) {
                roles.add(role);
            }
        }

        return roles;
    }
}
