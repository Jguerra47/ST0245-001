import javafx.util.Pair;
/**
 * La clase Point22 contiene la solucion del punto 2.2 del laboratorio 4
 * 
 * @author Sebastian Guerra, Jacobo Rave 
 * @version 3
 */
public class Point22 {
    /**
    * Basado en lo descrito en los métodos de esta clase, se afirma que la complejidad del algoritmo es O(n), siendo n los caracteres de la cadena dada.
    */
    public static void main(String[] args){
        Tree arbol = construirArbol("5(3()())(2(3()())())");
        System.out.println(existeSuma(arbol));
    }    
    
    /**
     * El metodo construirArbol busca estructurar la informacion brindada
     * @param s la cadena con la estructura de un arbol
     * @return un arbol con todos sus nodos asociados
     */
    
    public static Tree construirArbol(String s){
        String[] tokens = s.split("");

        Node root = new Node((int)Integer.parseInt(tokens[0]));
        construirArbolAux(tokens, 1, root);
        return new Tree(root);
    }    
    
    /**
     * El metodo recursivo construirArbolAux es un auxiliar del metodo construirArbol. Su complejidad es O(n), siendo n cada uno de los caracteres de la cadena
     * @param tokens un arreglo con los elementos de la cadena dada al principio
     * @param pos la posicion en la que estamos
     * @param arbol es el nodo sobre el que estamos generando la relacion con sus hijos
     * @return la posicion en la que quedo
     */
    private static int construirArbolAux(String[] tokens, int pos, Node arbol){        
        boolean izquierdaLleno = false;
        boolean derechaLleno = false;
        //"5(3()())(2()())"
        //"5(3(4()(8()()))())(2()(1()()))"

        while(!derechaLleno){
            for (int j = pos; j<tokens.length; j++){
                String sub = tokens[j];
                             
                if(!sub.equals("(")){
                    continue;
                }
                if (sub.equals("(") && !izquierdaLleno){
                    if(!tokens[j+1].equals(")")){
                        arbol.left = new Node((int)Integer.parseInt(tokens[j+1]));
                        pos = construirArbolAux(tokens, j+2, arbol.left);
                        izquierdaLleno = true;
                        break;
                    }
                    else{
                        izquierdaLleno = true;
                        continue;
                    }
                }

                if (sub.equals("(") && izquierdaLleno && !derechaLleno){
                    if(!tokens[j+1].equals(")")){
                        arbol.right = new Node((int)Integer.parseInt(tokens[j+1]));
                        pos = construirArbolAux(tokens, j+2, arbol.right);
                        derechaLleno = true;
                        return pos+1;
                    }
                    else{
                        derechaLleno = true; 
                        return j+2;
                    }
                }
            }       
        }

        return pos;
    }
    
    
    /**
     * El metodo existeSuma verifica que exista al menos un camino en el arbol en el que la suma de su nodos de como resultado el valor de la raiz. Su complejidad es O(m), siendo m
     * los nodos en el arbol.
     * @param arbol sobre el cual vamos a investigar
     * @return cadena de texto sobre si lo encontro o no
     */
    public static String existeSuma(Tree arbol){
        int suma = arbol.root.num;        
        boolean respuesta = existeSumaAux(arbol.root.left, suma) || existeSumaAux(arbol.root.right, suma);
        if(respuesta){
            return "Yes";
        }
        return "No";
    }
    
    /**
     * El metodo existeSumaAux es un método auxiliar de existeSuma
     * @param hijo es un nodo sobre el que vamos a verificar su valor
     * @return valor booleano sobre si hay camino por el nodo dado
     */
    private static boolean existeSumaAux(Node hijo, int suma) {
        if (hijo == null){
            return false;  
        }
        else if (hijo.left == null && hijo.right == null){
            return suma == hijo.num;
        }
        else{
            int resta = suma - hijo.num;
            return existeSumaAux(hijo.left, resta) || existeSumaAux(hijo.right, resta); 
        }
    }
}
