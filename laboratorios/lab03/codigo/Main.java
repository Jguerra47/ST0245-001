import java.util.ArrayList;
import java.util.HashMap;
import java.util.Arrays;
/**
 * @author Sebastian Guerra, Jacobo Rave, Mauricio Toro
 * @version 2
 */
public class Main
{
    public static MapaCiudad main(){
        HashMap<Long, Vertice> vertices = LectorDatos.leerVertices();
        ArrayList<Tripla<Long, Long, Double>> arcos = LectorDatos.leerArcos();
        MapaCiudad medellin = new MapaCiudad(vertices, arcos);    
        
        Double a = medellin.getDistancia(new Long(573427554), new Long(573427555)); //Debe dar 14.5973182469
        System.out.println("La distancia entre los dos vertices con los ID ingresados es de: " + a);
        
        /*
        //Este ciclo permite ver todas los elementos que forman el grafo de Medellin
        for(Tripla<Vertice, Vertice, Double> v : medellin.grafo){
            System.out.println(v.toStringJS());
        }
        */        
        
        return medellin;
    }
}
