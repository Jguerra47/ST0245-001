import java.util.ArrayList;
import javafx.util.Pair;
import java.io.*;
/**
 * Implementacion de un grafo dirigido usando matrices de adyacencia
 *
 * @author Mauricio Toro, Mateo Agudelo, Sebastian Guerra, Jacobo Rave
 */
public class DigraphAM extends Digraph {

    ArrayList<ArrayList<Integer>> matriz = new ArrayList<>();

    /**
     * Constructor para el grafo dirigido
     * @param vertices el numero de vertices que tendra el grafo dirigido
     *
     */
    public DigraphAM(int size) {
        super(size);
    }

    /**
     * Metodo para añadir un arco nuevo, donde se representa cada nodo con un entero
     * y se le asigna un peso a la longitud entre un nodo fuente y uno destino  
     * @param source desde donde se hara el arco
     * @param destination hacia donde va el arco
     * @param weight el peso de la longitud entre source y destination
     */
    public void addArc(int source, int destination, int weight) {
        matriz.get(source).add(destination,weight);
    }

    /**
     * Metodo para obtener una lista de hijos desde un nodo, es decir todos los nodos
     * asociados al nodo pasado como argumento
     * @param vertex nodo al cual se le busca los asociados o hijos
     * @return todos los asociados o hijos del nodo vertex, listados en una ArrayList
     * Para más información de las clases:
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html"> Ver documentacion ArrayList </a>
     */
    public ArrayList<Integer> getSuccessors(int vertex) {
        ArrayList<Integer> sucesores  = new ArrayList<>();
        ArrayList<Integer> Fila  = matriz.get(vertex);

        for(Integer f: Fila){
            int num = (int)f;
            if(num==1){
                sucesores.add(f);
            }
        }
        return sucesores;
    }

    /**
     * Metodo para obtener el peso o longitud entre dos nodos
     * 
     * @param source desde donde inicia el arco
     * @param destination  donde termina el arco
     * @return un entero con dicho peso
     */ 
    public int getWeight(int source, int destination)  {
        int peso = matriz.get(source).get(destination);

        if(peso==0){
            System.out.print("No existe un arco con los nodos dados");
        }

        return peso;
    }
}
