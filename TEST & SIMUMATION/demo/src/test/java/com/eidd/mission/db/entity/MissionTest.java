package com.eidd.mission.db.entity;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MissionTest {

    @Test
    public void testing_class() {
        // given
        int id = 1;
        double x = 0.0;
        double y = 0.0;
        double theta = 0.0;

        Mission mission = new Mission(id, x, y, theta);
        assertThat(mission.getId()).isEqualTo(id);
        assertThat(mission.getId()).isEqualTo(id);
        assertThat(mission.getId()).isEqualTo(id);
        assertThat(mission.getId()).isEqualTo(id);
    }

    @Test
    void gettersAndSetters() {
        // given
        Integer id = 1;
        Double x = 10.0;
        Double y = 20.0;
        Double theta = 30.0;

        // when
        Mission mission = new Mission();
        mission.setId(id);
        mission.setX(x);
        mission.setY(y);
        mission.setTheta(theta);

        // then
        assertThat(mission.getId()).isEqualTo(id);
        assertThat(mission.getX()).isEqualTo(x);
        assertThat(mission.getY()).isEqualTo(y);
        assertThat(mission.getTheta()).isEqualTo(theta);
    }

    @Test
    void equalsAndHashCode() {
        // given
        Mission mission1 = new Mission(1, 10.0, 20.0, 30.0);
        Mission mission2 = new Mission(1, 10.0, 20.0, 30.0);
        Mission mission3 = new Mission(2, 15.0, 25.0, 35.0);

        // then
        assertThat(mission1).isEqualTo(mission2);
        assertThat(mission1.hashCode()).isEqualTo(mission2.hashCode());
        assertThat(mission1).isNotEqualTo(mission3);
    }

    @Test
    void toStringMethod() {
        // given
        Mission mission = new Mission(1, 10.0, 20.0, 30.0);

        // when
        String toStringResult = mission.toString();

        // then
        assertThat(toStringResult).contains("id=1", "x=10.0", "y=20.0", "theta=30.0");
    }

}