import javafx.util.Pair;
import java.util.ArrayList;
import java.util.*;
import java.io.*;

public class Main
{
    public static void main(String[] args) throws Exception{
        ArrayList<String[]> m = Lector.leerCSV();
        String[][] matriz = new String[m.size()][m.get(0).length];

        for (int i = 0; i < matriz.length; i++) {  
            matriz[i] = m.get(i);
        }

        int iteradorColumna = 6;
        float impurezaPonderada = 0;
        ArrayList<Object> respuestas = posiblesValores(matriz, iteradorColumna);
        for(int s = 0; s < matriz.length; s++){
            if(respuestas.get(s).getClass().getName().equals("java.lang.Float")){
                float mediaAritmetica = ((Float)respuestas.get(0)).floatValue();
                System.out.print("Condicion elegida: Promedio--> "+mediaAritmetica);
                Pair<String[][],String[][]> pareja = dividirUnaMatrizEnDosMatrices(matriz, iteradorColumna, mediaAritmetica);
                impurezaPonderada = giniPonderado(pareja.getKey(), pareja.getValue(), iteradorColumna);
                break;
            }
            else if(respuestas.get(s).getClass().getName().equals("java.lang.String")){
                impurezaPonderada = determinarMinimaImpureza(respuestas, matriz, iteradorColumna);
                break;
            }
        }
        System.out.println("La impureza ponderada es: " + impurezaPonderada);
    }

    public static float determinarMinimaImpureza(ArrayList<Object> respuestas, String[][] matriz, int iteradorColumna){
        float minImpureza = 1;
        for(Object s: respuestas){
            String condicionEnCadena = (String)s;
            System.out.println("Condicion elegida: "+condicionEnCadena);
            Pair<String[][],String[][]> pareja = dividirUnaMatrizEnDosMatrices(matriz, iteradorColumna, condicionEnCadena);
            minImpureza = (float)Math.min(minImpureza, giniPonderado(pareja.getKey(), pareja.getValue(), iteradorColumna));
        } 
        return minImpureza;
    }
    public static ArrayList<Object> posiblesValores(String[][] m, int posVariable){
        ArrayList<Object> respuestasDeVariable =  new ArrayList<>();

        if(!esNumero(m[0][posVariable])){
            for (String[] fila: m){                
                String valor = fila[posVariable];
                if(valor.isEmpty()){
                    continue;
                }
                boolean cond = true;
                for(Object o: respuestasDeVariable){
                    if(o.equals(valor)){
                        cond = false;
                        break;
                    }
                }

                if(cond){
                    respuestasDeVariable.add(valor);
                }
            }
        }

        else{
            respuestasDeVariable.add(calcularMediaDeAtributo(m, posVariable));
        }
        return respuestasDeVariable;
    }

    public static float calcularMediaDeAtributo(String[][] m, int posVariable){
        float sumaDeAtributo = 0;        
        for (String[] fila: m){
            if(!fila[posVariable].isEmpty()){
                sumaDeAtributo += (float)Float.parseFloat(fila[posVariable]);  
            }
        }
        float media = sumaDeAtributo/m.length;
        return media;
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
        System.out.println("Si cumplen: " + matrizVarSIEsIgualAlValor.length);
        System.out.println("No cumplen: " + matrizVarNOEsIgualAlValor.length);

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

    public static Pair<String[][],String[][]> dividirUnaMatrizEnDosMatrices(String[][] m, int posVariable, float valor) throws Exception{
        int varSIEsIgualAlValor = 0;
        int varNOEsIgualAlValor = 0;

        for (String[] fila: m){  //for each #1            
            float elementoDeLaFila = (float)Float.parseFloat(fila[posVariable]);
            if (elementoDeLaFila >= valor){
                varSIEsIgualAlValor++;
            }else{
                varNOEsIgualAlValor++;
            }
        }

        String[][] matrizVarSIEsIgualAlValor = new String[varSIEsIgualAlValor][m[0].length];
        String[][] matrizVarNOEsIgualAlValor = new String[varNOEsIgualAlValor][m[0].length];
        System.out.println("Si cumplen: " + matrizVarSIEsIgualAlValor.length);
        System.out.println("No cumplen: " + matrizVarNOEsIgualAlValor.length);

        int fila1 = 0;
        int fila2 = 0;

        for(String[] fila: m){ //for each #2
            if(esNumero(fila[posVariable])){
                float elementoDeLaFila = (float)Float.parseFloat(fila[posVariable]);
                if(elementoDeLaFila >= valor){                
                    matrizVarSIEsIgualAlValor[fila1] = fila;
                    fila1++;
                }else{
                    matrizVarNOEsIgualAlValor[fila2] = fila;        
                    fila2++;            
                }     
            }
            else{
                matrizVarNOEsIgualAlValor[fila2] = fila;        
                fila2++;     
            }
        }

        Pair<String[][],String[][]> parejaMatrices = new Pair(matrizVarSIEsIgualAlValor,matrizVarNOEsIgualAlValor);
        return parejaMatrices;
    }

    public static boolean esNumero(String str) {
        return str.matches("-?\\d+(\\.\\d+)?");
    }

    public static float impurezaGiniDeUnaMatriz(String[][] m, int columnaActual){
        int estudiantesWin = 0;
        int estudiantesFail = 0;
        int niIdea = 0;
        for(String[] fila: m){
            if (fila[77].equals("1")){
                estudiantesWin++;
            }
            else if(!fila[columnaActual].isEmpty()){
                estudiantesFail++;
            }
            else
                niIdea++;
        }

        System.out.println("Estos tuvieron exito de la prueba: " + estudiantesWin+" y estos no tuvieron exito de la prueba: " + estudiantesFail);
        
        
        float proporcionEstudiantesWin = (float)estudiantesWin/(estudiantesWin + estudiantesFail);      
        float proporcionEstudiantesFail = (float)estudiantesFail/(estudiantesWin + estudiantesFail);

        float impurezaGini= 1-((float)Math.pow(proporcionEstudiantesWin, 2)+(float)Math.pow(proporcionEstudiantesFail, 2));
        return impurezaGini;
    }    

    public static float giniPonderado(String[][] matrizIzquierda, String[][] matrizDerecha, int columnaActual){
        float elGiniDeLaIzquierda = impurezaGiniDeUnaMatriz(matrizIzquierda, columnaActual);
        float elGiniDeLaDerecha = impurezaGiniDeUnaMatriz(matrizDerecha, columnaActual);
        float tamañoIzquierda = matrizIzquierda.length;
        float tamañoDerecha = 0;
        for(String[] fila: matrizDerecha){
            if(!fila[columnaActual].isEmpty()){
                tamañoDerecha++;
            }
        }
        //Ip = (ni*Ii + nd*Id) / (ni + nd)
        float giniPonderado = ((tamañoIzquierda * elGiniDeLaIzquierda) + (tamañoDerecha * elGiniDeLaDerecha)) /
            (tamañoIzquierda + tamañoDerecha);
        return giniPonderado;
    }

}
