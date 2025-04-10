package org.example;

import org.junit.jupiter.api.BeforeEach;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CommandHandlerTest {
    private CommandHandler handler;

    @BeforeEach
    void setUp() {
        handler = new CommandHandler();
        handler.handleCommand("I 5");  // Initialize a 5x5 grid robot
    }

    @AfterEach
    void tearDown() {
        handler = null; // Force garbage collection
    }
    
    @Test
    void testRobotInitialization() {
        CommandHandler newHandler = new CommandHandler();
        newHandler.handleCommand("I 10");
        assertNotNull(newHandler.getRobot()); // Ensure robot is initialized
    }


    @Test
    void testMoveWithNegativeSteps() {
        handler.handleCommand("M -3");
        assertEquals(0, handler.getRobot().getY()); // Should not move
    }

    @Test
    void testMoveWithValidSteps() {
        handler.handleCommand("M 2");
        assertEquals(2, handler.getRobot().getY());
    }

    @Test
    void testReplayHistory() {
        handler.handleCommand("M 1");
        handler.handleCommand("R");
        handler.handleCommand("M 2");
        handler.handleCommand("H");
        assertEquals(2, handler.getRobot().getX());
    }

    @Test
    void testProcessCommand_TurnRight() {
        handler.handleCommand("R");
        assertEquals(DirectionEnum.EAST, handler.getRobot().getDirection());
    }

    @Test
    void testInvalidCommand() {
        handler.handleCommand("INVALID");
        assertEquals(DirectionEnum.NORTH, handler.getRobot().getDirection()); // No change
    }

    @Test
    void testProcessCommand_Move() {
        handler.handleCommand("M 3");
        assertEquals(3, handler.getRobot().getY());
    }

    @Test
    void testProcessCommand_PenDown() {
        handler.handleCommand("D");
        assertTrue(handler.getRobot().isPenDown());
    }

    @Test
    void testProcessCommand_CheckStatus() {
        handler.handleCommand("C");
        assertNotNull(handler.getRobot());
    }

    @Test
    void testProcessCommand_PenUp() {
        handler.handleCommand("D");
        handler.handleCommand("U");
        assertFalse(handler.getRobot().isPenDown());
    }

    @Test
    void testProcessCommand_TurnLeft() {
        handler.handleCommand("L");
        assertEquals(DirectionEnum.WEST, handler.getRobot().getDirection());
    }

    @Test
    void testMoveNorth() {
        handler.handleCommand("M 1");
        assertEquals(1, handler.getRobot().getY());
        assertEquals(DirectionEnum.NORTH, handler.getRobot().getDirection());
    }

    @Test
    void testProcessCommand_PrintGrid() {
        handler.handleCommand("P");
        assertNotNull(handler.getRobot().getMap());
    }
}
