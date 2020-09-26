
import java.util.Stack;
import java.util.Queue;
import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.Arrays;
/**
 * La clase Taller8 contiene los métodos solicitados en el taller 8.
 * @author Jacobo Rave, Sebastian Guerra
 * @version 2
 */
class Taller8{
    /**
     * El metodo notacionPolacaInversa representa la forma en que se evaluan las
     * operaciones aritmeticas en los procesadores
     * @param la cadena con notacion polaca inversa
     * @return el resultado de la operacion
     */
    public static int notacionPolacaInversa(String s){
        String simbolos = "+-*/";
        Stack<Integer> pila = new Stack();

        if (s.length() > 2){
            for (String subcadena: s.split(" ")){
                if (simbolos.contains(subcadena)){
                    if (subcadena.equals("+")){
                        pila.push(pila.pop() + pila.pop()); 
                    }
                    if (subcadena.equals("-")){
                        pila.push(-1 * pila.pop() + pila.pop()); 
                    }
                    if (subcadena.equals("*")){
                        pila.push(pila.pop() * pila.pop()); 
                    }
                    if (subcadena.equals("/")){
                        int numeroDeArriba = pila.pop();
                        int numeroDeAbajo =  pila.pop();
                        pila.push(numeroDeAbajo/numeroDeArriba); 
                    }
                }
                else
                    pila.push(Integer.parseInt(subcadena));
            }
        }

        return pila.pop();
    }

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