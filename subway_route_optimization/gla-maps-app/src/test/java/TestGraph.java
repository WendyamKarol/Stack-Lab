import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;


public class TestGraph {
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

        List<Station> stations = new ArrayList<>(Arrays.asList(station1, station2, station3));
        graph = new Graph(stations);
    }


    @Test
    public void testGetStations(){
        // Test pour verfier si la methode getStations() renvoie la liste correcte des stations du graph
        List<Station> stations = graph.getStations();

        assertEquals(3,stations.size());
        assertTrue(stations.contains(station1));
        assertTrue(stations.contains(station2));
        assertTrue(stations.contains(station3));
    }


    @Test
    public void testCalculateRoute(){
        // Test de la fonction calculateRoute()

        // Cas de test 1 : chemin direct
        List<Station> path = graph.calculateRoute(station1, station3);
        assertEquals(3,path.size());
        assertEquals(station1,path.get(0));
        assertEquals(station2,path.get(1));
        assertEquals(station3,path.get(2));


        // Cas de test 2 : chemin avec ajout d'une station supplementaire et une autre ligne
        Station station4 = new Station("Station4");
        station4.addConnection("Ligne1");
        station4.addVoisinStation("Ligne1",station3);
        station4.addConnection("Ligne2");
        station4.addVoisinStation("Ligne2",station1);
        station1.addConnection("Ligne2");

        List<Station> path2 = graph.calculateRoute(station1, station4);
        assertEquals(2,path2.size());
        assertEquals(station1,path2.get(0));
        assertEquals(station4,path2.get(1));


        // Cas de test 3 : chemin avec changement de ligne
        Station station5 = new Station("Station5");
        station5.addConnection("Ligne3");
        station5.addVoisinStation("Ligne3",station3);
        station3.addConnection("Ligne3");
        station5.addConnection("Ligne4");
        station5.addVoisinStation("Ligne4",station4);
        station4.addConnection("Ligne4");

        List<Station> path3 = graph.calculateRoute(station1, station5);
        assertEquals(3,path3.size());
        assertEquals(station1,path3.get(0));
        assertEquals(station4,path3.get(1));
        assertEquals(station5,path3.get(2));
    }


    @Test
    public void testFindStation(){
        // Test pour la methode findStation pour une station existante
        Station foundStation = graph.findStation("Station1");
        assertNotNull(foundStation);
        assertEquals(station1,foundStation);
    }


    @Test
    public void testFindStationNotFound(){
        // Test pour la methode findStation pour une station inexistante
        Station foundStation = graph.findStation("StationInconnue");
        assertNull(foundStation);
    }


}
