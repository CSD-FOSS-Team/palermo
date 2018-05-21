package com.csdfossteam.palermo.core;

/**
 * TODO doc
 *
 * @author Akritas Akritidis
 */
public class Rules {

    public static final Rules STANDARD = new Rules(false, 0.5f);

    // TODO extend

    public final boolean showRolesOfDead;
    public final float votePercent;

    public Rules(boolean showRolesOfDead, float votePercent) {
        this.showRolesOfDead = showRolesOfDead;
        this.votePercent = votePercent;
    }
}
