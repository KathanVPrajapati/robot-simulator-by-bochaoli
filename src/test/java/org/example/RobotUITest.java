package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RobotUITest {
    @Test
    void testMark() {
        Robot robot = new Robot(5);
        robot.downPen();
        robot.move(3);
        assertEquals(1, robot.getMap()[1][0]);
        assertEquals(1, robot.getMap()[2][0]);
        assertEquals(1, robot.getMap()[3][0]);
    }

    @Test
    void testPrintGrid() {
        Robot robot = new Robot(5);
        robot.printMap();
        assertNotNull(robot.getMap());
    }
}