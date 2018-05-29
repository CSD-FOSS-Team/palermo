package com.csdfossteam.palermo.core;

import com.csdfossteam.palermo.core.util.Amount;

/**
 * The rules of the game.
 *
 * @author Akritas Akritidis
 */
public class Rules {

    public static final Rules STANDARD = new Rules(false, 0.5f, Role.values());

    // TODO extend

    public final boolean showRolesOfDead;
    public final float votePercent;
    public final Role[] activeRoles;

    public final boolean allowVoteMultipliers;

    public final Amount countCitizen;
    public final Amount countBad;

    public Rules(boolean showRolesOfDead, float votePercent, Role[] activeRoles) {
        this.showRolesOfDead = showRolesOfDead;
        this.votePercent = votePercent;
        this.activeRoles = activeRoles;

        allowVoteMultipliers = true;

        countCitizen = Amount.ofMin(0, .8f);
        countBad = Amount.ofMin(2, .2f);
    }
}
