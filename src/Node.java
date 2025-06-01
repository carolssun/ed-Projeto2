
public class Node {

    public Palavra noPalavra;  // elemento armazenado no nó
    public Node left, right, parent; // apontadores do nó

    public Node(Palavra noPalavra) {
        this.noPalavra = noPalavra;
        left = right = parent = null;
    }

    public void mostraNo(){
        System.out.printf("%-15s     |     %d ocorrências\n", 
                     noPalavra.getPalavra(), 
                     noPalavra.getOcorrencias());
    }
    
    public Palavra getNoPalavra() {
        return noPalavra;
    }

      public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }


}
