package com.eidd.robot.db.entity;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RobotTest {

    @Test
    void testEquals() {
        Robot robot1 = new Robot(1, 2.0, 3.0, 45.0, 5.0, 10.0);
        Robot robot2 = new Robot(1, 2.0, 3.0, 45.0, 5.0, 10.0);
        Robot robot3 = new Robot(2, 4.0, 6.0, 90.0, 7.0, 15.0);

        // Test equal robots
        assertEquals(robot1, robot2);
        assertNotEquals(robot1, robot3);
    }

    @Test
    void testHashCode() {
        Robot robot1 = new Robot(1, 2.0, 3.0, 45.0, 5.0, 10.0);
        Robot robot2 = new Robot(1, 2.0, 3.0, 45.0, 5.0, 10.0);
        Robot robot3 = new Robot(2, 4.0, 6.0, 90.0, 7.0, 15.0);

        // Test hash code for equal and non-equal robots
        assertEquals(robot1.hashCode(), robot2.hashCode());
        assertNotEquals(robot1.hashCode(), robot3.hashCode());
    }






}
