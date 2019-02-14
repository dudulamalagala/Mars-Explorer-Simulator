package com.mars.explorer.command;

import com.mars.explorer.configuration.Configuration;

/**
 * Possible, but yet unused command to take the robot off the tabletop.
 */
public class UnplaceCommand implements Command {
    @Override
    public Configuration apply(Configuration configuration) {
        return null;
    }
}
