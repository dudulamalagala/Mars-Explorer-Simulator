package com.mars.explorer.configuration;

/**
 * Immutable data object representing a position and an orientation.
 */
public class Configuration {

    private final Orientation orientation;
    private final Position position;

    public Configuration(int x, int y, Orientation orientation) {
        this.orientation = orientation;
        this.position = new Position(x, y);
    }

    public Configuration(Position position, Orientation orientation) {
        this.orientation = orientation;
        this.position = position;
    }

    public Orientation orientation() {
        return this.orientation;
    }

    public Position position() {
        return this.position;
    }

    @Override
    public int hashCode() {
        int result = 77;
        result = 31 * result + this.orientation().hashCode();
        result = 31 * result + this.position().hashCode();
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Configuration)) {
            return false;
        }
        Configuration conf = (Configuration) obj;
        return this.orientation() == conf.orientation() && this.position().equals(conf.position());
    }

    @Override
    public String toString() {
        return this.position() + "," + this.orientation();
    }

}
