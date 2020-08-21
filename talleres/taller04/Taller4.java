/**
 *La clase Taller4 dos tiene como objetivo dar solución al taller 4
 *
 *@autor Mauricio Toro, Camilo Paez, Jacobo Rave y Sebastián Guerra
 *@version 1.1
 */

public class Taller4 {


    /**
     * @param array es un arreglo de numeros enteros
     * @param n la longitud del array anterior
     *
     *en este método se busca hacer la suma de los numeros en un
     *arreglo de forma recursiva.
     *
     * @return la suma
     */
    public static int arrayMax(int[] a){
        return arrayMax(a, a.length);
    }

    private static int arrayMax(int[] a, int lon){
        if (lon == 1){
            return a[0];}
        else
            return Math.max(a[lon-1], arrayMax(a, lon-1)); // T(n) = c2 + T(n-1)
        // T(n) = c1 + c2.n
    }

    /**
     * @param start es un contador, nos sirve para saber cuando debemos parar
     * @param array es un arreglo de numeros enteros, representan volumen
     * @param max es la meta, el numero que debe alacanzar la suma
     *
     * en este método se busca hacer la suma de los volumnes posibles
     * de modo que se acomode de tal forma que se alcance el valor max
     * pista: la clave esta en el numero de elementos y que no siempre se toman
     * los elementos, en ocaciones pasan por ejemplo en un conjuntos [5,6,7,8] para un
     * max 12 se toman el 5 y el 7 pasando por 6 sin cogerlo.
     *
     *
     * @return verdadero si hay una combinación que suponga el valor max, falso de lo contrario
     */

    public static boolean sumaGrupo(int[] volumenes, int max){
        return sumaGrupo(0, volumenes, max);
    }

    private static boolean sumaGrupo(int start, int[] volumenes, int max) {
        if (start >= volumenes.length){
            return max == 0; }// T(n) = c1 = 5
        else {
            return sumaGrupo(start + 1, volumenes, max) || sumaGrupo(start + 1, volumenes, max - volumenes[start]);
            // T(n) = c2 + T( n - 1 ) + T( n - 1 ) , donde c2 = 7
        }  // T(n) = c2 (2^n - 1) + c1 2^(n-1) = constantota * 2 ^n + constante
    }


    /**
     * @param n numero entero, hasta que numero se hace la serie
     *
     * el metodo se encarga de devolvernos el valor fibonacci en la enesima posicion
     * @return el valor encontrado en long dada la posible cantidad de bits
     */
    public static long fibonacci(int n) {
        if (n <= 1){
            return n;}
        else{
            return fibonacci(n-1) + fibonacci(n-2);}
    }
}
