package com.csdfossteam.palermo.core.vote;

import com.csdfossteam.palermo.core.Player;
import com.csdfossteam.palermo.core.Players;

/**
 * A player vote where all the voters must agree.
 *
 * @author Akritas Akritidis
 */
public class UnanimousVote extends PlayerVote {

    public UnanimousVote(Players players, boolean allowSelf) {
        super(players, allowSelf);
    }

    public boolean unanimous() {
        // get the first player voted player
        Player p = votes.values().iterator().next();
        // check if all votes have the same player
        for (Player i : votes.values()) {
            if (!i.equals(p)) return false;
        }
        return true;
    }

    @Override
    public boolean ready() {
        return super.ready() && unanimous();
    }

}
