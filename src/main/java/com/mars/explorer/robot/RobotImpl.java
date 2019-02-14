package com.mars.explorer.robot;

import com.mars.explorer.command.Command;
import com.mars.explorer.command.PlaceCommand;
import com.mars.explorer.configuration.Configuration;
import com.mars.explorer.configuration.Position;
import com.mars.explorer.configuration.Transition;

import java.util.logging.Logger;

class RobotImpl implements Robot {
    private final static Logger LOGGER = Logger.getLogger(RobotImpl.class.getName());
    private final Position boundary;

    private Configuration configuration;

    RobotImpl(Configuration configuration, Position boundary) {
        this.boundary = boundary;
        this.configuration = configuration;
    }

    @Override
    public Transition apply(Command command) {
        Configuration oldConfiguration = this.configuration;
        Configuration newConfiguration = command.apply(this.configuration);

        if (this.isValidConfiguration(newConfiguration)) {
            this.configuration = newConfiguration;
            return new Transition(oldConfiguration, command, newConfiguration);
        } else {
            LOGGER.warning("New configuration would be invalid, not changing.");
            return new Transition(oldConfiguration, command, oldConfiguration);
        }

    }

    public Configuration configuration() {
        return configuration;
    }

    public Position boundary() {
        return boundary;
    }

    @Override
    public String toString() {
        return "Current robot configuration: " +
                (configuration != null ? configuration.toString() : "Not placed yet");
    }

    private boolean isValidConfiguration(Configuration configuration) {
        // Not being placed at all is valid.
        if (configuration == null) {
            return true;
        }

        // Else check boundary.
        Position position = configuration.position();
        return position.x() >= 0 &&
                position.y() >= 0 &&
                position.x() < boundary.x() &&
                position.y() < boundary.y();
    }

}
