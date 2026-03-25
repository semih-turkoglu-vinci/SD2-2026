import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Graph {

    // key = id  value = Localisation
    Map<Long , Localisation> localisationsMap  = new HashMap<>() ;

    // key = une localisation    value = toutes ses localisation voisines
    Map<Localisation , List<Localisation>> localisationsAdjacentes  = new HashMap<>() ;


    public Graph(String localisations, String roads)  {

        // on lit les localisations(sommets)
        try (BufferedReader br = new BufferedReader(new FileReader(localisations))) {

            String line;

            while ((line = br.readLine()) != null) {

                String[] parts = line.split(",");

                long id = Long.parseLong(parts[0]);
                String name = parts[1];
                double lat = Double.parseDouble(parts[2]);
                double lon = Double.parseDouble(parts[3]);
                double alt = Double.parseDouble(parts[4]);

                Localisation loc = new Localisation(id, name , lat, lon, alt);


                localisationsMap.put(id, loc);
                localisationsAdjacentes.put(loc, new ArrayList<>());
            }

        } catch (IOException e){
            e.printStackTrace();
        }



        // on lit les routes(arcs)
        try (BufferedReader br = new BufferedReader(new FileReader(roads))) {

            String line;
            while ((line = br.readLine()) != null) {

                String[] parts = line.split(",");

                long id1 = Long.parseLong(parts[0]);
                long id2 = Long.parseLong(parts[1]);

                Localisation origine = localisationsMap.get(id1);
                Localisation destination = localisationsMap.get(id2);

                //  ajout du voisin dans un sens
                localisationsAdjacentes.get(origine).add(destination);

                // puis dans l'autre sens
                localisationsAdjacentes.get(destination).add(origine);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }



    }


    /**
     * La methode prend plusieurs points de départs
     * et simule la propagation de l'eau.
     * Elle renvoie tous les noeuds inondés dans l'ordre ou l'eau les atteint.
     */
    public Localisation[] determinerZoneInondee(long[] idsOrigin,double epsilon) {

        Queue<Localisation> queue =  new LinkedList<>() ;
        Set<Localisation> noeudsInondes = new HashSet<>() ;
        List<Localisation> list = new ArrayList<>() ;  // List des noeuds inondes dans l'odre ou l'eau atteint les noeuds


        // on parcourt les id origines
        for (long id : idsOrigin) {
            Localisation depart = localisationsMap.get(id);

            // on verifie que le noeud existe et qu'elle ne soit pas inonde
            if (depart != null && !noeudsInondes.contains(depart)) {

                queue.add(depart) ;
                noeudsInondes.add(depart);
                list.add(depart) ;

            }
        }


        //BFS
        while (!queue.isEmpty()) {
            Localisation courant = queue.poll();

            // recupere ses voisins
          List<Localisation> voisins =  localisationsAdjacentes.get(courant)  ;

            for(Localisation loc : voisins){

                if(!noeudsInondes.contains(loc) && loc.getAltitude()<= courant.getAltitude() + epsilon ){
                    noeudsInondes.add(loc) ;
                    queue.add(loc) ;
                    list.add(loc) ;
                }
            }
        }

		return list.toArray(new Localisation[0]);
    }



    /**
     *La methode permet de trouver le chemin le plus court en "nombres de rues" pour contourner la zone inondé
     **/
    public Deque<Localisation> trouverCheminLePlusCourtPourContournerLaZoneInondee(long idOrigin, long idDestination, Localisation[] floodedZone) {

        Deque<Localisation> chemin = new LinkedList<>() ;

        Localisation depart = localisationsMap.get(idOrigin);
        Localisation arrivee = localisationsMap.get(idDestination);

        Set<Localisation> zone = new HashSet<>(Arrays.asList(floodedZone));

        if(depart == null || arrivee ==  null || zone.contains(depart) || zone.contains(arrivee)) return  chemin ;


        return null ;
    }

    public Map<Localisation,Double> determinerChronologieDeLaCrue(long[] idsOrigin, double vWaterInit,double k) {
        //TODO
        return null ;
    }

    public Deque<Localisation> trouverCheminDEvacuationLePlusCourt(long idOrigin, long idEvacuation, double vVehicule, Map<Localisation,Double> tFlood) {
        //TODO
		return null ;
    }


}
