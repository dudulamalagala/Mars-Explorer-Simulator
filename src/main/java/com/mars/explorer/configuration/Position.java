package com.mars.explorer.configuration;

/**
 * Immutable data object representing a position in two dimensional space
 * by the means of x and y coordinates.
 */
public class Position {

    private final int x;
    private final int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int x() {
        return this.x;
    }

    public int y() {
        return this.y;
    }

    @Override
    public int hashCode() {
        int result = 46;
        result = 31 * result + this.x();
        result = 31 * result + this.y();
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Position)) {
            return false;
        }
        Position pos = (Position) obj;
        return this.x() == pos.x() && this.y() == pos.y();
    }

    @Override
    public String toString() {
        return this.x() + "," + this.y();
    }
}
