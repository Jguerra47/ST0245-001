
/**
 * Write a description of class Persona here.
 * 
 * @author Jacobo Rave, Sebastian Guerra
 * @version 1
 */
public class Persona
{
    int num;
    String nom;
    public Persona(int num, String nom){
        this.num=num;
        this.nom=nom;
    }  

    public String ToSring(){

        return "\"Persona: " + this.nom + " \\n" + " Numero: " + this.num + "\"" ;
    }
}
