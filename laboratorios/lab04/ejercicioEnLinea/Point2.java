import java.util.ArrayList;

/**
* La clase Point2 contiene la adaptacion de lectura de preOrden a posOrden de un arbol de busqueda binario.
* @author Sebastian Guerra, Jacobo Rave
* @version 1
*/
public class Point2 { 
    /**
    * La clase Node es la implementación de una estructura que contiene un dato y dos posibles hijos
    */
    public class Node {
        public Node left;
        public Node right;
        public int data;
        public Node (int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public Node raiz;
    
    /**
    * El metodo buildingTree cumple la funcion de construir un arbol basado en el recorrido preOrden
    * @param preOrder es un arreglo con los valores del recorrido de un arbol por preorden
    * @see insert()
    */
    public void buildingTree (int[] preOrder) {
        this.raiz = new Node(preOrder[0]);
        for(int i = 1; i < preOrder.length; i++){
            insert(raiz, preOrder[i]);
        }
    }
    
    /**
    * El metodo recursivo insert es un auxiliar para la construccion del arbol con el metodo buildingTree.
    * Nuestro caso base será cuando no pueda seguir desplazándose a traves de las ramas
    * @param nodo es el nodo al cual se le va a asignar un nuevo nodo hijo (por izquierda o derecha)
    * @param data el dato que queremos ingresar al arbol
    */
    public void insert(Node nodo, int data) {
        if((data < nodo.data) && nodo.left == null) {
            nodo.left = new Node(data);
        }else if((data > nodo.data) && nodo.right == null) {
            nodo.right = new Node(data);
        }        
        else if((data < nodo.data) && nodo.left != null) {
            insert(nodo.left, data);
        }        
        else if ((data > nodo.data) && nodo.right != null){
            insert(nodo.right,data);
        }        
    }
    
    /**
    * El metodo recursivo preOrder recorre por preOrder un arbol. Es usado para probar que la creacion del arbol se haya hecho exitosamente
    * @param nodo es el nodo al que vamos a recorrer en izquierda y derecha, imprimiendo primero su valor
    */
    public void preOrder(Node nodo) { 
        if(nodo != null) {
            System.out.println(nodo.data);
            preOrder(nodo.left);
            preOrder(nodo.right);
        }
    }
    
    /**
    * El metodo recursivo posOrder recorre por preOrder un arbol.
    * @param nodo es el nodo al que vamos a recorrer en izquierda y derecha, imprimiendo en ultimo lugar su valor
    */
    public void posOrder(Node nodo) {
        if(nodo != null) {
            posOrder(nodo.left);
            posOrder(nodo.right);
            System.out.println(nodo.data);
        }        
    }
    
    /**
    * El metodo exercise21 construye un arbol para la conversion de su recorrido.
    * @param input es un arreglo con los datos del recorrido por preOrder del arbol
    */
    public void exercise21 (int[] input) {
        buildingTree(input);
        System.out.println("PosOrder");
        posOrder(raiz);
        System.out.println();
    }
    
    /**
    * El metodo main inicializa la prueba de los metodos respectivos.
    */
    public static void main (String [] args) {
        int [] test = {50,30,24,5,28,45,98,52,60};
        Point2 testing = new Point2();
        testing.exercise21(test);
    }
}
