package com.mars.explorer.configuration;

/**
 * Enum representing the four possible orientations.
 *
 * The enum also provided methods to rotate left and right.
 * This helps to avoid too many switch statements throughout the code,
 * which is usually considered fragile design (however the four cardinal
 * points are rather unlikely to be altered in the future...).
 */
public enum Orientation {
    NORTH,
    EAST,
    SOUTH,
    WEST;

    public Orientation left() {
        switch (this) {
            case NORTH:
                return WEST;
            case EAST:
                return NORTH;
            case SOUTH:
                return EAST;
            case WEST:
                return SOUTH;
            default:
                throw new IllegalStateException("Orientation unknown: " + this);
        }
    }

    public Orientation right() {
        switch (this) {
            case NORTH:
                return EAST;
            case EAST:
                return SOUTH;
            case SOUTH:
                return WEST;
            case WEST:
                return NORTH;
            default:
                throw new IllegalStateException("Orientation unknown: " + this);
        }
    }

}
