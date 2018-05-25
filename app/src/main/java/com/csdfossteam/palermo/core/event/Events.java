package com.csdfossteam.palermo.core.event;

import com.csdfossteam.palermo.core.Game;
import com.csdfossteam.palermo.core.Player;

import java.io.Serializable;

/**
 * TODO doc
 *
 * @author Akritas Akritidis
 */
public final class Events {

    private Events() {}

    public class PlayerVote extends Event {

        public final Player.Id player;
        public final Serializable vote;

        public PlayerVote(String id, String message, Player.Id player, Serializable vote) {
            super(id, message, player, vote);
            this.player = player;
            this.vote = vote;
        }

        @Override
        public void apply(Game game) {

            game.vote.set(player.get(game.players), vote);
        }
    }

}
