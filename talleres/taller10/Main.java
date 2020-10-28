
/**
 * La clase Main se encarga de ejecutar las pruebas del programa.
 * 
 * @author Sebastian Guerra, Jacobo Rave
 * @version 1
 */
public class Main
{
   public static void main(String args[]){
    BinaryTree bt = new BinaryTree();
    
    System.out.print("digraph G {");
    bt.insertar(new Persona(202720579,"juan"));
    bt.insertar(new Persona(301851212,"Jacobo"));
    bt.insertar(new Persona(301851227,"Daniel"));
    bt.insertar(new Persona(202720590,"Dani"));
    bt.insertar(new Persona(202401619,"Sant"));
    bt.insertar(new Persona(301851267,"son"));
    bt.insertar(new Persona(103305023,"Dan"));
    bt.insertar(new Persona(202520799,"San"));
    bt.recursivePrint();
    System.out.println("}");
    System.out.print(bt.buscar(new Persona(202720579,"juan")));
    System.out.print(bt.buscar(new Persona(301851227,"Daniel")));
    System.out.print(bt.buscar(new Persona(2,"juan")));

    }
}
