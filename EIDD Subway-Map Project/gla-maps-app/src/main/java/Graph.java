import java.util.*;

import javax.print.DocFlavor.STRING;

/**
 * Cette classe est une instance des connexions (graphe connexe) entre les différentes stations de métro (et d'autres lignes à venir...)
 * 
 * @see ReadData
 * @see Station
 * 
 * @version 3
 */
public class Graph {
    private List<Station> stations;     // liste de toutes les stations répertoriées dans la base de données

    /**
	 * Constructeur
	 * @param stations Liste de stations 
	 */
    public Graph(List<Station> stations) {
        this.stations = stations;
    }
     /**
	 * Constructeur
	 *  
	 */
    public Graph() {
    }
    /**
	 * Getter 
	 * @return List<Station> contenant toutes les stations
	 */
    public List<Station> getStations(){
        return this.stations;
    }
    
    /**
	 * Une implémentation de l'algorithme de Dijkstra de http://www.gitta.info/Accessibiliti/en/html/Dijkstra_learningObject1.html adapté avec la classe Station
	 * @param source Station de départ
     * @param dest Station d'arrivée
	 * @return List<Station> contenant les stations du plus court chemin pour aller de la station source à la station dest
	 */
	public List<Station> calculateRoute(Station source, Station dest) {
        Map<String, String> pred = new HashMap<>();		// liste des prédécesseurs 
        Map<String, Integer> dist = new HashMap<>();		// liste des distances
        Map<String, Boolean> visited = new HashMap<>();
        Queue<Station> queue = new ArrayDeque<>();
        Station s = findStation(source.getName());
        int alt;
        for(Station st:this.stations){
            dist.putIfAbsent(st.getName(), Integer.MAX_VALUE);
            visited.putIfAbsent(st.getName(),false);

        }

        dist.replace(s.getName(), 0);       // si c'est la station source, on initialise sa distance à 0
        queue.offer(s);       // on ajoute la station source à la file    
        pred.put(s.getName(), null); // pas de prédécesseurs pour l'instant

        while (!queue.isEmpty())  {
            Station s2 = queue.poll();

            visited.replace(s2.getName(), true); // marquer la station comme visitée
            
            for (Station n : s2.getVoisinStations()) {

                if (!visited.get(n.getName())) { // vérifier si la station n'a pas été déjà visitée
                    alt = dist.get(s2.getName()) + 1; // on incrémente la distance de la station par rapport à la source de 1
                    if (alt < dist.get(n.getName())) {
                        dist.replace(n.getName(), alt);
                        pred.put(n.getName(), s2.getName()); // mise à jour du dictionnaire des prédécesseurs
                        queue.offer(n); // ajout du voisin dans la file
                    }

                }
            }
            
        }
        // trace le chemin à partir de la liste des prédécesseurs
        List<Station> path = new ArrayList<>();
        Station curr = dest;
        while (curr!=null && !curr.equals(source)){
            if (!path.contains(curr)) { // vérifie si le noeud courant est pas déjà dans le chemin résultant 
                path.add(curr);
            }
            curr = findStation(pred.get(curr.getName()));
        }
        if (!path.contains(source)) { // vérifie si le noeud de départ n'est pas déjà dans le chemin
            path.add(source);
        }
        Collections.reverse(path);    // on inverse la liste pour l'avoir dans le bon ordre
        return path;
	}


    /**
     * Cette methode trouve une station dans le graph en utilisant son nom
     * @param name le nom de la station à trouver
     * @return La station trouvée, ou null si aucune station ne correspond à name dans le graph
     */
    public Station findStation(String name){
        for (Station station : this.stations){
            if (station.getName().equals(name)){
                return station;
            }
        }
        System.out.println("La station "+name+ " n'est pas dans le graphe");
        return null;
    }
}