
/**
 * Write a description of class mainn here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class mainn
{
   public static void main(String args[]){
    BinaryTree holaa = new BinaryTree();
    
    System.out.print("digraph G {");
    holaa.insertar(new Persona(202720579,"juan"));
    holaa.insertar(new Persona(301851212,"Jacobo"));
    holaa.insertar(new Persona(301851227,"Daniel"));
    holaa.insertar(new Persona(202720590,"Dani"));
    holaa.insertar(new Persona(202401619,"Sant"));
    holaa.insertar(new Persona(301851267,"son"));
    holaa.insertar(new Persona(103305023,"Dan"));
    holaa.insertar(new Persona(202520799,"San"));
    holaa.recursivePrint();
    System.out.println("}");
    System.out.print(holaa.buscar(new Persona(202720579,"juan")));
    
   
    

    }
}
