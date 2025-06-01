import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int op = 0; 

        ABB abb = new ABB(); // Cria uma nova árvore binária de busca
        LeitorArquivo leitor = new LeitorArquivo(); // Cria um novo leitor de arquivo

        do{
            System.out.println("\n============ Menu ============");
            System.out.println("1. Carregar discurso");
            System.out.println("2. Contador de palavras ");
            System.out.println("3. Buscar palavra");
            System.out.println("4. Exibir as palavras do discurso em ordem alfabética ");
            System.out.println("5. Verificar sinais de depressão");
            System.out.println("6. Estatísticas sobre o texto");
            System.out.println("7. Sair ");

            System.out.print("Entre com a opção: ");
            op = sc.nextInt(); // Lê a opção do usuário
            sc.nextLine(); //consome a quebra de linha pendente
            switch(op){
                case 1:
                    //System.out.println("Carregar discurso");
                    leitor.carregarDiscurso("C:\\Users\\carol\\OneDrive - Instituto Presbiteriano Mackenzie\\Semestre_03\\Estrutura_Dados\\ed-Projeto2-1\\Discurso.txt", abb); // Carrega o discurso na árvore
                    break;
                case 2:
                    // Implementar a lógica para contar palavras
                    System.out.println("Total de palavras no discurso: " + abb.contaTotalPalavras());
                    break;
                case 3:
                    // Implementar a lógica para buscar uma palavra
                    System.out.println("\nDigite a palavra a ser buscada: ");
                    String palavraBuscada = sc.nextLine().trim().toLowerCase();
                    
                    if (palavraBuscada.isEmpty()) {
                        System.out.println("Nenhuma palavra foi digitada!");
                        break;
                    }
                    int ocorrencias = abb.busca(palavraBuscada);

                    if (ocorrencias == -1){
                        System.out.println("Palavra não encontrada");
                    } else {
                        System.out.println("\nA Palavra " + palavraBuscada + "aparece " + ocorrencias + " vezes no discurso\n");
                    }

                    break;
                case 4:
                    // Implementar a lógica para exibir palavras em ordem alfabética
                    if(abb.isEmpty()){
                        System.out.println("\nÁrvore vazia. Carregue o discurso primeiro\n");
                    } else {
                        System.out.println("Palavras acentuadas estarão localizadas no final");
                        System.out.println("\n----- Palavras em ordem alfabética -----\n");
                        System.out.println("Palavra             |       Ocorrências      ");
                        System.out.println("---------------------------------------------");
                        abb.executaInOrdem(abb.root());
                        System.out.println(" ");
                    }   
        
                    break;
                case 5: 
                    System.out.println("Verificar sinais de depressão");
                    // Implementar a lógica para verificar sinais de depressão
                    break;
                case 6:
                    System.out.println("Estatísticas sobre o texto");
                    // Implementar a lógica para estatísticas sobre o texto
                    break;
                case 7:
                    System.out.println("Sair");
                    // Link para o video do grupo
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }  
        }while (op != 7);
    sc.close();  
    } 
} 
