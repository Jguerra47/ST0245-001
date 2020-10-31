import java.util.*;
/**
 * La clase Taller12 contiene los puntos solicitados en el taller.
 *
 * @author Isabel Piedrahita, Sebastian Guerra, Jacobo Rave
 * @version 2
 */

public class Taller12
{
    
    /**
     * El método pathDFS es la solución del primer punto del taller.
     * @param g el grafo en el que vamos a trabajar
     * @param source el nodo de donde parte la busqueda
     * @param destination el nodo al que se quiere llegar
     * @return el valor booleano sobre si hay un camino
     */
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

    /**
     * El método pathBFS es la solución del segundo punto del taller.
     * @param g el grafo en el que vamos a trabajar
     * @param source el nodo de donde parte la busqueda
     * @param destination el nodo al que se quiere llegar
     * @return el valor booleano sobre si hay un camino
     */
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

    /**
     * El método printVertexDFS es la solución del tercer punto del taller.
     * @param g el grafo en el que vamos a trabajar
     * @param source el nodo de inicio
     */
    public static void printVertexDFS(Graph g, int source){
        boolean [] checked = new boolean[g.size()+1];
        System.out.println("Partiendo del vertice "+source+" se alcanza:");
        auxPrintVertexDFS(g, source, checked);
    }

    private static void auxPrintVertexDFS(Graph g, int source, boolean[] checked){
        ArrayList<Integer> next = g.getSuccessors(source);        
        checked[source] = true;        
        System.out.println(source);
        
        //Caso base
        if(next.size() == 0){
            return;
        }
        
        //Caso recursivo
        for(int neighbor: next){
            if(!checked[neighbor]){
                auxPrintVertexDFS(g, neighbor, checked);
            }
        }
    }
    
    /**
     * El método printVertexBFS es la solución del cuarto punto del taller.
     * @param g el grafo en el que vamos a trabajar
     * @param source el nodo de inicio
     * @see <a href="https://www.youtube.com/watch?v=pcKY4hjDrxk&t=507s"> Basado en la explicacion de Abdul Bari </a>
     */
    public static void printVertexBFS(Graph g, int source){
        boolean [] checked = new boolean[g.size()+1];
        checked[source] = true;
        System.out.println("Partiendo del vertice "+source+" se alcanza:");
        System.out.println(source);
        Queue<Integer> cola = new LinkedList<Integer>();
        auxPrintVertexBFS(g, source, checked, cola);
    }

    private static void auxPrintVertexBFS(Graph g, int source, boolean[] checked, Queue cola){
        ArrayList<Integer> next = g.getSuccessors(source);   
        
        //Caso base
        if(next.size() == 0){
            return;
        }
        
        //Caso recursivo       
        for(int neighbor: next){
            if(!checked[neighbor]){  
                cola.add(neighbor);
                System.out.println(neighbor);
                checked[neighbor] = true; 
            }
        }
        
        while (cola.size() != 0){
            int sig = (int)cola.poll();
            auxPrintVertexBFS(g, sig, checked, cola);
        }        
    }

    public static void main() {
        Graph graph = new GraphAL(8);
        graph.addArc(1,2,0);
        graph.addArc(2,4,0);
        graph.addArc(1,5,0);
        graph.addArc(3,3,0);
        graph.addArc(5,3,0);
        graph.addArc(2,3,0);
        graph.addArc(2,6,0);
        graph.addArc(6,3,0);
        graph.addArc(7,8,0); //Isla


        System.out.println("\t---[Punto 1: Prueba Camino DFS]---");
        System.out.println("Hay camino entre 1 y 4: "+pathDFS(graph, 1, 4));
        System.out.println("Hay camino entre 1 y 5: "+pathDFS(graph, 1, 5));
        System.out.println("Hay camino entre 3 y 1: "+pathDFS(graph, 3, 1));
        System.out.println("Hay camino entre 3 y 3: "+pathDFS(graph, 3, 3));
        System.out.println("Hay camino entre 4 y 5: "+pathDFS(graph, 4, 5));
        System.out.println("Hay camino entre 1 y 8: "+pathDFS(graph, 1, 8));
        
        System.out.println("\t---[Punto 2: Prueba Camino BFS]---");
        System.out.println("Hay camino entre 1 y 4: "+pathBFS(graph, 1, 4));
        System.out.println("Hay camino entre 1 y 5: "+pathBFS(graph, 1, 5));
        System.out.println("Hay camino entre 3 y 1: "+pathBFS(graph, 3, 1));
        System.out.println("Hay camino entre 3 y 3: "+pathBFS(graph, 3, 3));
        System.out.println("Hay camino entre 4 y 5: "+pathBFS(graph, 4, 5));        
        System.out.println("Hay camino entre 1 y 8: "+pathBFS(graph, 1, 8));
        
        System.out.println("\t---[Punto 3: Prueba Vertices DFS]---");
        printVertexDFS(graph, 1);
        printVertexDFS(graph, 4);
        
        System.out.println("\t---[Punto 4: Prueba Vertices BFS]---");
        printVertexBFS(graph, 1);
        printVertexBFS(graph, 4);
    }
}
