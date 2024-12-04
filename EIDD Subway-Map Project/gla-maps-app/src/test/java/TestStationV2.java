import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.Assert.*;

/**
 * Cette classe permet de tester les fonctionnalités de la classe Station, de la recherche de plus court chemin et de plus court chemin avec coûts.
 * 
 * @see Graph
 * 
 * @version 2
 */
public class TestStation {
    private Station station;

    @Before
    public void setUp(){
        station = new Station("Station1");
    }

    @Test
    public void testConstructeurAndGetteur(){
        assertEquals("Station1",station.getName());
        assertTrue(station.getConnections().isEmpty());
        assertTrue(station.getVoisinStations().isEmpty());
    }


    @Test
    public void testSetName(){
        station.setName("NewNameStation");
        assertEquals("NewNameStation",station.getName());
    }


    @Test
    public void testAddConnection(){
        station.addConnection("Ligne1");
        assertTrue(station.getConnections().contains("Ligne1"));

        station.addConnection(Arrays.asList("Ligne2", "Ligne3", "Ligne4"));
        assertTrue(station.getConnections().containsAll(Arrays.asList("Ligne1","Ligne2", "Ligne3", "Ligne4")));
    }


    @Test
    public void testRemoveLine(){
        station.addConnection("Ligne1");
        station.removeLine("Ligne1");
        assertFalse(station.getConnections().contains("Ligne1"));
    }


    @Test
    public void testAddVoisinStation(){
        Station station2 = new Station("Station2");
        station.addConnection("Ligne1");
        station.addVoisinStation("Ligne1",station2);

        List<Station> voisins = station.getVoisinStations("Ligne1");
        assertEquals(1,voisins.size());
        assertEquals("Station2",voisins.get(0).getName());
    }


    @Test
    public void testRemoveVoisinCascade(){
        Station station2 = new Station("Station2");
        station.addConnection("Ligne1");
        station.addVoisinStation("Ligne1",station2);

        station.removeVoisinCascade("Ligne1", station2);
        assertTrue(station.getVoisinStations("Ligne1").isEmpty());
        assertFalse(station.getConnections().contains("Ligne1"));
    }


    @Test
    public void testIsTerminus(){
        Station station2 = new Station("Station2");
        station.addConnection("Ligne1");
        station.addVoisinStation("Ligne1",station2);

        assertTrue(station.isTerminus("Ligne1"));

        Station station3 = new Station("Station3");
        station2.addConnection("Ligne1");
        station2.addVoisinStation("Ligne1",station3);

        assertFalse(station.isTerminus("Ligne1"));
    }
    
    @Test
    public void testGetVoisinStations() {
        Station stationB = new Station("Station B");
        Station stationC = new Station("Station C");
        Station stationD = new Station("Station D");
        station.addConnection("Line 1");
        station.addConnection("Line 2");
        station.addConnection("Line 3");
        station.addConnection("Line 4");
        station.addConnection("Line 5");
        station.addConnection("Line 6");
        station.addConnection("Line 7");
        station.addConnection("Line 8");
        station.addConnection("Line 9");
        station.addConnection("Line 10");
        station.addConnection("Line 11");
        station.addConnection("Line 12");
        station.addConnection("Line 13");
        station.addConnection("Line 14");
        station.addConnection("Line 15");

        station.getVoisinStations().add(stationB);
        station.getVoisinStations().add(stationC);
        station.getVoisinStations().add(stationD);

        List<Station> expected = Arrays.asList(stationB, stationC, stationD);
        assertEquals(expected, station.getVoisinStations());
    }

    @Test
    public void testAddConnection2() {
        station.addConnection("Line 4");
        station.addConnection("Line 5");
        assertTrue(station.getConnections().containsAll(Arrays.asList("Line 1", "Line 2", "Line 3", "Line 4", "Line 5")));
    }

    @Test
    public void testAddConnectionCollection() {
        station.addConnection(Arrays.asList("Line 4", "Line 5"));
        assertTrue(station.getConnections().containsAll(Arrays.asList("Line 1", "Line 2", "Line 3", "Line 4", "Line 5")));
    }

    
/*
    @Test
    public void testGetSchedule() {
        Station stationWithSchedule = new Station("Station A", Arrays.asList(LocalTime.of(7, 0), LocalTime.of(9, 0), LocalTime.of(11, 0)));
        List<LocalTime> expected = Arrays.asList(LocalTime.of(7, 0), LocalTime.of(9, 0), LocalTime.of(11, 0));
        assertEquals(expected, stationWithSchedule.getSchedule());
    }

    */

    @Test
    public void testGetScheduleEmpty() {
        Station stationWithoutSchedule = new Station("Station A");
        assertTrue(stationWithoutSchedule.getSchedule().isEmpty());
    }

}
