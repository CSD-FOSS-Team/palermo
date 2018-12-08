package com.csdfossteam.palermo.core;

import com.csdfossteam.palermo.core.event.Event;
import com.csdfossteam.palermo.core.event.Events;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * TODO doc
 *
 * @author Akritas Akritidis
 */
public class EventTest {

    @Test
    public void checkSerializable() throws Exception {

        assertFalse(isSerializable(Object.class));

        assertTrue(isSerializable(Events.PlayerVote.class));
        assertTrue(isSerializable(Events.NextPhase.class));
        assertTrue(isSerializable(Events.NextNightPhase.class));
        assertTrue(isSerializable(Events.PlayerDeath.class));

    }

    private boolean isSerializable(Class c) {

        // TODO improve

        return Event.class.isAssignableFrom(c);
    }

}
