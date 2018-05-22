package com.csdfossteam.palermo.core;

import com.csdfossteam.palermo.core.vote.MajorityVote;
import com.csdfossteam.palermo.core.vote.PlayerVote;
import com.csdfossteam.palermo.core.vote.UnanimousVote;

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
    public void playerVoteTie() throws Exception {

        PlayerVote v = new PlayerVote(p, true);
        v.set(p1, p2);
        v.set(p2, p1);
        v.set(p3, p3);

        assertTrue(v.ready());
        assertTrue(v.result().failed);
    }

    @Test
    public void playerVoteCorrect() throws Exception {

        PlayerVote v = new PlayerVote(p, true);
        v.set(p1, p2);

        assertEquals(2, v.missing());
        assertFalse(v.ready());

        v.set(p2, p1);
        v.set(p3, p1);
        v.set(p3, p2);

        assertTrue(v.ready());
        assertFalse(v.result().failed);
        assertEquals(p2, v.result().selected);
        assertEquals(2, v.result().selectedVotes);
        assertEquals(p1, v.result().votes.get(1).getKey());
    }

    @Test
    public void unanimousVote() throws Exception {

        PlayerVote v = new UnanimousVote(p, true);
        v.set(p1, p2);
        v.set(p2, p1);
        v.set(p3, p1);
        v.set(p3, p2);

        assertFalse(v.ready());

        v.set(p2, p2);

        assertTrue(v.ready());
        assertFalse(v.result().failed);
        assertEquals(p2, v.result().selected);
    }

    @Test
    public void majorityVote() throws Exception {

        MajorityVote v = new MajorityVote(p, p1);
        v.set(p1, true);
        v.set(p2, true);
        v.set(p3, false);

        assertTrue(v.ready());
        assertFalse(v.result().failed);
        assertEquals(2, v.result().positive);
        assertEquals(1, v.result().negative);
        assertEquals(1, v.result().result);
    }

}
