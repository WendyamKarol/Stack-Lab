
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Cette classe implémente la lacture de CSV et les stocker dans une liste de stations 
 * Elle a été conssus dans le cadre du cour de génie logiciel de 2ème année d'école d'ingénieur à l'EIDD;
 * 
 * @see ReadData
 * @see Graph
 * 
 * @version 2
 */
public class ReadCsv implements ReadData{
    /**
     * Ouvre un fichier en utilisant un string et retourne une liste de station
     * @param f nom du fichier à utiliser
     * @return liste de stations 
     * 
     */

    @Override
    public List<Station> readFile(String f) {
    BufferedReader reader = null; // va venir lire recuprer les informations du fichier CSV par le biais d'unn FileReader
    String line = "";
    List<Station> list= new ArrayList<Station>();
    try {
        reader = new BufferedReader(new FileReader(f));
        while((line = reader.readLine()) != null) {
    
            String[] row = line.split(","); // on vient split les elements pour avoir en colonne bien séparée par des espaces
            list=fillStation(row, list);
            //System.out.println("src: "+row[0]+" dest :"+row[1]);
        }
         try {
            reader.close();
        } 
        catch (IOException e) {
    
         e.printStackTrace(); // si on arrive pas a fermer le reader on aura un message d'erreur
        }
    }
    catch(Exception e) {
        e.printStackTrace(); // si on arrive pas à ouvrir le fichier on aura un message d'erreur
        
    }
   
    return list;
 }

    /**
     * remplissage du graph
     * @param g
     */

    @Override
    public void fillGraph(Graph g) {
        // TODO Auto-generated method stub
    }
    

    /**
     * remplissage de la liste de stations en vérifiaint que les stations 
     * et les voisins ne sont pas déja crées dedans, permet d'obtenir une unicité
     * @param row ligne de csv à traiter
     * @param list liste des stations avant changements
     * @return liste des stations après changements
     */

     public List<Station> fillStation(String[] row,List<Station> list) {
        Set<Station> set = new HashSet<>(list);
        for (Station station : set){
            if (station.getName().equals(row[0])) {
                station.addConnection(row[2]);
                for (Station voisin : set){
                    if (voisin.getName().equals(row[1])) {
                        voisin.addConnection(row[2]);
                        station.addVoisinStation(row[2], voisin);
                        set.add(station);
                        list= new ArrayList<>(set);
                        return list;
                    }
                }
                for(Station Element:set){
                    for(Station voisin : Element.getVoisinStations()){
                        if (voisin.getName().equals(row[1])) {
                            voisin.addConnection(row[2]);
                            station.addVoisinStation(row[2], voisin);
                            set.add(station);
                            list= new ArrayList<>(set);
                            return list;
                        }
                    }
                }
                
                Station v= new Station(row[1]);

                v.addConnection(row[2]);
                station.addVoisinStation(row[2], v);
                set.add(station);
                list= new ArrayList<>(set);
                return list;
            }
        }
             for(Station Element:set){
                for(Station station2 : Element.getVoisinStations()){
                    if (station2.getName().equals(row[0])) {
                        station2.addConnection(row[2]);
                        for (Station voisin : set){
                            if (voisin.getName().equals(row[1])) {
                                voisin.addConnection(row[2]);
                                station2.addVoisinStation(row[2], voisin);
                                set.add(station2);
                                list= new ArrayList<>(set);
                                return list;
                            }
                        }
                for(Station Ele:set){
                    for(Station voisin : Ele.getVoisinStations()){
                        if (voisin.getName().equals(row[1])) {
                            voisin.addConnection(row[2]);
                            station2.addVoisinStation(row[2], voisin);
                            set.add(station2);
                            list= new ArrayList<>(set);
                            return list;
                        }
                    }
                }
                
                Station v= new Station(row[1]);

                v.addConnection(row[2]);
                station2.addVoisinStation(row[2], v);
                set.add(station2);
                list= new ArrayList<>(set);
                return list;
                    }
                }
            } 
        
        Station s= new Station(row[0]); 
        Station voisin= new Station(row[1]);
        s.addConnection(row[2]);
        voisin.addConnection(row[2]);
        s.addVoisinStation(row[2], voisin);
        set.add(s);
        list= new ArrayList<>(set);
        return list;
     }


}
