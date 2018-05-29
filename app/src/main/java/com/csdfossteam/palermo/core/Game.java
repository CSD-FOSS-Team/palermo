package com.csdfossteam.palermo.core;

import com.csdfossteam.palermo.core.event.Event;
import com.csdfossteam.palermo.core.setup.PlayersSetup;
import com.csdfossteam.palermo.core.vote.Vote;

import java.util.ArrayList;

/**
 * TODO doc
 *
 * @author Akritas Akritidis
 */
public class Game {

    public final Rules rules;
    public final Players players;

    public final Turn turn;

    /** The currently active vote */
    public Vote vote;

    public Game(Rules rules, PlayersSetup players) {
        this.rules = rules;
        this.players = players.create(rules);

        turn = new Turn();

        vote = null;
    }

    private void handle(Event event) {

        event.apply(this);
    }

    public void nextPhase() {
        turn.nextPhase(rules);
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
