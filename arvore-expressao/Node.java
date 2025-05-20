
public class Node {

    Palavra palavra;  // elemento armazenado no nó
    Node left, right, parent; // apontadores do nó

    Node(Palavra palavra) {
        this.palavra = palavra;
        left = right = parent = null;
    }

    public void mostraNo(){
        System.out.print(palavra + " ");
    }   
}
