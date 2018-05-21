package com.csdfossteam.palermo.core;

/**
 * TODO doc
 *
 * @author MaanooAk
 */

public class Game {

    public final Players players;
    public final Rules rules;

    public int turn;
    public Phase phase;

    public Game() {
        players = new Players();
        rules = Rules.STANDARD;

        turn = 1;
        phase = Phase.Day;
    }

    public void nextPhase() {

        phase = phase.next(rules);
        if (phase.isFirst(rules)) {
            turn += 1;
        }
    }
}
