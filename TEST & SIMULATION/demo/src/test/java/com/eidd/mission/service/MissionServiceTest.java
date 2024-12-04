package com.eidd.mission.service;

import com.eidd.exceptions.RobotException;
import com.eidd.mission.db.entity.Mission;
import com.eidd.mission.db.repository.MissionRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class MissionServiceTest {

    @InjectMocks
    private final MissionService missionService = new MissionService();
    @Mock
    MissionRepository missionRepository;

    @Autowired
    MockMvc mockMvc;

    @Test
    void getAll() {
        //verify(missionRepository).findAll();
        // Arrange
        List  <Mission> mockMissions = Collections.singletonList(new Mission(1,0.0,0.0,0.0));
        Mockito.when(missionRepository.findAll()).thenReturn(mockMissions);

        List<Mission> result = missionService.getAll();

        assertThat(result).isEqualTo(mockMissions);
        verify(missionRepository).findAll();

    }

    @Test
    void toTest() {
        //Mockito.doReturn(new Mission()).when(missionRepository);
        Mockito.when(missionRepository.findAll()).thenReturn(Arrays.asList(new Mission()));
        List<Mission> missions = missionService.getAll();
        //assertThat(mission).isNotNull();
        assertThat(missions).isNotNull();
        //assertThat(true).isEqualTo(true);
        assertThat(true).isEqualTo(true);
    }

    @Test
    void get_all_should_catch_exception() {
        //doThrow(RobotException.class).when(missionRepository).findAll();
        doThrow(RobotException.class).when(missionRepository).findAll();
        //assertThatCode(missionService::getAll).isInstanceOf(RobotException.class);
        assertThatCode(missionService::getAll).isInstanceOf(RobotException.class);
    }

    @Test
    void create() {
        Mission missionToCreate_1= new Mission(1,4.0,2.0,10.0);
        Mockito.when(missionRepository.save(Mockito.any(Mission.class))).thenReturn(missionToCreate_1);

        //Act
        Mission createdMission_1= missionService.create(missionToCreate_1);

        //assert
        assertThat(createdMission_1).isEqualTo(missionToCreate_1);

        //verify
        Mockito.verify(missionRepository).save(missionToCreate_1);

    }

    @Test
    void getMission() {

        List<Mission> missions = Arrays.asList(
                new Mission(1,4.0,2.0,10.0),
                new Mission(2,5.0,3.0,20.0)
                );

        Mockito.when(missionRepository.findAll()).thenReturn(missions);
        missionService.init();
        //Testing getMission
        Mission mission1 = missionService.getMission();
        Mission mission2 = missionService.getMission();
        // Asserting that missions are not null
        assertNotNull(mission1);
        assertNotNull(mission2);

        // Asserting that the returned missions are the expected ones
        assertEquals(1, mission1.getId());
        assertEquals(4.0, mission1.getX());
        assertEquals(2.0, mission1.getY());
        assertEquals(10.0, mission1.getTheta());

        assertEquals(2, mission2.getId());
        assertEquals(5.0, mission2.getX());
        assertEquals(3.0, mission2.getY());
        assertEquals(20.0, mission2.getTheta());
    }
}