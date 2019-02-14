package com.mars.explorer.command;

import com.mars.explorer.configuration.Configuration;
import com.mars.explorer.configuration.Orientation;
import com.mars.explorer.configuration.Position;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CommandsTest {

    private Configuration configuration;
    private Configuration placeConfiguration;
    private Command leftCommand;
    private Command moveCommand;
    private Command placeCommand;
    private Command reportCommand;
    private Command rightCommand;

    @Before
    public void setUp() {
        this.configuration = new Configuration(new Position(2, 2), Orientation.NORTH);
        this.placeConfiguration = new Configuration(new Position(0, 0), Orientation.SOUTH);
        this.leftCommand = new LeftCommand();
        this.moveCommand = new MoveCommand();
        this.placeCommand = new PlaceCommand(this.placeConfiguration);
        this.reportCommand = new ReportCommand();
        this.rightCommand = new RightCommand();
    }

    @Test
    public void testLeftCommand() {
        assertEquals(new Configuration(2, 2, Orientation.WEST),
                this.leftCommand.apply(this.configuration));
    }

    @Test
    public void testMoveCommand() {
        assertEquals(new Configuration(2, 3, Orientation.NORTH),
                this.moveCommand.apply(this.configuration));
    }

    @Test
    public void testPlaceCommand() {
        assertEquals(this.placeConfiguration,
                this.placeCommand.apply(this.configuration));
    }

    @Test
    public void testReportCommand() {
        assertEquals(new Configuration(2, 2, Orientation.NORTH),
                this.reportCommand.apply(this.configuration));
    }

    @Test
    public void testRightCommand() {
        assertEquals(new Configuration(2, 2, Orientation.EAST),
                this.rightCommand.apply(this.configuration));
    }

}
