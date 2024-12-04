package com.eidd.robot.rest.controller;

import com.eidd.exceptions.RobotException;
import com.eidd.mission.db.entity.Mission;
import com.eidd.mission.service.MissionService;
import com.eidd.robot.db.entity.Robot;
import com.eidd.robot.db.service.RobotService;
import com.eidd.robot.db.service.StdRobotService;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.commons.logging.LoggerFactory;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.ArgumentMatchers.eq;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;


@ExtendWith(MockitoExtension.class)
class RobotApiControllerTest {

    private RobotApiController robotApiController;
    private StdRobotService robotService;
    private ObjectMapper objectMapper;
    private HttpServletRequest request;

    @BeforeEach
    void setUp() {
        objectMapper = mock(ObjectMapper.class);
        request = new MockHttpServletRequest();
        robotService = mock(StdRobotService.class);
        robotApiController = new RobotApiController(objectMapper, request);
        robotApiController.robotService = robotService;
    }

    @Test
    void robotGet() {
        // Given
        when(robotService.getAll()).thenReturn(Collections.singletonList(new Robot()));

        // When
        ResponseEntity<List<Robot>> response = robotApiController.robotGet();

        // Then
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody().get(0)).isEqualTo(new Robot());
    }

    @Test
    void robotIdDelete_RobotNotFound() {
        // Given
        doThrow(new RobotException("Robot not found")).when(robotService).delete(anyInt());

        // When
        ResponseEntity<Void> response = robotApiController.robotIdDelete(1);

        // Then
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
    }

    @Test
    void robotIdGet_RobotFound() {
        // Given
        when(robotService.find(anyInt())).thenReturn(Optional.of(new Robot()));

        // When
        ResponseEntity<Robot> response = robotApiController.robotIdGet(1);

        // Then
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isNotNull();
    }

    @Test
    void robotIdPut_RobotException() {
        // Given
        doThrow(new RobotException("Some error")).when(robotService).update(any());

        // When
        ResponseEntity<Robot> response = robotApiController.robotIdPut(1, new Robot());

        // Then
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
    }

    @Test
    void robotPost() {
        // Given
        Robot requestRobot = new Robot();
        Robot savedRobot = new Robot();
        when(robotService.create(any(Robot.class))).thenReturn(savedRobot);

        // When
        ResponseEntity<Robot> response = robotApiController.robotPost(requestRobot);

        // Then
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isEqualTo(savedRobot);
    }
}