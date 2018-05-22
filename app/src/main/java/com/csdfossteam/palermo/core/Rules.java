package com.csdfossteam.palermo.core;

/**
 * TODO doc
 *
 * @author Akritas Akritidis
 */
public class Rules {

    public static final Rules STANDARD = new Rules(false, 0.5f, Role.values());

    // TODO extend

    public final boolean showRolesOfDead;
    public final float votePercent;
    public final Role[] activeRoles;

    public Rules(boolean showRolesOfDead, float votePercent, Role[] activeRoles) {
        this.showRolesOfDead = showRolesOfDead;
        this.votePercent = votePercent;
        this.activeRoles = activeRoles;
    }
}
