import java.util.Stack;
/*
 * La clase Taller8 contiene los métodos solicitados en el taller.
 * @author Jacobo Rave y Sebastian Guerra
 * @version 1
 */
class Taller8{
    /*
     * El metodo notacionPolacaInversa representa la forma en que se evaluan las
     * operaciones aritmeticas en los procesadores
     * @param la cadena con notacion polaca inversa
     * @return el resultado de la operacion
     /
    public static int notacionPolacaInversa(String s){
        String simbolos = "+-/";
        Stack<Integer> pila = new Stack();

        if (s.length() > 2){
            for (String subcadena: s.split(" ")){
                if (simbolos.contains(subcadena)){
                    if (subcadena.equals("+")){
                        pila.push(pila.pop() + pila.pop()); 
                    }
                    if (subcadena.equals("-")){
                        pila.push(-1 * pila.pop() + pila.pop()); 
                    }
                    if (subcadena.equals("*")){
                        pila.push(pila.pop() * pila.pop()); 
                    }
                    if (subcadena.equals("/")){
                        int numeroDeArriba = pila.pop();
                        int numeroDeAbajo =  pila.pop();
                        pila.push(numeroDeAbajo/numeroDeArriba); 
                    }
                }
                else
                    pila.push(Integer.parseInt(subcadena));
            }
        }

        return pila.pop();
    }
}
