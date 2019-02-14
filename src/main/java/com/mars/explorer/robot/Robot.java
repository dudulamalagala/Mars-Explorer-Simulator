package com.mars.explorer.robot;

import com.mars.explorer.command.Command;
import com.mars.explorer.configuration.Configuration;
import com.mars.explorer.configuration.Position;
import com.mars.explorer.configuration.Transition;

import java.util.function.Function;

/**
 * A robot for the toy robot simulator challenge.
 */
public interface Robot extends Function<Command, Transition> {
    /**
     * Applies a command to the robot.
     *
     * @param command The command the robot should execute.
     * @return The transition the robot did due to the command.
     */
    @Override
    Transition apply(Command command);

    /**
     * @return The current configuration of the robot, or null if not yet placed.
     */
    Configuration configuration();

    /**
     * @return The boundaries of the tabletop provided to the robot.
     */
    Position boundary();
}
