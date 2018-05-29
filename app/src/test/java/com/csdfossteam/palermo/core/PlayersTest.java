package com.csdfossteam.palermo.core;

import com.csdfossteam.palermo.core.setup.PlayersSetup;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * TODO doc
 *
 * @author Akritas Akritidis
 */
public class PlayersTest {

    private final Player p1, p2, p3, p4;
    private final Players p;

    public PlayersTest() {
        p = new Players();

        p.add(p1 = new Player("p1"));
        p1.kill();

        p.add(p2 = new Player("p2"));
        p2.role = Role.Mafioso;

        p.add(p3 = new Player("p3"));
        p3.role = Role.Mafioso;

        p.add(p4 = new Player("p4"));
        p4.role = Role.Dentist;

        p.add(new Player("p5"));
        p.add(new Player("p6"));
        p.add(new Player("p7"));
    }

    @Test
    public void filter() throws Exception {

        assertEquals(7, p.size());
        assertEquals(6, p.alive().size());
        assertEquals(2, p.alive(Role.Tag.Bad).size());
        assertEquals(2, p.filter(false, Role.Tag.Bad).size());
        assertEquals(5, p.filter(false, Role.Tag.Good).size());
        assertEquals(4, p.alive(Role.Tag.Good).size());
        assertEquals(1, p.alive(Role.Tag.Phase).size());

    }

    @Test
    public void containsRole() throws Exception {

        assertTrue(p.contains(Role.Mafioso));
        assertTrue(p.contains(Role.Dentist));
        assertFalse(p.contains(Role.Lawyer));
        assertFalse(p.contains(Role.Barman));

    }

    @Test
    public void immutable() throws Exception {

        assertEquals(7, p.size());

        p.alive().add(new Player("p8"));
        p.filter(false).add(new Player("p8"));
        p.filter(true).add(new Player("p8"));

        assertEquals(7, p.size());
    }

    @Test
    public void setup() throws Exception {

        PlayersSetup setup = new PlayersSetup(3);
        setup.set(0, "p1");
        setup.set(1, "p2");

        assertFalse(setup.ready());

        setup.set(2, "p3");

        assertTrue(setup.ready());

        Players players = setup.create(Rules.STANDARD);

        assertEquals(3, players.size());
        assertEquals("p2", players.get(1).name);
        assertEquals(true, players.get(1).isAlive());

    }

}
