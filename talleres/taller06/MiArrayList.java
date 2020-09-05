/**
 * La clase MiArrayList tiene la intención de representar un objeto que simule el comportamiento
 * de la clase ya implementada "ArrayList"
 * 
 * Para más información de la clase ArrayList:
 * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html"> Ver documentacion ArrayList </a>
 * 
 * 
 * @author Jacobo Rave, Sebastian Guerra
 * @version 1
 */

public class MiArrayList {
    private int size;
    private static final int DEFAULT_CAPACITY = 10;
    private int elements[]; 

    /**
     * El metodo constructor se utiliza para incializar
     * variables a valores neutros como 0 o null.
     * El contructor no lleva parámetros en este caso.
     */
    public MiArrayList() {
        this.size = 0;
        this.elements = new int[DEFAULT_CAPACITY];
    }     

    /**
     * Tiene la intención de retornar la longitud del objeto
     * @return longitud del objeto
     *
     * El size esta influenciado por las funciones add y del
     */
    public int size() {
        return this.size;
    }   

    /** 
     * @param e el elemento a guardar
     * Agrega un elemento e a la última posición de la lista
     *
     */
    public void add(int e) {
        if (size == elements.length) {
            int[] otroArreglo = new int[elements.length*2];
            for (int i = 0; i < elements.length; i++) // O(n)
                otroArreglo[i] = elements[i];
            elements = otroArreglo;
        }

        elements[size] = e;
        this.size++; 
    }    // T(n) = O(n) 

    /** 
     * @param i es un íncide donde se encuentra el elemento posicionado
     * Retorna el elemento que se encuentra en la posición i de la lista.
     *
     */
    public int get(int i) throws Exception{
        if (i >= size || i < 0)
            throw new Exception("index: " + i);
        return elements[i];
    }

    /**
     * @param index es la posicion en la cual se va agregar el elemento
     * @param e el elemento a guardar
     * Agrega un elemento e en la posición index de la lista
     *
     * La complejidad de agregar n abejas es de O(n)
     * Basado en las pruebas realizadas con los datasets podemos asegurar que este algoritmo es
     * recomendable para el procesamiento de millones de abejas
     * Probando con 2 millones de abejas la duración fue de 5 segundos.
     */
    public void add(int index, int e) throws Exception {
        if (index > size || index < 0)   // O(1)
            throw new Exception("Index -> " + index); // O(1)

        int[] copyArray; // O(1)

        if (size == elements.length) // O(1)
            copyArray = new int[elements.length*2]; // O(1)
        else
            copyArray = new int[elements.length]; // O(1)

        for(int i = 0; i < index; i++){ // O(n)
            copyArray[i] = elements[i]; // O(n)
        }

        copyArray[index] = e; // O(1)

        for(int i = index; i < copyArray.length-1; i++){ // O(n)
            copyArray[i+1] = elements[i]; // O(n)
        }
        this.size++; // O(1)
        this.elements = copyArray; // O(1)
    }    // T(n) = O(n) 

    /**
     * @param index es la posicion en la cual se va eliminar el elemento
     *
     * Elimina el elemento  en la posición index de la lista
     *
     */
    public void del(int index) throws Exception{
        if (index > size || index < 0)   // O(1)
            throw new Exception("Index -> " + index); // O(1)

        int[] copyArray = new int[elements.length]; // O(1)

        for(int i = 0; i < index; i++){ // O(n)
            copyArray[i] = elements[i]; // O(n)
        }

        for(int i = index; i < copyArray.length-1; i++){ // O(n)
            copyArray[i] = elements[i+1]; // O(n)
        }
        this.size--; // O(1)
        this.elements = copyArray; // O(1)
    }// T(n) = O(n) 
    
    /**   
     * Ajusta el tamaño del arreglo basado en el size
     */
    public void trim(){
        int[] len = new int[size];
        for(int i = 0; i < this.size; i++){ // O(n)
            len[i] = elements[i]; // O(n)
        }
        this.elements = len;
    }// T(n) = O(n) 
}
