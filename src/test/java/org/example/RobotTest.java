package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RobotTest {
    private Robot robot;

    @BeforeEach
    void setUp() {
        robot = new Robot(5);
    }
    
    @AfterEach
    void tearDown() {
        robot = null;
    }

    @Test
    void testInitialPosition() {
        assertEquals(0, robot.getX());
        assertEquals(0, robot.getY());
        assertEquals(DirectionEnum.NORTH, robot.getDirection());
    }

    @Test
    void testMoveWithPenDown() {
        robot.downPen();
        robot.move(2);
        assertEquals(2, robot.getY());
        assertEquals(1, robot.getMap()[1][0]);
        assertEquals(1, robot.getMap()[2][0]);
    }

    @Test
    void testPenDown() {
        robot.downPen();
        assertTrue(robot.isPenDown());
    }

    @Test
    void testTurnRight() {
        robot.turnRight();
        assertEquals(DirectionEnum.EAST, robot.getDirection());
    }

    @Test
    void testTurnLeft() {
        robot.turnLeft();
        assertEquals(DirectionEnum.WEST, robot.getDirection());
    }
}