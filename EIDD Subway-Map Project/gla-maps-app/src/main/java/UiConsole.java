
import java.util.Scanner;
import java.util.List;


public class UiConsole {
    
    private Graph route;

    public UiConsole(Graph route) {
        this.route = route;
    }

    public void displayRoute(){
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;

        while (!quit){
            System.out.println("\n---------------- Menu principale ----------------");
            System.out.println("1. Trouver une station dans le plan");
            System.out.println("2. Calculer un chemin entre deux stations du plan");
            System.out.println("3. Quitter l'application");
            System.out.println("Veuillez entrer votre choix s'il vous plaît: ");
            int choice = scanner.nextInt();

            switch (choice){
                case 1:
                scanner = new Scanner(System.in);
                System.out.println("Entrez le nom de la station à trouver: ");
                String stationName = scanner.nextLine();
                Station station = route.findStation(stationName); 
                if(station!=null){
                    System.out.println("Station trouvée: "+station.getName()+", Connections: "+station.getConnections());
                }
                else{
                    System.out.println("Station non trouvée dans le plan");
                }
                    
                    
                    break;

                case 2:
                    scanner = new Scanner(System.in);
                    System.out.println("Entrez le nom de la station de depart: ");
                    String sourceName = scanner.nextLine();
                    scanner = new Scanner(System.in);
                    System.out.println("Entrez le nom de la station d'arrivée ");
                    String destName = scanner.nextLine();

                    Station source = route.findStation(sourceName);
                    Station dest = route.findStation(destName);

                    if (source != null && dest != null){
                        List<Station> itineraire = route.calculateRoute(source,dest);
                        System.out.println("Le plus court chemin trouvée: ");
                        int i=0;
                        for (Station s : itineraire){
                            
                            if(i==itineraire.size()-1){
                                System.out.print(s.getName());
                            }
                            else{
                                System.out.print(s.getName()+" -> ");
                                i++;
                            }
                        }
                        System.out.println("");
                        System.out.println("Terminé");
                    }
                    else {
                        System.out.println("Une ou plusieurs station non trouvées dans le plan");
                    }
                    break;

                case 3:
                    quit = true;
                    break;

                default:
                    System.out.println("Choix non valide. Veuillez réessayer ");
            }
        }
        System.out.println("A bientôt !");
        scanner.close();
    }


    public void initStations(){
        ReadData reader =new ReadCsv();
        route=new Graph(reader.readFile("plan.csv")); 
    }
}
