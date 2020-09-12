
import java.lang.IndexOutOfBoundsException;

/**
 * La clase LinkedListJacSeb genera listas enlazadas para el almacenamiento de datos y su respectivo análisis.
 * @author Sebastián Guerra, Jacobo Rave
 * @version 1
 */

public class LinkedListJacSeb {
    private Node first;
    private int size;

    public LinkedListJacSeb(){
        this.size = 0;
        this.first = null;  
    }

    /**
     * El metodo getNode devuelve el nodo de la ubicación dada.
     * @param index posicion del nodo que se busca.
     * @return el nodo en la posición dada en la lista.
     * @throws IndexOutOfBoundsException
     */
    private Node getNode(int index) throws IndexOutOfBoundsException {
        if (index >= 0 && index < size) {
            Node temp = first;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
            return temp;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    /**
     * El metodo get devuelve el dato de la ubicación dada.
     * @param index posicion sobre la que se quiere buscar un dato.
     * @return el dato en la posición dada en la lista.
     * @throws IndexOutOfBoundsException
     */
    public int get(int index) throws IndexOutOfBoundsException {
        Node temp = getNode(index);
        return temp.data;
    }

    /**
     * El método size devuelve el tamaño de la lista enlazada.
     * @return size el tamaño de la lista enlazada.
     */
    public int size(){
        return this.size;
    }
    
    /**
     * El método first devuelve la cabeza de la lista enlazada.
     * @return first la cabeza de la lista enlazada.
     */
    public Node first(){
        return this.first;
    }


    /**
     * El metodo insert crea un nodo para ingresar un nuevo dato a la lista enlazada en determinada posicion.
     * @param data el dato que queremos adjuntar a la lista enlazada.
     * @param index la posicion en donde queremos adjuntar el nodo.
     * @throws IndexOutOfBoundsException
     */
    public void insert(int data, int index) throws IndexOutOfBoundsException{
        if (index < 0 || (index >= size && !(size == 0 && index > 0)) || (!(index >= size) && (size == 0 && index > 0)))
            throw new IndexOutOfBoundsException("Index: "+index);

        Node nuevo = new Node(data);

        if(index == 0){
            nuevo.next = this.first;
            this.first = nuevo;
            this.size++;
        }
        else{
            Node bloque = first;
            for (int i=1; i <= index-1; i++)
                bloque = bloque.next; 

            Node viejo = bloque.next;
            bloque.next = nuevo;
            nuevo.next = viejo;
            this.size++;
        }
    }

    /**
     * El metodo remove borra el nodo de la posición index.
     * @param index la posicion del nodo que se desea eliminar.
     * @throws IndexOutOfBoundsException
     */
    public void remove(int index) throws IndexOutOfBoundsException{
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index: "+index);
        
        Node bloque;       
        if(index == size-1){
            bloque = getNode(this.size-2);
            bloque.next = null;
        }
        else{    
            bloque = first;
            for (int i=1; i <= index-1; i++)
                bloque = bloque.next; 

            bloque.next = bloque.next.next;
            this.size--;
        }
    }

    /**
     * El metodo contains verifica si un dato esta en la lista enlazada.
     * @param data el dato que se quiere verificar.
     * @return valor booleano sobre la presencia del dato.
     */
    public boolean contains(int data){
        Node actual = first; //iniciamos en la cabeza 

        while (actual != null){ //Condición de parada
            if (actual.data == data)
                return true;
            actual = actual.next; //Si no cumple, revisamos el siguiente              
        }
        return false; //Retorna false al no encontrar un nodo con contenido data
    }
}

