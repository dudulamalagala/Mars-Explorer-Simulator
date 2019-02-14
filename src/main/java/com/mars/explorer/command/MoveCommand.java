package com.mars.explorer.command;

import com.mars.explorer.configuration.Configuration;

import java.util.logging.Logger;

public class MoveCommand extends AbstractCommand {
    private final static Logger LOGGER = Logger.getLogger(MoveCommand.class.getName());

    @Override
    public Configuration applyInternal(Configuration configuration) {
        switch (configuration.orientation()) {
            case NORTH:
                return new Configuration(configuration.position().x(), configuration.position().y() + 1, configuration.orientation());
            case EAST:
                return new Configuration(configuration.position().x() + 1, configuration.position().y(), configuration.orientation());
            case SOUTH:
                return new Configuration(configuration.position().x(), configuration.position().y() - 1, configuration.orientation());
            case WEST:
                return new Configuration(configuration.position().x() - 1, configuration.position().y(), configuration.orientation());
            default:
                LOGGER.warning("Orientation unknown: " + configuration.orientation() + ", will not move.");
                return configuration;
        }
    }
}
