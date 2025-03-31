package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DirectionEnumTest {
    @Test
    void testTurnRight() {
        assertEquals(DirectionEnum.EAST, DirectionEnum.NORTH.turnRight());
    }

    @Test
    void testTurnLeft() {
        assertEquals(DirectionEnum.WEST, DirectionEnum.NORTH.turnLeft());
    }
}
