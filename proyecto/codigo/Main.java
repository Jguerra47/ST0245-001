
import javafx.util.Pair;
import java.util.ArrayList;
import java.io.*;
public class Main
{
    public static void main(String[] args){
        ArrayList<String[]> m = Lector.leerCSV();
        String[][] matriz = new String[m.size()][m.get(0).length];
        
        for (int i = 0; i < matriz.length; i++) {  
            matriz[i] = m.get(i);
        }
        
        //Variable 52: Naturaleza_Colegio ("OFICIAL", "NO OFICIAL")
        //Variable 17: Genero ("M", "F")
        //Variable 
        Pair<String[][],String[][]> pareja = dividirUnaMatrizEnDosMatrices(matriz, 52, "OFICIAL");
        float impureza1 = impurezaGiniDeUnaMatriz(pareja.getKey());
        float impureza2 = impurezaGiniDeUnaMatriz(pareja.getValue());
        System.out.println("La impureza de que se cumpla es: " + impureza1);
        System.out.println("La impureza de que NO se cumpla es: " + impureza2);
    }

    public static Pair<String[][],String[][]> dividirUnaMatrizEnDosMatrices(String[][] m, int posVariable, String valor){
        int varSIEsIgualAlValor = 0;
        int varNOEsIgualAlValor = 0;

        for (String[] fila: m){  //for each #1
            if (fila[posVariable].equals(valor)){
                varSIEsIgualAlValor++;
            }else{
                varNOEsIgualAlValor++;
            }
        }

        String[][] matrizVarSIEsIgualAlValor = new String[varSIEsIgualAlValor][m[0].length];
        String[][] matrizVarNOEsIgualAlValor = new String[varNOEsIgualAlValor][m[0].length];

        int fila1 = 0;
        int fila2 = 0;

        for(String[] fila: m){ //for each #2
            if(fila[posVariable].equals(valor)){
                matrizVarSIEsIgualAlValor[fila1] = fila;                
                fila1++;
            }else{
                matrizVarNOEsIgualAlValor[fila2] = fila;                
                fila2++;
            }
        }

        Pair<String[][],String[][]> parejaMatrices = new Pair(matrizVarSIEsIgualAlValor,matrizVarNOEsIgualAlValor);
        return parejaMatrices;
    }

    public static float impurezaGiniDeUnaMatriz(String[][] m){
        int estudiantesWin = 0;
        int estudiantesFail = 0;

        for(String[] fila: m){
            if (fila[77].equals("1")){
                estudiantesWin++;
            }//fila.length-1
            else{
                estudiantesFail++;
            }
        }

        float proporcionEstudiantesWin = (float)estudiantesWin/m.length;        
        float proporcionEstudiantesFail = (float)estudiantesFail/m.length;

        float impurezaGini= 1-((float)Math.pow(proporcionEstudiantesWin, 2)+(float)Math.pow(proporcionEstudiantesFail, 2));
        return impurezaGini;        
    }    

}
