package com.csdfossteam.palermo.core;

import java.io.Serializable;
import java.util.Objects;

/**
 * A player with the corresponding state.
 * <p>
 * For a reference to player the Player.Id returned from the id() is suggested.
 * <p>
 * The name is used as the identifier so it must be unique.
 *
 * @author Akritas Akritidis
 */
public class Player {

    /**
     * A player object representing none of the player.
     */
    public static final Player NONE = new Player("");

    /**
     * The name and id of the player.
     */
    public final String name;

    public Role role;
    protected boolean alive;

    public Player(Id id) {
        this(id.name);
    }

    public Player(String name) {
        this(name, Role.DEFAULT);
    }

    public Player(String name, Role role) {
        this.name = name;
        this.role = role;

        alive = true;
    }

    public void kill() {
        alive = false;
    }

    public boolean isAlive() {
        return alive;
    }

    public int voteMultiplier() {
        // check for tags
        if (role.has(Role.Tag.Doublevoter)) {
            return 2;
        }
        // default
        return 1;
    }

    public static final class Id implements Serializable {

        public final String name;

        private Id(Player player) {
            this(player.name);
        }

        public Id(String name) {
            this.name = name;
        }

        public Player get(Players players) {
            return players.get(name);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            Id id = (Id) o;
            return Objects.equals(name, id.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name);
        }
    }

    public Id id() {
        return new Id(this);
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
