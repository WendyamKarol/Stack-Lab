import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.Assert.*;




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
     
    

}
