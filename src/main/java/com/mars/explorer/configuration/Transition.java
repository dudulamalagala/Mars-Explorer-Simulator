package com.mars.explorer.configuration;

import com.mars.explorer.command.Command;

/**
 * Immutable data object representing a transition.
 *
 * It consists of two positions and the command that transitioned from one to the other.
 * It basically implements a 3-tuple.
 * The class is intended to facilitate usage of the Robot class in streams.
 */
public class Transition {
    private final Configuration from;
    private final Command by;
    private final Configuration to;

    /**
     * @param from The start position.
     * @param by   The command that made the transition from start to end position
     * @param to   The end position.
     */
    public Transition(Configuration from, Command by, Configuration to) {
        this.from = from;
        this.by = by;
        this.to = to;
    }

    /**
     * @return The start position.
     */
    public Configuration from() {
        return from;
    }

    /**
     * @return The command that made the transition from start to end position
     */
    public Command by() {
        return by;
    }

    /**
     * @return The end position.
     */
    public Configuration to() {
        return to;
    }

}
