package com.csdfossteam.palermo.core;

import java.util.ArrayList;

/**
 * A collection of players.
 *
 * @author Akritas Akritidis
 */
public class Players extends ArrayList<Player> {

    // TODO move from inheritance to encasement after the final

    /**
     * Returns the player based on the given name, or null if the player is not found.
     */
    public Player get(String name) {
        for (Player i : this) {
            if (i.name.equals(name)) return i;
        }
        return null; // player not found
    }

    /**
     * Returns a new collection of the alive players based on the given filter options.
     *
     * @param tags if not empty, only players with all the given tags will be returned
     */
    public Players alive(Role.Tag... tags) {
        return filter(true, tags);
    }

    /**
     * Returns a new collection of players based on the given filter options.
     *
     * @param onlyAlive if true, only alive players will be returned
     * @param tags      if not empty, only players with all the given tags will be returned
     */
    public Players filter(boolean onlyAlive, Role.Tag... tags) {
        Players p = new Players();

        for (Player i : this) {
            if (onlyAlive && !i.alive) continue;
            if (tags.length > 0 && !i.role.has(tags)) continue;
            p.add(i);
        }

        return p;
    }

    /**
     * Count the players with the given role.
     */
    public int count(Role role) {
        int count = 0;
        for (Player i : this) {
            if (i.role == role) count++;
        }
        return count;
    }

    /**
     * Checks if there are players with the given role.
     */
    public boolean contains(Role role) {
        return count(role) > 0;
    }

}
