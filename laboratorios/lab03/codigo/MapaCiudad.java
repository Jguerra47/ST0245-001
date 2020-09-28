import java.util.*;
public class MapaCiudad
{
    private int size;
    public ArrayList<Tripla<Vertice, Vertice, Double>> grafo;

    public MapaCiudad(HashMap<Long, Vertice> vertices, ArrayList<Tripla<Long, Long, Double>> arcos){
        this.grafo = new ArrayList<>();
        asignarElementos(vertices, arcos);
        this.size = grafo.size();
    }

    /**
     *Este método asigna los elementos de los vertices y los añade al grafo
     *
     *@param HashMap<Long, Vertice> vertices recibe un hashmap con su key y valor.
     *@paramArrayList<Tripla<Long, Long, Double>> arcos recibe un Arraylist con una tripla con su x y z.
     *
     */
    public void asignarElementos(HashMap<Long, Vertice> vertices, ArrayList<Tripla<Long, Long, Double>> arcos){        
        for(Tripla<Long, Long, Double> t: arcos){
            if(vertices.containsKey(t.x)){
                if(vertices.containsKey(t.y)){
                    Vertice origen = new Vertice(t.x);
                    Vertice destino = new Vertice(t.y);
                    this.grafo.add(new Tripla<Vertice, Vertice, Double>(origen, destino, t.z));
                }
            }
        }              
    }//O(n)

    
    /**
     * Metodo para obtener la longitud entre dos vertices
     * 
     * @param origenID desde donde inicia el arco
     * @param destinoID donde termina el arco
     * @return un entero con dicha distancia
     */ 
    
    public Double getDistancia(Long origenID, Long destinoID){             
        for(Tripla<Vertice, Vertice, Double> t: this.grafo){            
            if(t.x.id.equals(origenID) && t.y.id.equals(destinoID)){                
                return new Double(t.z);             
            }      
        }
        return null;
    } //O(n)
    

    /**
     * Metodo que tiene la intencion de retornar el tamaño del grafo
     * @return tamaño del grafo
     */
    public int size() {
        return this.size;
    } //O(1)
}
