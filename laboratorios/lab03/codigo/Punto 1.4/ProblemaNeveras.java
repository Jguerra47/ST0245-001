
import java.util.Stack;
import java.util.Queue;
import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.Arrays;
/**
 * La clase ProblemaNeveras contiene el algoritmo solicitado en el punto 1.4 del laboratorio 3.
 * @author Jacobo Rave, Sebastian Guerra
 * @version 3
 */
class ProblemaNeveras{ 
    /**
     * El metodo asignarNeveras asigna un arreglo de neveras a una tienda en funcion de sus solicitudes y del inventario en almacen
     * @param neveras inventario de neveras organizadas en el almacen
     * @param solicitudes las peticiones de las tiendas organizadas en su orden de pedido
     * @return una lista con todas las asignaciones realizadas
     */
    public static ArrayList<Asignacion> asignarNeveras(Stack<Nevera> neveras, Queue<Solicitud> solicitudes) throws Exception{
        ArrayList<Asignacion> listaAsign = new ArrayList<Asignacion>();

        if(neveras.empty()){
            throw new Exception("No hay neveras para las solicitudes");     
        }
        try{
            for (Solicitud solicitud : solicitudes){ 
                if(neveras.empty()){
                    throw new Exception("No hay suficientes neveras para todas las solicitudes");
                }
                int cantidad = solicitud.getNumNeveras();
                Nevera[] arrayNeveras = new Nevera[cantidad];
                for(int i=0; i < cantidad; i++){                    
                    if(neveras.empty()){
                        Nevera[] temp = Arrays.copyOfRange(arrayNeveras, 0, i);
                        arrayNeveras = temp;
                        break;                    
                    }
                    else{
                        Nevera neveraAsignada = neveras.pop();
                        arrayNeveras[i] = neveraAsignada;
                    }
                }
                Asignacion asignacion = new Asignacion(solicitud.getNombreTienda(), arrayNeveras);
                listaAsign.add(asignacion);
            }
        }              
        finally{
            return listaAsign; 
        }
    }
}
