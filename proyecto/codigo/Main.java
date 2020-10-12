import javafx.util.Pair;
import java.util.*;
import java.io.*;
/**
* @author Sebastian Guerra, Jacobo Rave
* @version 2
*/
public class Main
{
    public static void main(String[] args) throws Exception{
        ArrayList<String[]> m = Lector.leerCSV(); //m*n + n^2 + m + n
        ArrayList<Pair<Pair<String[][],String[][]>, String>> mejoresParejasDeColumna = new ArrayList();
        String[][] matriz = new String[m.size()][m.get(0).length];

        for (int i = 0; i < matriz.length; i++) {  
            matriz[i] = m.get(i);
        }

        int iteradorColumna = 8; //Acá va la columna sobre la que deseas saber la mejor condicion y su ponderado.
        float impurezaPonderada = 0;

        ArrayList<Object> respuestas = posiblesValores(matriz, iteradorColumna);
        Pair<String[][],String[][]> pareja = null;
        Pair<Pair<String[][],String[][]>, String> parejaYSuCondicion = null;
        if(respuestas.get(0).getClass().getName().equals("java.lang.Float")){ 
            float mediaAritmetica = ((Float)respuestas.get(0)).floatValue();
            System.out.println("Condicion elegida: Promedio--> "+mediaAritmetica);
            pareja = dividirUnaMatrizEnDosMatrices(matriz, iteradorColumna, mediaAritmetica); //O(n)
            parejaYSuCondicion = new Pair(pareja, String.valueOf(mediaAritmetica));
        }
        else if(respuestas.get(0).getClass().getName().equals("java.lang.String")){
            parejaYSuCondicion = determinarMejorPareja(respuestas, matriz, iteradorColumna); //O(n^2)}
        }

        mejoresParejasDeColumna.add(parejaYSuCondicion);

        for (Pair<Pair<String[][],String[][]>, String> p: mejoresParejasDeColumna) {  //O(m)
            System.out.println("La impureza ponderada es: " + giniPonderado(p.getKey().getKey(), p.getKey().getValue(), iteradorColumna)+" con la condicion: "+ p.getValue());
        }

    }

    public static Pair<Pair<String[][],String[][]>, String> determinarMejorPareja(ArrayList<Object> respuestas, String[][] matriz, int iteradorColumna){
        float minImpureza = 1;
        Pair<String[][],String[][]> mejorPareja = null;
        String mejorCondicion = null;
        
        for(Object s: respuestas){
            String condicionEnCadena = (String)s;
            System.out.println("Condicion elegida: "+condicionEnCadena);
            Pair<String[][],String[][]> pareja = dividirUnaMatrizEnDosMatrices(matriz, iteradorColumna, condicionEnCadena);
            float impurezaActual = (float)giniPonderado(pareja.getKey(), pareja.getValue(), iteradorColumna);
            if(impurezaActual < minImpureza){
                minImpureza = impurezaActual;
                mejorPareja = pareja;
                mejorCondicion = condicionEnCadena;
            }
        } 
        
        return new Pair(mejorPareja, mejorCondicion);
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
            respuestasDeVariable.add(calcularMediaDeAtributo(m, posVariable)); //O(n)
        }
        return respuestasDeVariable;
    }

    public static float calcularMediaDeAtributo(String[][] m, int posVariable){
        float sumaDeAtributo = 0;
        float total = 0;
        for (String[] fila: m){
            if(!fila[posVariable].isEmpty()){
                sumaDeAtributo += (float)Float.parseFloat(fila[posVariable]);  
                total++;
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
        int estudiantesWin = 0; //0.44 
        int estudiantesFail = 0;
        int niIdea = 0;
        for(String[] fila: m){
            if (fila[77].equals("1")){
                estudiantesWin++;
            }//fila.length-1
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
