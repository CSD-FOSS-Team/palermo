package com.csdfossteam.palermo.core;

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

    public Rules(boolean showRolesOfDead, float votePercent, Role[] activeRoles) {
        this.showRolesOfDead = showRolesOfDead;
        this.votePercent = votePercent;
        this.activeRoles = activeRoles;

        allowVoteMultipliers = true;
    }
}
