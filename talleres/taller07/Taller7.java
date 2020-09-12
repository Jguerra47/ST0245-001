
/**
 * La clase Taller7 contiene el método recursivo solicitado en el taller.
 * 
 * @author Jacobo Rave, Sebastian Guerra
 * @version 1
 */

public class Taller7
{  
    public static void main(String args[]){
        LinkedListJacSeb a = new LinkedListJacSeb();
  
        a.insert(3,0);
        a.insert(8,1);
        a.insert(10,2); //Dato mayor
        a.insert(1,3);
        a.insert(5,4);
    
        int as = encontrarMayor(a);
        System.out.println("El dato mayor de la lista enlazada es: "+ as) ;
    }
    
    public static int encontrarMayor(LinkedListJacSeb listaEnlazada){
        Node cabeza = listaEnlazada.first();
        return mayorAux(cabeza,0);
    }
    
    public static int mayorAux(Node nodoActual, int mayor){
        if(nodoActual == null){
            return mayor;
        }
        else{           
            mayor = Math.max(nodoActual.data, mayor);
            return mayorAux(nodoActual.next, mayor);
        }
    }
}
