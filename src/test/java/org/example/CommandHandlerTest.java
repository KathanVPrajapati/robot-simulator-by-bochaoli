package org.example;

import org.junit.jupiter.api.BeforeEach;
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
    void testProcessCommand_TurnRight() {
        handler.handleCommand("R");
        assertEquals(DirectionEnum.EAST, handler.getRobot().getDirection());
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
    void testProcessCommand_PrintGrid() {
        handler.handleCommand("P");
        assertNotNull(handler.getRobot().getMap());
    }
}
