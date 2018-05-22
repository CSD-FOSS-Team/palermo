package com.csdfossteam.palermo.core;

import java.util.Objects;

/**
 * TODO doc
 * <p>
 * The name must be unique
 *
 * @author Akritas Akritidis
 */
public class Player {

    public static final Player NONE = new Player("");

    public final String name;

    public Role role;
    protected boolean alive;

    public Player(String name) {
        this.name = name;

        role = Role.DEFAULT;
        alive = true;
    }

    public boolean isAlive() {
        return alive;
    }

    public int voteMultiplier() {
        return 1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        Player player = (Player) o;
        return Objects.equals(name, player.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
