package com.csdfossteam.palermo.core;

import java.util.ArrayList;

/**
 * A collection of players
 *
 * @author Akritas Akritidis
 */
public class Players extends ArrayList<Player> {

    // TODO move from inheritance to encasement

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

    public boolean contains(Role role) {

        for (Player i : this) {
            if (i.role == role) return true;
        }
        return false;
    }

}
