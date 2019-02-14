package com.mars.explorer;

import com.mars.explorer.command.ReportCommand;
import com.mars.explorer.configuration.Position;
import com.mars.explorer.configuration.Transition;
import com.mars.explorer.input.CommandParser;
import com.mars.explorer.input.Input;
import com.mars.explorer.input.Sanitiser;
import com.mars.explorer.robot.Robot;
import com.mars.explorer.robot.RobotBuilder;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Toy robot simulator.
 */
public class Main {

    private static final Position BOUNDARY = new Position(4, 4);

    public static void main(String[] args) {
        setUpLogging();
        Robot robot = buildRobot();
        runSimulator(args, robot);
    }

    private static void runSimulator(String[] args, Robot robot) {
        new Input().apply(args)
                .map(new Sanitiser())
                .map(new CommandParser())
                .map(robot)
                .filter(transition -> transition.by() instanceof ReportCommand)
                .map(Transition::to)
                .forEach(configuration -> System.out.println((configuration != null) ?
                        configuration :
                        "Not placed yet."));
    }

    private static Robot buildRobot() {
        return new RobotBuilder()
                .mandatoryNorthEastBoundary(BOUNDARY)
                .build();
    }

    private static void setUpLogging() {
        Logger rootLog = Logger.getLogger("");
        rootLog.setLevel(Level.FINE);
        rootLog.getHandlers()[0].setLevel(Level.FINE);
    }

}
