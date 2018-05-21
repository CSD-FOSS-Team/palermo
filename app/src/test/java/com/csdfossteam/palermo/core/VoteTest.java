package com.csdfossteam.palermo.core;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * TODO doc
 *
 * @author Akritas Akritidis
 */
public class VoteTest {

    private final Player p1, p2, p3;
    private final Players p;

    public VoteTest() {

        p1 = new Player("p1");
        p2 = new Player("p2");
        p3 = new Player("p3");

        p = new Players();
        p.add(p1);
        p.add(p2);
        p.add(p3);
    }

    @Test
    public void voteTie() throws Exception {

        Vote v = new Vote(p, true);
        v.set(p1, p2);
        v.set(p2, p1);
        v.set(p3, p3);

        assertTrue(v.ready());
        assertTrue(v.result().failed);
    }

    @Test
    public void voteCorrect() throws Exception {

        Vote v = new Vote(p);
        v.set(p1, p2);
        v.set(p2, p1);
        v.set(p3, p1);
        v.set(p3, p2);

        assertTrue(v.ready());
        assertFalse(v.result().failed);
        assertEquals(p2, v.result().selected);
        assertEquals(2, v.result().selectedVotes);
        assertEquals(p1, v.result().votes.get(1).getKey());
    }

}
