package com.csdfossteam.palermo.core;

import static com.csdfossteam.palermo.core.RoleType.*;

/**
 * TODO doc
 *
 * @author Akritas Akritidis
 */
public enum Role {

    // TODO add attributes to each rule that describe their behavior

    Citizen(Neutral),

    Criminal(Bad),

    Detective(Investigative),

    Spy,

    Doctor,

    Barman;

    public static final Role DEFAULT = Citizen;

    public final RoleType type;

    Role() {
        this(Special);
    }

    Role(RoleType type) {
        this.type = type;
    }
}
