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

    /* 
    codigo da prof, devemos adaptar para PALAVRA
    public void insere(Node z) {
        Node y = null;
        Node x = root();
        while (x != null) {
            y = x;
            if (z.elemento < x.elemento) {
                x = x.left;
            } else {
                x = x.right;
            }
        }
        z.parent = y;
        if (y == null) {
            root = z;
        } else if (z.elemento < y.elemento) {
            y.left = z;
        } else {
            y.right = z;
        }
    } */

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
        

    /*public void delete(Node Tree, int Tar) {
        Node Min, Temp;
        if (Tree == null) { // árvore vazia
            return;
        } else if (Tar < Tree.elemento) {
            delete(Tree.left, Tar); // buscar na esquerda
        } else if (Tar > Tree.elemento) {
            delete(Tree.right, Tar);// buscar na direita
        } else {
            // encontrou o nó a ser deletado
            if (Tree.left != null && Tree.right != null) {
                // nó com dois filhos 
                Min = minimo(Tree.right);
                Tree.elemento = Min.elemento;
                delete(Tree.right, Tree.elemento);
            } else {
                // nó com um ou nenhum filho
                if (Tree.left == null) {
                    if (Tree.parent == null) {
                        root = Tree.right; // A raiz deverá ser deletada
                    } else {
                        if (Tree.right != null) {
                            Tree.right.parent = Tree.parent;
                        }
                        if (Tree == Tree.parent.left) {
                            Tree.parent.left = Tree.right;
                        } else {
                            Tree.parent.right = Tree.right;
                        }
                    }

                } else if (Tree.right == null) {
                    if (Tree.parent == null) {
                        root = Tree.left; // A raiz deverá ser deletada
                    } else {

                        Tree.left.parent = Tree.parent;
                        if (Tree == Tree.parent.left) {
                            Tree.parent.left = Tree.left;
                        } else {
                            Tree.parent.right = Tree.left;
                        }
                    }
                }
            }
        }
    } */

    // public Node busca(Node k) {
    //     Node y = root();
    //     while (y != null) {
    //         if (y.elemento == k.elemento) {
    //             return y;
    //         } else if (y.elemento < k.elemento) {
    //             y = y.right;
    //         } else {
    //             y = y.left;
    //         }
    //     }
    //     return null;
    // }

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

    public int contaNos() {
        return contaNos(root);
    }

    private int contaNos(Node no) {
        if (no == null) return 0;
        return 1 + contaNos(no.getLeft()) + contaNos(no.getRight());
    }

    // NOVO: calcula a altura da árvore
    public int altura() {
        return altura(root);
    }

    private int altura(Node no) {
        if (no == null) return -1; // -1 para árvore vazia, 0 para folha
        return 1 + Math.max(altura(no.left), altura(no.right));
    }

    // NOVO: retorna a palavra com mais ocorrências
    public Palavra getMaisFrequente() {
        return getMaisFrequente(root, null);
    }

    private Palavra getMaisFrequente(Node no, Palavra atualMaisFrequente) {
        if (no == null) return atualMaisFrequente;

        Palavra atual = no.getNoPalavra();
        if (atualMaisFrequente == null || atual.getOcorrencias() > atualMaisFrequente.getOcorrencias()) {
            atualMaisFrequente = atual;
        }

        atualMaisFrequente = getMaisFrequente(no.left, atualMaisFrequente);
        return getMaisFrequente(no.right, atualMaisFrequente);
    }

    // NOVO: retorna a palavra com menos ocorrências (> 0)
    public Palavra getMenosFrequente() {
        return getMenosFrequente(root, null);
    }

    private Palavra getMenosFrequente(Node no, Palavra atualMenosFrequente) {
        if (no == null) return atualMenosFrequente;

        Palavra atual = no.getNoPalavra();
        if (atualMenosFrequente == null || atual.getOcorrencias() < atualMenosFrequente.getOcorrencias()) {
            atualMenosFrequente = atual;
        }

        atualMenosFrequente = getMenosFrequente(no.left, atualMenosFrequente);
        return getMenosFrequente(no.right, atualMenosFrequente);
    }

}

