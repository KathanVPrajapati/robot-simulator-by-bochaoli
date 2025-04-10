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
    
    @Test
    void testTurnLeftAllDirections() {
        // Test for NORTH direction
        robot.setDirection(DirectionEnum.NORTH);
        robot.turnLeft();
        assertEquals(DirectionEnum.WEST, robot.getDirection());
        
        // Test for EAST direction
        robot.setDirection(DirectionEnum.EAST);
        robot.turnLeft();
        assertEquals(DirectionEnum.NORTH, robot.getDirection());
        
        // Test for SOUTH direction
        robot.setDirection(DirectionEnum.SOUTH);
        robot.turnLeft();
        assertEquals(DirectionEnum.EAST, robot.getDirection());
        
        // Test for WEST direction
        robot.setDirection(DirectionEnum.WEST);
        robot.turnLeft();
        assertEquals(DirectionEnum.SOUTH, robot.getDirection());
    }

    @Test
    void testTurnRightAllDirections() {
        // Test for NORTH direction
        robot.setDirection(DirectionEnum.NORTH);
        robot.turnRight();
        assertEquals(DirectionEnum.EAST, robot.getDirection());
        
        // Test for EAST direction
        robot.setDirection(DirectionEnum.EAST);
        robot.turnRight();
        assertEquals(DirectionEnum.SOUTH, robot.getDirection());
        
        // Test for SOUTH direction
        robot.setDirection(DirectionEnum.SOUTH);
        robot.turnRight();
        assertEquals(DirectionEnum.WEST, robot.getDirection());
        
        // Test for WEST direction
        robot.setDirection(DirectionEnum.WEST);
        robot.turnRight();
        assertEquals(DirectionEnum.NORTH, robot.getDirection());
    }

    @Test
    void testMoveAtBoundary() {
        robot.setPosition(4, 0);  // Set robot at the boundary (rightmost column)
        robot.setDirection(DirectionEnum.EAST);
        robot.move(1);  // Attempt to move East, but should hit boundary
        assertEquals(4, robot.getX());  // X should remain at boundary
        assertEquals(0, robot.getY());
    }
}