import org.junit.Before;
import org.junit.Test;

import java.util.Set;
import java.util.ArrayList;
import java.util.Collection;
import java.util.TreeMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.time.LocalTime;
import java.util.Arrays;

import static org.junit.Assert.*;


public class TestHeure {
    private Station station1;
    private Station station2;
    private Station station3;
    private Graph graph;



    @Before
    public void setUp(){
        // Creation de 3 station puis du graph : methode executee avant chaque test
        station1 = new Station("Station1");
        station2 = new Station("Station2");
        station3 = new Station("Station3");

        station1.addConnection("Ligne1");
        station1.addVoisinStation("Ligne1",station2);
        station2.addConnection("Ligne1");
        station2.addVoisinStation("Ligne1",station3);
        station3.addConnection("Ligne1");

        TreeSet<LocalTime> schedul1 = new TreeSet<>();
        station1.setSchedule(schedul1);
        station1.addToSchedule(LocalTime.of(0 , 0));
        station1.addToSchedule(LocalTime.of(0 , 30));
        station1.addToSchedule(LocalTime.of(1 , 0));
        station1.addToSchedule(LocalTime.of(1 , 30));
        
        TreeSet<LocalTime> schedul2 = new TreeSet<>();
        station2.setSchedule(schedul2);
        station2.addToSchedule(LocalTime.of(0 , 0));
        station2.addToSchedule(LocalTime.of(0 , 30));
        station2.addToSchedule(LocalTime.of(1 , 0));
        station2.addToSchedule(LocalTime.of(1 , 30));

        TreeSet<LocalTime> schedul3 = new TreeSet<>();
        station3.setSchedule(schedul3);
        station3.addToSchedule(LocalTime.of(0 , 0));
        station3.addToSchedule(LocalTime.of(0 , 30));
        station3.addToSchedule(LocalTime.of(1 , 0));
        station3.addToSchedule(LocalTime.of(1 , 30));

        List<Station> stations = new ArrayList<>(Arrays.asList(station1, station2, station3));
        graph = new Graph(stations);
    }

    @Test
    public void testgetNextPassage(){
        // on arrive a la station 1 a 0h 24
        assertEquals(null, LocalTime.of(0,30), station1.getNextPassage(0, 24));
    }

}
