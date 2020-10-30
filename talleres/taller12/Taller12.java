import java.util.*;
/**
 * La clase Taller12 contiene los puntos solicitados en el taller.
 *
 * @author Isabel Piedrahita, Sebastian Guerra, Jacobo Rave
 * @version 1
 */

public class Taller12
{
    public static boolean pathDFS(Graph g, int source, int destination){
        boolean [] checked = new boolean[g.size()+1];
        return auxDFSPath(g, source, destination, checked);
    }

    private static boolean auxDFSPath(Graph g, int source, int destination, boolean[] checked){
        ArrayList<Integer> next = g.getSuccessors(source);
        checked[source] = true;
        boolean answer = false;

        if(destination == source){
            answer = true;
        }

        for(int neighbor: next){
            if(checked[neighbor] == false){
                answer = answer || auxDFSPath(g, neighbor, destination, checked);
            }
        }
        return answer;
    }

    public static boolean pathBFS(Graph g, int source, int destination){
        boolean [] checked = new boolean [g.size()+1];
        return auxBFSPath(g, source, destination, checked);
    }

    private static boolean auxBFSPath(Graph g, int source, int destination, boolean[] checked){
        ArrayList<Integer> visitedList = g.getSuccessors(source);
        Queue<Integer> cola = new LinkedList<Integer>();        
        checked[source] = true;
        
        //Caso base
        if(source == destination){
            return true;
        }
        
        //Caso recursivo
        boolean respuesta = false;
        for (int nodo: visitedList){
            if (!checked[nodo])
                cola.add(nodo);
        }   
        
        while (cola.size() != 0 && !respuesta){
            int sig = cola.poll();
            respuesta = auxBFSPath(g, sig, destination, checked);
        }
        return respuesta;
    }

    public static void main() {
        Graph graph = new GraphAL(5);
        graph.addArc(1,2,1);
        graph.addArc(2,4,2);
        graph.addArc(1,5,3);
        graph.addArc(3,3,4);
        
        System.out.println("---[Prueba DFS]---");
        System.out.println("Hay camino entre 1 y 4: "+pathDFS(graph, 1, 4));
        System.out.println("Hay camino entre 1 y 5: "+pathDFS(graph, 1, 5));
        System.out.println("Hay camino entre 3 y 1: "+pathDFS(graph, 3, 1));
        System.out.println("Hay camino entre 3 y 3: "+pathDFS(graph, 3, 3));
        System.out.println("Hay camino entre 4 y 5: "+pathDFS(graph, 4, 5));
        System.out.println("---[Prueba BFS]---");
        System.out.println("Hay camino entre 1 y 4: "+pathBFS(graph, 1, 4));
        System.out.println("Hay camino entre 1 y 5: "+pathBFS(graph, 1, 5));
        System.out.println("Hay camino entre 3 y 1: "+pathBFS(graph, 3, 1));
        System.out.println("Hay camino entre 3 y 3: "+pathBFS(graph, 3, 3));
        System.out.println("Hay camino entre 4 y 5: "+pathBFS(graph, 4, 5));
    }
}
