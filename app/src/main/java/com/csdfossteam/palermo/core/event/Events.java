package com.csdfossteam.palermo.core.event;

import com.csdfossteam.palermo.core.Game;
import com.csdfossteam.palermo.core.Player;
import com.csdfossteam.palermo.core.Role;
import com.csdfossteam.palermo.core.Turn;

import java.io.Serializable;

/**
 * A collection of all the events.
 *
 * @author Akritas Akritidis
 */
public final class Events {

    private Events() {}

    public class PlayerVote extends Event {

        private static final String MES = "{0} voted: {1}";

        public final Player.Id player;
        public final Serializable vote;

        public PlayerVote(Player.Id player, Serializable vote) {
            super(MES, player, vote);
            this.player = player;
            this.vote = vote;
        }

        @Override
        public void apply(Game game) {

            game.vote.set(player.get(game.players), vote);
        }
    }

    public class NextPhase extends Event {

        private static final String MES = "New phase: {0} at turn {1}";

        public final Turn turn;

        public NextPhase(Turn turn) {
            super(MES, turn.phase, turn.turn);
            this.turn = turn;
        }

        @Override
        public void apply(Game game) {

            game.turn.nextPhase(game.rules);
        }
    }

    public class NextNightPhase extends Event {

        private static final String MES = "New night phase for {0}";

        public final Role role;

        public NextNightPhase(Role role) {
            super(MES, role);
            this.role = role;
        }

        @Override
        public void apply(Game game) {

            // TODO implement
        }
    }

    public class PlayerDeath extends Event {

        private static final String MES = "{0} died";

        public final Player.Id player;

        public PlayerDeath(Player.Id player) {
            super(MES, player);
            this.player = player;
        }

        @Override
        public void apply(Game game) {

            player.get(game.players).kill();
        }
    }

}
