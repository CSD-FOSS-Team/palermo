package com.csdfossteam.palermo.core.setup;

import com.csdfossteam.palermo.core.Player;
import com.csdfossteam.palermo.core.Players;
import com.csdfossteam.palermo.core.Rules;

import java.util.ArrayList;

/**
 * TODO doc
 *
 * @author Akritas Akritidis
 */
public class PlayersSetup {

    private final ArrayList<Player.Id> playerIds;

    public PlayersSetup(int count) {
        playerIds = new ArrayList<>(count);

        for (int i = 0; i < count; i++) {
            playerIds.add(null);
        }
    }

    public void set(int index, String name) {
        playerIds.set(index, new Player.Id(name));
    }

    public boolean ready() {

        for (Player.Id i : playerIds) {
            if (i == null) return false;
        }
        return true;
    }

    public Players create(Rules rules) {
        Players players = new Players();

        for (Player.Id i : playerIds) {
            Player p = new Player(i.name);
            players.add(p);
        }

        assignRoles(players, rules);

        return players;
    }

    private void assignRoles(Players players, Rules rules) {

        // TODO implement

    }
}
