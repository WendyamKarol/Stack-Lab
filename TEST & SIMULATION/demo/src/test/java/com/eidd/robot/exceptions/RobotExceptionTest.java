package com.eidd.robot.exceptions;


import com.eidd.exceptions.RobotException;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

public class RobotExceptionTest {

    @Test
    public void testRobotExceptionWithMessage() {
        RobotException exception = assertThrows(RobotException.class, () -> {
            throw new RobotException("Test message");
        });
        assertEquals("Test message", exception.getMessage());
        assertNull(exception.getDetail());
    }


    @Test
    public void testRobotExceptionWithMessageAndCause() {
        Throwable cause = new IllegalArgumentException("Test cause");
        RobotException exception = assertThrows(RobotException.class, () -> {
            throw new RobotException("Test message", cause);
        });
        assertEquals("Test message", exception.getMessage());
        assertEquals(cause, exception.getCause());
        assertNull(exception.getDetail());
    }

    @Test
    public void testRobotExceptionWithMessageAndDetail() {
        RobotException exception = assertThrows(RobotException.class, () -> {
            throw new RobotException("Test message", "Test detail");
        });
        assertEquals("Test message", exception.getMessage());
        assertEquals("Test detail", exception.getDetail());
    }

    @Test
    public void testRobotExceptionWithMessageCauseAndDetail() {
        Throwable cause = new IllegalArgumentException("Test cause");
        RobotException exception = assertThrows(RobotException.class, () -> {
            throw new RobotException("Test message", cause, "Test detail");
        });
        assertEquals("Test message", exception.getMessage());
        assertEquals(cause, exception.getCause());
        assertEquals("Test detail", exception.getDetail());
    }


}
