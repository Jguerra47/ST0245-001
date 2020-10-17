public class BinaryTree {

    private Node root;

    // Constructor sin parametros iniciar sin nodo
    public BinaryTree() {
        this.root = null;
    }
    //Contructor iniciando con nodo
    public BinaryTree(Persona n) {
        this.root = new Node(n);
    }

    //Llama al metodo auxiliar insertar
    public void insertar(Persona n) {
        if(root == null){
            root = new Node(n);}
        else{
            insertarAux(root, n);}
    }
    // Agrega un nodo al arbol
    private void insertarAux(Node node, Persona n) {
        if (node == null){
            node = new Node(n);
        }
        if (n.num > node.data.num) {
            if (node.right == null) {
                node.right = new Node(n);
            }else {
                insertarAux(node.right, n);
            }
        }
        if(n.num < node.data.num) {
            if (node.left == null) {
                node.left = new Node(n);
            }else {
                insertarAux(node.left, n);
            }
        }
    }

    // Llama al metodo auxiliar buscar
    public boolean buscar(Persona n) {
        return buscarAux(root, n);
    }

    //Busca en el arbol si existe un valor, devuelve true o false, dependiendo de si este o no
    private boolean buscarAux(Node node, Persona n) {
        if (node.data == n) {
            return true;
        }
        if (node == null) {
            return false;
        }
        if (n.num > node.data.num) {
            return buscarAux(node.right, n);
        }
        else {
            return buscarAux(node.left, n);
        }

    }

    //Llama al metodo auxiliar borrar
    public void borrar(Persona n) {
        borrarAux(root, n);
    }

    //Borra un nodo el arbol
    private Node borrarAux(Node node, Persona n) {
        if (node == null) {
            return null;
        }
        if (node.data.num == n.num) {
            if (node.right == null && node.left == null) {
                return null;
            }
            if (node.right == null) {
                return node.left;
            }
            if (node.left == null) {
                return node.right;
            }else {
                node.data.num = encontrarNodoReemplazo(node.left);
            }
        }
        if (n.num > node.data.num) {
            node.right = borrarAux(node.right, n);
            return node;
        }
        node.left = borrarAux(node.left, n);
        return node;
    }

    private int encontrarNodoReemplazo(Node t) {
        if (t.right == null) {
            int res = t.data.num;
            t = null;
            return res;
        }
        return encontrarNodoReemplazo(t.right);
    }

    private void recursivePrintIN(Node node)
    {   
        if (node != null)
        {   
            recursivePrintIN(node.left);

            System.out.println(node.data.ToSring());

            recursivePrintIN(node.right);
        }
        
    }

    private void recursivePrintPRE(Node node)
    {
        if (node != null)
        {
            System.out.println(node.data.ToSring());
            recursivePrintPRE(node.left);
            recursivePrintPRE(node.right);
        }

    }

    private void recursivePrintPOST(Node node)
    {
        if (node != null)
        {
            recursivePrintPOST(node.left);
            recursivePrintPOST(node.right);
            System.out.println(node.data.ToSring());

        }

    }

    /**
     * Metodo auxiliar de recursivePrintAUX
     *
     */
    public void recursivePrint()
    {

        recursivePrintIN(root);
        System.out.println();
        recursivePrintPRE(root);
        System.out.println();
        recursivePrintPOST(root);
         
    }
}
