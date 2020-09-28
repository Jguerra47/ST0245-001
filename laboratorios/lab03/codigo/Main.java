import java.util.ArrayList;
import java.util.HashMap;
import java.util.Arrays;
/**
 * Write a description of class Main here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Main
{
    public static MapaCiudad main(){
        HashMap<Long, Vertice> vertices = LectorDatos.leerVertices();
        ArrayList<Tripla<Long, Long, Double>> arcos = LectorDatos.leerArcos();
        MapaCiudad mapita = new MapaCiudad(vertices, arcos);    
        
        Double a = mapita.getDistancia(new Long(573427554), new Long(573427555)); //Debe dar 14.5973182469
        System.out.println(a);
        /*for(Tripla<Vertice, Vertice, Double> v : mapita.grafo){
            System.out.println(v.toStringJS());
        }*/
        
        return mapita;
    }
}
