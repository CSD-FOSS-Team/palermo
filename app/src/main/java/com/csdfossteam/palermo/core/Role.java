package com.csdfossteam.palermo.core;

import java.io.Serializable;
import java.util.Collections;
import java.util.EnumSet;

import static com.csdfossteam.palermo.core.Role.Tag.*;

/**
 * A player role
 *
 * @author Akritas Akritidis
 */
public enum Role implements Serializable {

    Citizen(Good),

    Mafioso(Bad),

    Barman(Bad, Manipulator, Phase),

    Detective(Good, Investigative),

    Witness(Good, Omniscient),

    Doctor(Good, Protective, Phase),

    Dentist(Good, Handicapper, Phase),

    Lawyer(Good, Election, Phase),

    Mayor(Good, Election, Doublevoter), // TODO move to jobs/secondary roles

    Sheriff(Good, Election, Doublevoter, Voted),

    ;

    /**
     * A role tag.
     */
    public enum Tag implements Serializable {

        Good, Bad,

        Investigative, Protective, Omniscient, Manipulator, Handicapper, Election,

        Doublevoter,

        Voted, Phase,

        ;

    }

    public static final Role DEFAULT = Citizen;

    private final Tag[] tagArray;
    private final EnumSet<Tag> tagSet;

    Role(Tag... tags) {
        this.tagArray = tags;
        this.tagSet = EnumSet.noneOf(Tag.class);

        Collections.addAll(tagSet, tags);
    }

    /**
     * Check if the role has all the given tags.
     */
    public boolean has(Tag... tags) {
        for (Tag i : tags) {
            if (!tagSet.contains(i)) return false;
        }
        return true;
    }

    public Tag[] tags() {
        return tagArray;
    }
}
