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

    public void insere(Palavra novaPalavra) {

        if (root == null) {
             root = new Node(novaPalavra); // Cria um novo Node com a Palavra e define como raiz
             return; // Termina a função
        }

        Node pai = null;
        Node percorre = root();
         
        while (percorre != null) {
            pai = percorre;
            int comparacaoPalavra = novaPalavra.getPalavra().compareToIgnoreCase(percorre.getNoPalavra().getPalavra());
            if (comparacaoPalavra < 0) {
                percorre = percorre.left;
            } else if (comparacaoPalavra == 0) {
                //a palavra pode ja existir na arvore
                percorre.getNoPalavra().somarOcorrencias();
            }else{
                percorre = percorre.right;
            }
            
        }
        //nesse ponto do codigo, 'percorre' é nulo e pai
        //é o nó onde novaPalavra deve ser ligada
        Node novoNo = new Node(novaPalavra);
        novoNo.setParent(pai); // Define o nó pai do novo nó
        //ligando o novo nó com os filhos
        int comparacaoFinal = novaPalavra.getPalavra().compareToIgnoreCase(pai.getNoPalavra().getPalavra());

        if(comparacaoFinal < 0){
            pai.setLeft(novoNo); // Define o nó esquerdo do pai como o novo nó
        }else{
            pai.setRight(novoNo); // Define o nó direito do pai como o novo nó
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

    /*public Node busca(Node k) {
        Node y = root();
        while (y != null) {
            if (y.elemento == k.elemento) {
                return y;
            } else if (y.elemento < k.elemento) {
                y = y.right;
            } else {
                y = y.left;
            }
        }
        return null;
    }*/

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

}

