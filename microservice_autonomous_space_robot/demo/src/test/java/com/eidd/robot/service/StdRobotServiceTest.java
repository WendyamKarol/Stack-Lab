package com.eidd.robot.service;

import com.eidd.exceptions.RobotException;
import com.eidd.robot.db.entity.Robot;
import com.eidd.robot.db.repository.RobotRepository;
import com.eidd.robot.db.service.StdRobotService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
public class StdRobotServiceTest {

        @Mock
        private RobotRepository robotRepository;

        @InjectMocks
        private StdRobotService robotService;

        @Test
        void getAll_shouldReturnListOfRobots() {
            // Arrange
            List<Robot> robots = new ArrayList<>();
            robots.add(new Robot(1, 2.0, 3.0, 45.0, 5.0, 10.0));
            when(robotRepository.findAll()).thenReturn(robots);

            // Act
            List<Robot> result = robotService.getAll();

            // Assert
            assertEquals(robots, result);
        }

        @Test
        void find_shouldReturnRobotById() throws RobotException {
            // Arrange
            Robot robot = new Robot(1, 2.0, 3.0, 45.0, 5.0, 10.0);
            when(robotRepository.findById(1)).thenReturn(Optional.of(robot));

            // Act
            Optional<Robot> result = robotService.find(1);

            // Assert
            assertTrue(result.isPresent());
            assertEquals(robot, result.get());
        }

        @Test
        void create_shouldReturnCreatedRobot() throws RobotException {
            // Arrange
            Robot robot = new Robot(1, 2.0, 3.0, 45.0, 5.0, 10.0);
            when(robotRepository.save(robot)).thenReturn(robot);

            // Act
            Robot result = robotService.create(robot);

            // Assert
            assertEquals(robot, result);
        }

        @Test
        void update_shouldReturnUpdatedRobot() throws RobotException {
            // Arrange
            Robot robot = new Robot(1, 2.0, 3.0, 45.0, 5.0, 10.0);
            when(robotRepository.findById(1)).thenReturn(Optional.of(robot));
            when(robotRepository.save(robot)).thenReturn(robot);

            // Act
            Robot result = robotService.update(robot);

            // Assert
            assertEquals(robot, result);
        }

        @Test
        void delete_shouldNotThrowException() throws RobotException {
            // Arrange
            doNothing().when(robotRepository).deleteById(1);

            // Act and Assert
            assertDoesNotThrow(() -> robotService.delete(1));
        }

        // Test for a scenario where the robot is not found during update
        @Test
        void update_whenRobotNotFound_shouldThrowException() {
            // Arrange
            Robot robot = new Robot(1, 2.0, 3.0, 45.0, 5.0, 10.0);
            when(robotRepository.findById(1)).thenReturn(Optional.empty());

            // Assert
            assertThrows(RobotException.class, () -> robotService.update(robot));
        }


    }


