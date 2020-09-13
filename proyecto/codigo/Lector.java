import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Lector{    
    public static void main(String[] args) {
        ArrayList<String[]> matriz = leerCSV();
        int i = 0;
        for(String[] a : matriz){
            String[] fila = matriz.get(i);
            i++;
            System.out.println(Arrays.asList(fila));
        }        
    }
    
    public static ArrayList<String[]> leerCSV(){
        ArrayList<String[]> datos = new ArrayList<String[]>();
        File archivo = new File("C:\\Users\\Jguerra\\Desktop\\Estructura de datos y algoritmos I\\4_test_balanced_135000.csv");

        try {
            Reader r = new FileReader(archivo);
            BufferedReader lector = new BufferedReader(r);
            String linea = lector.readLine();
            while ((linea = lector.readLine())!=null){ //O(m)
                datos.add(linea.split(";")); //O(m * n)
            } 
        } catch (IOException e) {
            e.getMessage();
        }
        return datos;
    } //Complejidad de O(m * n)
}
