package com.mars.explorer.command;

import com.mars.explorer.configuration.Configuration;
import com.mars.explorer.configuration.Orientation;

/**
 * The place command will output the configuration provided in the constructor,
 * no matter what the input was.
 */
public class PlaceCommand implements Command {

    private final Configuration configuration;

    public PlaceCommand(int x, int y, Orientation orientation) {
        this(new Configuration(x, y, orientation));
    }

    public PlaceCommand(Configuration configuration) {
        this.configuration = configuration;
    }

    @Override
    public Configuration apply(Configuration configuration) {
        return this.configuration;
    }
}
