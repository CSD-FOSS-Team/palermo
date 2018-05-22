package com.csdfossteam.palermo.core;

import java.util.EnumSet;

import static com.csdfossteam.palermo.core.Role.Tag.*;

/**
 * TODO doc
 *
 * @author Akritas Akritidis
 */
public enum Role {

    Citizen(Good),

    Mafioso(Bad),

    Barman(Bad, Manipulator, Phase),

    Detective(Good, Investigative),

    Witness(Good, Omniscient),

    Doctor(Good, Protective, Phase),

    Dentist(Good, Handicapper, Phase),

    Lawyer(Good, Election, Phase),

    Mayor(Good, Election, Doublevoter),

    Sheriff(Good, Election, Doublevoter, Voted),

    ;

    public enum Tag {

        Good, Bad,

        Investigative, Protective, Omniscient, Manipulator, Handicapper, Election,

        Doublevoter,

        Voted, Phase,

        ;

    }

    public static final Role DEFAULT = Citizen;

    private final EnumSet<Tag> tagSet;

    Role(Tag... tags) {
        this.tagSet = EnumSet.noneOf(Tag.class);

        for (Tag i : tags) {
            tagSet.add(i);
        }
    }

    public boolean has(Tag... tags) {
        for (Tag i : tags) {
            if (!tagSet.contains(i)) return false;
        }
        return true;
    }
}
