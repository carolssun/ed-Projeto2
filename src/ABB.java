//código da prof solange, disponibilizado no moodle

public class ABB {

    private Node root; // raiz da árvore   

    ABB() {
        // Cria uma árvore binária vazia  
        root = null;
    }

    public boolean isEmpty() {
        // Verifica se a árvore está vazia    
        return root == null;
    }

    public Node root() {
        // Devolve a raiz da árvore.   
        return root;
    }

    public boolean isLeaf(Node n) {
        // Verifica se é uma folha
        return n.left == null && n.right == null;
    }

    public void executaPreOrdem(Node no) {
        if (no == null) {
            return;
        }
        //recursivo
        no.mostraNo();
        executaPreOrdem(no.left);
        executaPreOrdem(no.right);
    }

    public void executaInOrdem(Node no) {
        if (no == null) {
            return;
        }
        //recursivo
        executaInOrdem(no.left);
        no.mostraNo();
        executaInOrdem(no.right);
    }

    public void executaPosOrdem(Node no) {
        if (no == null) {
            return;
        }
        
        executaPosOrdem(no.left);
        executaPosOrdem(no.right);
        no.mostraNo();
    }

    public void insere(Palavra novaPalavra) { // se a arvore estiver vazia, cria um nó e define como a raiz
        if (root == null) {
            root = new Node(novaPalavra);
            return;
        }

        Node pai = null; // pai do novo nó
        Node percorre = root; // começa pela raiz 
        boolean palavraExistente = false; //controla se a palavra já existe

        while (percorre != null) { 
            pai = percorre; // atualiza o nó pai para o nó atual
            //compara a nova palavra com a do nó atual, ignorar maíuscual ou miniscula
            int comparacao = novaPalavra.getPalavra().compareToIgnoreCase(percorre.getNoPalavra().getPalavra());
            
            if (comparacao < 0) { // ordem alfabética, 
                percorre = percorre.left;
            } 
            else if (comparacao == 0) { // se palavra já existe, incrementa cont de ocorrencias
                percorre.getNoPalavra().somarOcorrencias();
                palavraExistente = true; // marcar palavra como existente
                break; 
            } 
            else { // ordem alfabética
                percorre = percorre.right;
            }
        }

        // Só insere se a palavra não existir
        if (!palavraExistente) {
            Node novoNo = new Node(novaPalavra);
            novoNo.setParent(pai); // definir pai do novo nó
            
            // decidir posicionamento
            int comparacaoFinal = novaPalavra.getPalavra().compareToIgnoreCase(
                                pai.getNoPalavra().getPalavra());
            //ordem alfabetica
            if (comparacaoFinal < 0) {
                pai.setLeft(novoNo);
            } else {
                pai.setRight(novoNo);
            }
        }
    }
        
    /*public void delete*/


    public int busca(String palavraBuscada){
        return busca(root, palavraBuscada.toLowerCase());
    }

    public int busca(Node no, String palavraBuscada){
        if(no==null){
            return -1;
        }
        int comparacao = palavraBuscada.compareToIgnoreCase(no.getNoPalavra().getPalavra());
        if (comparacao <0){
            return busca(no.getLeft(),palavraBuscada);
        } else if( comparacao >0) {
            return busca(no.getRight(), palavraBuscada);
        } else{
            return no.getNoPalavra().getOcorrencias(); // retorna o número de ocorrencias 
        }

    }

    public Node maximo(Node x) {
        //Node<E> x = root();
        while (x.right != null) {
            x = x.right;
        }
        return x;
    }

    public Node minimo(Node n) {
        Node x = n;
        while (x.left != null) {
            x = x.left;
        }
        return x;
    }


    public int contaTotalPalavras() {
        return contaTotalPalavras(root);
    }

    private int contaTotalPalavras(Node no) {
        if (no == null) {
            return 0;
        }
        // Soma as ocorrências do nó atual + recursão para esquerda e direita
        return no.getNoPalavra().getOcorrencias() 
            + contaTotalPalavras(no.getLeft()) 
            + contaTotalPalavras(no.getRight());
    }


    // Método para encontrar a palavra mais frequente
      public Palavra getPalavraMaisFrequente() {
        return getPalavraMaisFrequente(root, null);
    }

    private Palavra getPalavraMaisFrequente(Node no, Palavra atualMaisFrequente) {
        //para identificar o tema principal do discurso
        if (no == null) return atualMaisFrequente;

        Palavra atual = no.getNoPalavra();
        if (atualMaisFrequente == null || atual.getOcorrencias() > atualMaisFrequente.getOcorrencias()) {
            atualMaisFrequente = atual;
        }

        atualMaisFrequente = getPalavraMaisFrequente(no.left, atualMaisFrequente);
        return getPalavraMaisFrequente(no.right, atualMaisFrequente);
    }

    
    // Método para encontrar a palavra menos frequente
    // public String getPalavraMenosFrequente() {
    //     if (root == null) return null;
        
    //     Node atual = root;
    //     while (atual.left != null) { // Vai até o nó mais à esquerda
    //         atual = atual.left;
    //     }
    //     return atual.getNoPalavra().getPalavra() + " (" + atual.getNoPalavra().getOcorrencias() + "x)";
    // }

    public int getQuantidadePalavrasRepetidas() {
        //mede a riqueza do vocabulario do discurso
        return contarRepetidas(root);
    }

    private int contarRepetidas(Node no) {
        if (no == null) return 0;
        
        int count = (no.getNoPalavra().getOcorrencias() > 1) ? 1 : 0;
        return count + contarRepetidas(no.getLeft()) + contarRepetidas(no.getRight());
    }
}

