package Taller3;
/**
*
* La clase Taller3 tiene como objtivo dar solución a los puntos del taller 3
*
* @author Mauricio Toro, Andrés Páez
* @version 1
*/


public class Taller3_ {

	/**
	*
	* El método torresDeHannoi es un auxiliar del proceso 
	* @param n numero de discos
	* 
	*/	
	
	public static void torresDeHannoi(int n) {
		int cuenta = hanoi(n, 'a', 'b', 'c', 0 );
		System.out.println("El total de pasos es: " + cuenta);
		
	}

	/**
	*
	* El método torresDeHannoi es un auxiliar del proceso 
	* @param n numero de discos
	* @param origen la torre número uno donde se posicionan todos los discos inicialmente
	* @param destino la torre donde deben posicionarse todos los discos terminado el proceso
	* @param intermedio torre auxiliar para que el cambio de torres se haga efectivo
	* 
	* debe devolver la secuencia de pasos en consola de esta manera:
	* System.out.println("Disk "+ n + " from "+ origen + " to "+ destino);
	*
	* @see <a href="http://www.uterra.com/juegos/torre_hanoi.php"> Simulación del funcionamiento</a>
	* @see <a href="https://es.wikipedia.org/wiki/Torres_de_Han%C3%B3i"> Un poco de historia </a>
	*/	
	
	//private static void torresDeHannoiAux(int n, int origen, int intermedio, int destino) {}
	
	
		 
	public static int hanoi(int topN, char a  , char b , char c , int cont ){

	     if (topN == 1){
	    	 
	         System.out.println(a + "->" + c );
	       return cont+1;
		   	     }
	     else{ 
	    	cont = hanoi(topN-1, a, c, b, cont);
	        cont = hanoi(1, a , b, c, cont  );
	        cont = hanoi(topN-1, b, a, c, cont);
	         return cont;
			     }
	     
			  }
		 
	/**
	*
	* El método permutation es un auxiliar del proceso 
	* @param str es la cadena a permutar
	*/
	
	
	public static void permutation(String str) {
		permutationAux("", str,3); 
	}
	
	/**
	*
	* El método permutationAux es el core del proceso, en el se busca conseguir
	* las posibles permutaciones que puede tener la cadena str 
	* @param str es la cadena a permutar
	* @param prefix cadena auxiliar donde se guarda la cadena de salida
	*
	* Las cadenas de salida tienes una longitud de lenght de la cadena s
	* Ej: para la cadena AB se tiene la salida: { ABC,ACB,BAC,BCA,CAB,CBA }
	* donde los caracteres no se repiten pero el orden tiene un papel importante.
	*
	*/
	
	
	private static void permutationAux(String respuesta, String pregunta, int cont) {
		cont = pregunta.length();
		if (cont == 0){
			System.out.println(respuesta);
	        //System.out.println(AdvancedEncryptionStandard.desencriptarArchivo(respuesta));
	    }
	    else
	    for (int i = 0; i < cont; i++) {
	    	permutationAux(respuesta+pregunta.charAt(i),pregunta.substring(0,i)+pregunta.substring(i+1,cont),cont);}
	                        
		                 //método del profesor

	                     //las que empiezan por a, las que empiezan las que b, las que empiezan por c

	                     //permutationAux(""+"a", quitarUnaLetra(pregunta, "a") );

	                    // permutationAux(""+"b", quitarUnaLetra(pregunta, "b"));

	                    // permutationAux(""+"c", quitarUnaLetra(pregunta, "c"));

	                    // permutationAux(""+"d", quitarUnaLetra(pregunta, "d"));

		                

	    }
	
	/**
     * @param s se trata de una cadena de caracteres sobre la cual hallaremos las posibles combinaciones.
     *
     * El método combinations se define para que solo se tenga que pasar el parametro s y no la cadena
     * vacía necesaria para el metodo recursivo combinationsAux. Este metodo no se modifica.
     *
     */
    public static void combinations(String s) {
        combinationsAux("", s);
    }

    /**
     * @param prefix, se utiliza como una variable auxiliar para guardar datos sobre el proceso.
     * @param s se trata de una cadena de caracteres sobre la cual hallaremos las posibles combinaciones.
     *
     *
     * El método combinationsAux se encarga de encontrar las posibles combinaciones en la cadena s
     * notese que el método es "private" de modo que solo se puede llamar desde el interior de la clase pues
     * el método que lo representa es combinations.
     * Para más detalles sobre modificadores de acceso:
     * @see <a href="http://ayudasprogramacionweb.blogspot.com/2013/02/modificadores-acceso-public-protected-private-java.html"> modificadores </a>
     *
     */

    private static void combinationsAux(String p, String s){
        if(s.length()==0){
            System.out.println(p);
        }else {            
            combinationsAux(p + s.charAt(0), s.substring(1));
            combinationsAux(p, s.substring(1));
            //s.substring(1) cumple la función de ir limpiando los caracteres que se trabajan en s, para que cuando s esté vacio se imprima lo trasladado hacia p
        }
    }
		
	
}