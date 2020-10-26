
import java.util.ArrayList;
public class Point2
{
    public class Node {
        public Node left;
        public Node right;
        public int data;
        public Node (int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public Node raiz;

    public void buildingTree (int[] preOrder) {
        this.raiz = new Node(preOrder[0]);
        for(int i = 1; i < preOrder.length; i++){
            insert(raiz, preOrder[i]);
        }
    }

    public void insert(Node nodo, int data) {
        if((data < nodo.data) && nodo.left == null) {
            nodo.left = new Node(data);
        }else if((data > nodo.data) && nodo.right == null) {
            nodo.right = new Node(data);
        }        
        else if((data < nodo.data) &&nodo.left != null) {
            insert(nodo.left, data);
        }        
        else if ((data > nodo.data) &&nodo.right != null){
            insert(nodo.right,data);
        }        
    }

    public void preOrder(Node nodo) { 
        if(nodo != null) {
            System.out.println(nodo.data);
            preOrder(nodo.left);
            preOrder(nodo.right);
        }
    }
    
    public void posOrder(Node nodo) {
        if(nodo != null) {
            posOrder(nodo.left);
            posOrder(nodo.right);
            System.out.println(nodo.data);
        }        
    }

    public void exercise21 (int[] input) {
        buildingTree(input);
        System.out.println("PosOrder");
        posOrder(raiz);
        System.out.println();
    }

    public static void main (String [] args) {
        int [] test = {50,30,24,5,28,45,98,52,60};
        Point2 testing = new Point2();
        testing.exercise21(test);
    }
}