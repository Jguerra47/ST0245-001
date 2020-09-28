import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.lang.Object;
import java.util.*;

/**
 * La clase LectorDatos retoma los datos presentes en un txt y los organiza en diversas estructuras
 * 
 * @author Sebastian Guerra, Jacobo Rave, Mauricio Toro
 * @version 2
 */
public class LectorDatos
{
    public static HashMap<Long, Vertice> leerVertices() {
        HashMap<Long, Vertice> vertices = new HashMap<>();
        try{
            FileReader f  = new FileReader("Vertices.txt");
            BufferedReader lector = new BufferedReader(f);
            String linea;
            int numFila = 0;
            while((linea = lector.readLine()) != null) { //O(n)
                if(numFila != 0) {
                    String[] data = linea.split(" "); //O(n*m)
                    Long id = Long.parseLong(data[0]);
                    Vertice v = new Vertice(id);
                    vertices.put(v.id, v);  //Según https://javabypatel.blogspot.com/2015/10/time-complexity-of-hashmap-get-and-put-operation.html la complejidad de put es O(n)
                }
                numFila++;
            }
            lector.close();
            return vertices;
        }catch (IOException e) {
            System.out.println("Asegurece de tener el documento ''Vertices.txt''");
        }
        return vertices;
    }   //Complejidad de O(n*m)

    
    /**
 * La clase LectorDatos retoma los datos presentes en un txt y los organiza en diversas estructuras
 * 
 * @author Sebastian Guerra, Jacobo Rave, Mauricio Toro
 * @version 2
 */
    public static ArrayList<Tripla<Long, Long, Double>> leerArcos() {
        ArrayList<Tripla<Long, Long, Double>> arcos = new ArrayList<>();
        try{
            FileReader f  = new FileReader("Arcos.txt");
            BufferedReader lector = new BufferedReader(f);
            String linea;
            int numFila = 0;
            while((linea = lector.readLine()) != null) { //O(n)
                if(numFila != 0) {
                    String[] data = linea.split(" "); //O(n*m)
                    Long origen = Long.parseLong(data[0]);
                    Long destino = Long.parseLong(data[1]);
                    Double distancia = Double.parseDouble(data[2]);
                    Tripla<Long, Long, Double> a = new Tripla(origen, destino, distancia);
                    arcos.add(a); //add() es O(1)
                }
                numFila++;
            }    //O(n*m)
            lector.close();
        }catch (IOException e) {
            System.out.println("Asegurece de tener el documento ''Arcos''");
        }
        return arcos;
    }   //Complejidad de O(n*m)
}
