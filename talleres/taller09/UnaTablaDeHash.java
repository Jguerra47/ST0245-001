
import java.util.LinkedList;
import javafx.util.Pair;
/**
 * La clase UnaTablaDeHash, es un plantilla para crear nuestra propia estructura hash
 * Dentro de sus características esta que tiene un string como llave (key) y un entero
 * como valor (value)
 * @author Jacobo Rave Londoño, Juan Sebastian Guerra 
 * @version 1
 */
public class UnaTablaDeHash
{
    private LinkedList<Pair<String, Integer>>[] tabla;

    /**
     * Este método define el array utilizado con 10 posiciones de manera que tenemos un límite de 10 elementos
     * 
     */
    public UnaTablaDeHash(){
        this.tabla = new LinkedList[26];
    }

    /**
     * @param k es la llave del elemento que servirá como referencia al buscar
     * Este método se utiliza para darle una posicion dentro de la tabla, donde para cada letra se asigne un numero del 0 a 25.
     */
    private int funcionHash(String k){
        return ((int) k.charAt(0));
    }

    /**
     * @param k es la llave del elemento que servirá como referencia al buscar
     * Este método se utiliza para obtener el elmento con la clave k, se enlaza con funcionHash
     */
    public int get(String k){
        int posicion = funcionHash(k);
        LinkedList<Pair<String,Integer>> listica = tabla[posicion];

        if(listica!=null){
            for(int i = 0 ; i<listica.size() ;i++)
                if(listica.get(i).getKey().equals(k)){
                    return listica.get(i).getValue();

                }
        }  

        return -1;
    }

    /**
     * @param k es la llave del elemento que servirá como referencia al buscar posteriormente
     * @param v es el valor asociado a la llave k
     * Este método se utiliza para agregar un nuevo elemento
     */
    public void put(String k, int v){
        Pair<String, Integer> parejita = new Pair(k,v);
        int posicion = funcionHash(k);
        if(tabla[posicion]==null){
            tabla[posicion] = new LinkedList<Pair<String, Integer>>(); 
        }
        tabla[posicion].add(parejita);
    }
}
