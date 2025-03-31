package org.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RobotTest_1 {
    private Robot robot;

    @BeforeEach
    void setUp() {
        robot = new Robot(); // Initializes the robot using the default constructor
        robot.setSize(5); // Set size to 5 (assuming setter exists)
        robot.setDirection(DirectionEnum.NORTH); // Set initial direction to NORTH
        robot.setPosition(2, 2); // Set initial position to (2, 2)
    }

    @Test
    void testBasicMovement() {
        // Moving 3 steps north
        robot.move(3); 
        assertEquals(5, robot.getY(), "Y should increase by 3 when moving NORTH.");
    }

    @Test
    void testBoundaryCondition() {
        robot.setDirection(DirectionEnum.EAST); // Change direction to EAST
        robot.setPosition(4, 2); // Set position near boundary (x=4, y=2)
        robot.move(10); // Try moving 10 steps
        assertEquals(4, robot.getX(), "X should not exceed 4 when size = 5.");
    }

    @Test
    void testPenDownEffect() {
        robot.setPenDown(true); // Set pen down
        robot.setDirection(DirectionEnum.SOUTH); // Set direction to SOUTH
        robot.move(2); // Move 2 steps south
        assertEquals(1, robot.getMapValue(2, 2), "Map should be updated at (2,2).");
        assertEquals(1, robot.getMapValue(2, 1), "Map should be updated at (2,1).");
    }
}
