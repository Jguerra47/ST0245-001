
/**
 * La clase InsertionSort contiene el método de ordenamiento de arreglos
 * 
 * @author Jacobo Rave, Sebastian Guerra
 * @version 1
 */
public class InsertionSort
{
   /**
    * @param array es un arreglo de números desordenados
    * El método insertionSort tiene la intención de ordenar los números
    * del arreglo array por el método insertion
    * mediante la anidación de funciones cíclicas
    */
    public static long[] insertionSort (long[] array){
        for(int i = 0; i < array.length; i++){
            for(int j = i; j >= 1; j--){
                if(array[j] < array[j-1]){
                    long aux = array[j-1];
                    array[j-1] = array[j];
                    array[j] = aux;
                }
                else{
                    break;
                }
            }
        }
        return array;
    }  
}
