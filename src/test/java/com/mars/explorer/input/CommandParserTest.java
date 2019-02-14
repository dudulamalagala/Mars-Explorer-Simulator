package com.mars.explorer.input;

import com.mars.explorer.command.*;
import com.mars.explorer.configuration.Configuration;
import com.mars.explorer.configuration.Orientation;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CommandParserTest {
    private CommandParser commandParser;
    private Configuration dummyConfiguration;

    @Before
    public void setUp() throws Exception {
        this.commandParser = new CommandParser();
        this.dummyConfiguration = new Configuration(0, 0, Orientation.NORTH);
    }

    @Test
    public void testLeft() throws Exception {
        Command command = commandParser.apply("LEFT");
        assertTrue(command instanceof LeftCommand);
    }

    @Test
    public void testMove() throws Exception {
        Command command = commandParser.apply("MOVE");
        assertTrue(command instanceof MoveCommand);
    }

    @Test
    public void testPlace() throws Exception {
        Command command = commandParser.apply("PLACE 0,0,NORTH");
        assertTrue(command instanceof PlaceCommand);
    }

    @Test
    public void testReport() throws Exception {
        Command command = commandParser.apply("REPORT");
        assertTrue(command instanceof ReportCommand);
    }

    @Test
    public void testRight() throws Exception {
        Command command = commandParser.apply("RIGHT");
        assertTrue(command instanceof RightCommand);
    }

    @Test
    public void testValidPlaceA() throws Exception {
        Command command = commandParser.apply("PLACE 0,0,NORTH");
        Configuration configuration = command.apply(this.dummyConfiguration);
        assertEquals(new Configuration(0, 0, Orientation.NORTH), configuration);
    }

    @Test
    public void testValidPlaceB() throws Exception {
        Command command = commandParser.apply("PLACE 2,3,SOUTH");
        Configuration configuration = command.apply(this.dummyConfiguration);
        assertEquals(new Configuration(2, 3, Orientation.SOUTH), configuration);
    }

    @Test
    public void testValidPlaceC() throws Exception {
        Command command = commandParser.apply("PLACE 4,2,EAST");
        Configuration configuration = command.apply(this.dummyConfiguration);
        assertNotEquals(new Configuration(2, 4, Orientation.WEST), configuration);
    }

    @Test
    public void testInvalidPlaceA() throws Exception {
        Command command = commandParser.apply("PLACE4,2,EAST");
        Configuration configuration = command.apply(this.dummyConfiguration);
        assertEquals(this.dummyConfiguration, configuration);
    }

    @Test
    public void testInvalidPlaceB() throws Exception {
        Command command = commandParser.apply("PLACE 4, 2,EAST");
        Configuration configuration = command.apply(this.dummyConfiguration);
        assertEquals(this.dummyConfiguration, configuration);
    }

    @Test
    public void testInvalidPlaceC() throws Exception {
        Command command = commandParser.apply("PLACE 4,2,HUBWARD");
        Configuration configuration = command.apply(this.dummyConfiguration);
        assertEquals(this.dummyConfiguration, configuration);
    }

}
