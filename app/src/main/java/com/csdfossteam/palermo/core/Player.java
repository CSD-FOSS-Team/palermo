package com.csdfossteam.palermo.core;

/**
 * TODO doc
 *
 * @author Akritas Akritidis
 */
public class Player {

    public String name;
    public Role role;

    public Player(String name) {
        this.name = name;

        role = Role.DEFAULT;
    }
}
