
import java.util.List;

public interface ReadData {
    public List<Station> readFile(String f); //changement de type de l'argument on le passe en string
    public void fillGraph(Graph g);
}
