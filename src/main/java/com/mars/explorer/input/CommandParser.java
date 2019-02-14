package com.mars.explorer.input;

import com.mars.explorer.command.*;
import com.mars.explorer.configuration.Orientation;

import java.util.function.Function;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Turns a command string read from the input source into a programmatic command object.
 */
public class CommandParser implements Function<String, Command> {
    private final static Logger LOGGER = Logger.getLogger(CommandParser.class.getName());

    private static final String LEFT = "LEFT";
    private static final String MOVE = "MOVE";
    private static final String PLACE_PREFIX = "PLACE";
    private static final Pattern PLACE_REGEX = Pattern.compile(PLACE_PREFIX + " (\\d+),(\\d+),(\\w+)");
    private static final String REPORT = "REPORT";
    private static final String RIGHT = "RIGHT";
    private static final String NORTH = "NORTH";
    private static final String EAST = "EAST";
    private static final String SOUTH = "SOUTH";
    private static final String WEST = "WEST";

    /**
     * Turn an input command string into a command object.
     *
     * @param commandString The command in string form.
     * @return The corresponding command object or a null-command in a fault case.
     */
    @Override
    public Command apply(String commandString) {
        if (commandString == null || commandString.isEmpty()) {
            LOGGER.warning("Empty command");
            return new NullCommand();
        } else if (commandString.equals(LEFT)) {
            return new LeftCommand();
        } else if (commandString.equals(MOVE)) {
            return new MoveCommand();
        } else if (commandString.startsWith(PLACE_PREFIX)) {
            return this.parsePlaceCommand(commandString);
        } else if (commandString.equals(REPORT)) {
            return new ReportCommand();
        } else if (commandString.equals(RIGHT)) {
            return new RightCommand();
        } else {
            LOGGER.warning("Unknown command: " + commandString + "; doing nothing.");
            return new NullCommand();
        }
    }

    private Command parsePlaceCommand(String commandString) {
        Matcher matcher = PLACE_REGEX.matcher(commandString);
        if (matcher.matches()) {
            return producePlaceCommand(matcher);
        } else {
            LOGGER.warning("Unknown command: " + commandString + "; doing nothing.");
            return new NullCommand();
        }
    }

    private Command producePlaceCommand(Matcher matcher) {
        try {
            return new PlaceCommand(
                    Integer.parseInt(matcher.group(1)),
                    Integer.parseInt(matcher.group(2)),
                    this.parsePlaceCommandOrientation(matcher.group(3))
            );
        } catch (IllegalArgumentException e) {
            LOGGER.warning(e.getMessage());
            return new NullCommand();
        }
    }

    private Orientation parsePlaceCommandOrientation(String orientationString) {
        if (orientationString == null || orientationString.isEmpty()) {
            throw new IllegalArgumentException("Empty orientation");
        } else if (orientationString.equals(NORTH)) {
            return Orientation.NORTH;
        } else if (orientationString.equals(EAST)) {
            return Orientation.EAST;
        } else if (orientationString.equals(SOUTH)) {
            return Orientation.SOUTH;
        } else if (orientationString.equals(WEST)) {
            return Orientation.WEST;
        } else {
            throw new IllegalArgumentException("Unknown orientation: " + orientationString);
        }
    }
}
