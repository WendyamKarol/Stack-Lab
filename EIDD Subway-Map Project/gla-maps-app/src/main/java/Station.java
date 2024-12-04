import java.util.Set;
import java.util.ArrayList;
import java.util.Collection;
import java.util.TreeMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.time.LocalTime;

/**
 * Cette classe implémente des stations telle que celles de métro ou d'autre
 * transport en commun.
 * Elle a été conssus dans le cadre du cour de génie logiciel de 2ème année
 * d'école d'ingénieur à l'EIDD;
 * 
 * Proprité garantie :
 * Unicité des lignes. Une même ne peut pas passer plusieurs fois par la même
 * station.
 * 
 * @see ReadData
 * @see Graph
 * 
 * @version 4.3
 */
public class Station {
	private String name;
	private Map<String, List<Station>> VoisinStation; // Donne les stations voisines.
	private Set<String> connections; // Connexion possible depuis cette station
	private Map<String,TreeSet<LocalTime>> schedule;

	/**
	 * constructeur minimal de la classe
	 * 
	 * @since 2
	 * @param name Nom de la Station.
	 * @see Station#Station(String, Map, Map, String[])
	 * @see Station#Station(String, Collection)
	 */
	public Station(String name) {
		this.name = name;
		this.connections = new TreeSet<String>();
		this.VoisinStation = new TreeMap<String, List<Station>>();
		this.schedule = new TreeMap<String,TreeSet<LocalTime>>();
	}

	/**
	 * constructeur standard de la classe
	 * 
	 * @since 4
	 * @param name     Nom de la Station.
	 * @param schedule Les horraires de passage.
	 * @see Station#Station(String, Map, Map, String[])
	 */
	public Station(String name, Map<String,TreeSet<LocalTime>> schedule) {
		this.name = name;
		this.connections = new TreeSet<String>();
		this.VoisinStation = new TreeMap<String, List<Station>>();
		this.schedule = new TreeMap<>(schedule);
	}

	/**
	 * constructeur maximal de la classe
	 * 
	 * @since 1
	 * @param name
	 * @param VoisinStation
	 * @param connections
	 * @see Station#Station(String)
	 * @see Station#Station(String, Collection)
	 */
	public Station(String name, Map<String, List<Station>> VoisinStation, Set<String> connections,
	Map<String,TreeSet<LocalTime>> schedule) {
		this.name = name;
		this.VoisinStation = VoisinStation;
		this.connections = connections;
		this.schedule = new TreeMap<String,TreeSet<LocalTime>>(schedule);
	}

	/**
	 * @since v1
	 * @return Renvoie la station ainsi que c'est champs.
	 */
	@Override
	public String toString() {
		return "src.main.java.org.example.com.Station{" +
				"name='" + name + '\'' +
				", connections=" + connections +
				'}';
	}

	/**
	 * Getter standard
	 * 
	 * @since 1
	 * @return Renvoie un String contenant la valeur du champ name de la Classe
	 */
	public String getName() {
		return name;
	}

	/**
	 * Setter standard
	 * 
	 * @param name nouveau nom
	 * @since 3
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @since 1
	 * @param line Nom de la ligne don l'on veut obtenir les stations voisines.
	 * @return Renvoi la prochaine Station de la ligne en paramètre. si il n'y a pas
	 *         de prochaine station, renvoi null.
	 * @see Station#getVoisinStations()
	 */
	public List<Station> getVoisinStations(String line) {
		return VoisinStation.get(line);
	}

	/**
	 * @since 3.1
	 * @return Renvoi la List de toutes les stations voisines.
	 * @see Station#getVoisinStations(String)
	 */
	public List<Station> getVoisinStations() {
		List<Station> tmp = new ArrayList<>();
		List<Station> toadd = new ArrayList<>();
		for (String s : connections) {
			toadd = VoisinStation.get(s);
			if (toadd != null) {
				tmp.addAll(toadd);
			}
		}

		return tmp;
	}

	/**
	 * Getter standard
	 * 
	 * @since 1
	 * @return Renvoie un tableau de String contenant les noms des lignes passant
	 *         par la station.
	 */
	public Set<String> getConnections() {
		return connections;
	}

	/**
	 * Adder standard
	 * Maintient l'unicité des lignes
	 * 
	 * @since 3
	 * @param line nom de la ligne à ajouter au champ connection.
	 * @see Station#addConnection(Collection)
	 */
	public void addConnection(String line) {
		this.connections.add(line);
		this.VoisinStation.putIfAbsent(line, null);
	}

	/**
	 * Adder standard
	 * 
	 * @since 3
	 * @param lines Collection contenant les noms des lignes à ajouter au champ
	 *              connection.
	 * @see Station#addConnection(String)
	 */
	public void addConnection(Collection<String> lines) {
		this.connections.addAll(lines);
		lines.forEach(line -> this.VoisinStation.putIfAbsent(line, null));

	}

	/**
	 * Enlève tous les éléments liés à la ligne de tout les champs de la classe.
	 * 
	 * @param line Nom de la ligne à retirer.
	 * @since 3
	 * @see Station#removeVoisinCascade(String, Station)
	 */
	public void removeLine(String line) {
		this.connections.remove(line);
		this.VoisinStation.remove(line);
	}

	/**
	 * Adder standard
	 * 
	 * @since 2
	 * @param line    Nom de la ligne.
	 * @param station Station à ajouter.
	 * @see # ReadData# fillGraph(Graph)
	 */
	public void addVoisinStation(String line, Station station) {
		List<Station> l = this.VoisinStation.get(line);
		if (l == null) {
			ArrayList<Station> array = new ArrayList<>();
			array.add(station);
			this.VoisinStation.put(line, array);
		} else {
			l.add(station);
		}

	}

	/**
	 * Enlève une station des stations voisines sur la ligne. Si, par cette
	 * opération,
	 * il n'y a plus de station vosigne sur la ligne, la ligne est retiré de
	 * connection.
	 * 
	 * @param line    Nom de la ligne sur laquelle est la station.
	 * @param station Station à enlever.
	 * @since 3
	 * @see Station#removeLine(String)
	 */
	public void removeVoisinCascade(String line, Station station) {
		List<Station> l = this.VoisinStation.get(line);
		if (l.remove(station)) {
			if (l.isEmpty()) {
				this.connections.remove(line);
			}
		}
	}

	/**
	 * Forme combinné de addVoisinStation et addConnection.
	 * S'applique à l'appelant et au paramettre.
	 * 
	 * @param line
	 * @param station
	 * @since 3.2
	 */
	public void addStation(String line, Station station) {
		this.addConnection(line);
		this.addVoisinStation(line, station);

		station.addConnection(line);
		station.addVoisinStation(line, this);
	}

	/**
	 * Forme combinné de addVoisinStation et addConnection.
	 * S'applique à l'appelant et au paramettre.
	 * 
	 * @param line
	 * @param station
	 * @since 3.2
	 */
	public void addStation_(String line, Station station) {
		this.addConnection(line);
		this.addVoisinStation(line, station);
	}

	/**
	 * Renvoie un Boolean indiquant si la station est un terminus pour la ligne en
	 * paramètre.
	 * Du à la possibilité de sens unique, il est necessaire de parcourire toute la
	 * ligne.
	 * 
	 * @since 1
	 * @param line Nom de la ligne
	 * @return Renvoie un Boolean indiquant si la station est un terminus pour la
	 *         ligne en paramètre.
	 */
	public Boolean isTerminus(String line) {
		if (!connections.contains(line)) {
			return false;
		}
		if (this.getVoisinStations(line).size() == 1 && this.getVoisinStations(line).get(0) != null) {
			// test pour savoir si la station est dans une boucle (ex ligne 10 Porte
			// d'Autreuil)
			LinkedList<Station> aTraiter = new LinkedList<Station>();
			aTraiter.add(this);
			ArrayList<Station> b = new ArrayList<>();
			while (!aTraiter.isEmpty()) {
				Station tmp = aTraiter.poll();
				if (tmp.getVoisinStations(line) != null) {
					for (Station s : tmp.getVoisinStations(line)) {
						if (s == null) {
							continue;
						}
						if (!b.contains(s)) {
							if (s == this)
								return false;
							aTraiter.add(s);
							b.add(s);
						}
					}
				}
			}
			return true;
		}
		return false; // cas trivial, on peut prendre le métro dans les 2 sens.
	}

	/**
	 * getter standard
	 * 
	 * @return Les horaires complet sous forme de Set. L'implementation exact est
	 *         celle d'un TreeSet.
	 */
	public Map<String,TreeSet<LocalTime>> getSchedule() {
		return schedule;
	}

	/**
	 * Setter standard
	 * 
	 * @param sch Nouveaux horaires.
	 */
	public void setSchedule(String line,Collection<LocalTime> sch) {
		schedule = new TreeMap<String,TreeSet<LocalTime>>();
		schedule.put(line,new TreeSet<>(sch));
	}

	/**
	 * Ajoute un nouvel horaire de passage.
	 * 
	 * @param lt Nouvel horaire.
	 */
	public void addToSchedule(String line,LocalTime lt) {
		schedule.get(line).add(lt);
	}

	/**
	 * Donne l'horaire du prochain passage.
	 * 
	 * @param a Heure actuel.
	 * @param b Minute actuel
	 * @return L'heure du prochain passage.
	 */
	public LocalTime getNextPassage(String line, int a, int b) {
		return getNextPassage(line,LocalTime.of(a, b));
	}

	/**
	 * Donne l'horaire du prochain passage.
	 * 
	 * @param lt Heure et minute actuel.
	 * @return L'heure du prochain passage.
	 */
	public LocalTime getNextPassage(String line, LocalTime lt) {
		return schedule.get(line).ceiling(lt);
	}

	/**
	 * Renvoie la liste des temps pour aller au station voisine
	 * @param lt heure de départ de la station
	 * @return liste des temps pour aller au station voisine
	 * @since 4.1
	 */
	public Map<Station,Integer> timeToVoisinStations(LocalTime lt) {
		Map<Station,Integer> tmp = new TreeMap<>();
		for(String line : connections){
			for(Station s : this.getVoisinStations(line)){
				tmp.put(s,s.getNextPassage(line,s.getNextPassage(line,lt)).toSecondOfDay());
			}
		}
		return tmp;
	}

	/**
	 * Renvoie la liste des temps pour aller au station voisine
	 * @param a heure de départ de la station
	 * @param b minute de départ de la station
	 * @return liste des temps pour aller au station voisine
	 * @since 4.1
	 */
	public Map<Station,Integer> timeToVoisinStations(int a, int b) {
		return timeToVoisinStations(LocalTime.of(a,b));
	}

	/**
	 * Donne le temps de trajet pour aller à la station suivante.
	 * <strong> Attention </strong> Complexité pourrie, il est preferable d'utilisée {@link Station#timeToVoisinStations(LocalTime)}
	 * @param s Station suivante
	 * @param currentTime Heure de départ
	 * @return Un entier qui correspond au temps de trajet en seconde
	 * @since 4.2
	 */
	public Integer getTravelTime(Station s, LocalTime currentTime){
		return currentTime.minusSeconds(timeToVoisinStations(currentTime).get(s)).getSecond();
	}

}
