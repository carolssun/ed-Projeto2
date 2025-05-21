import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int op = 0; 

        ABB abb = new ABB(); // Cria uma nova árvore binária de busca
        LeitorArquivo leitor = new LeitorArquivo(); // Cria um novo leitor de arquivo

        do{
            System.out.println("---Menu---");
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
                    leitor.carregarDiscurso("Discurso.txt", abb); // Carrega o discurso na árvore
                    break;
                case 2:
                    System.out.println("Contador de palavras");
                    // Implementar a lógica para contar palavras
                    break;
                case 3:
                    System.out.println("Buscar palavra");
                    // Implementar a lógica para buscar uma palavra
                    break;
                case 4:
                    System.out.println("Exibir as palavras do discurso em ordem alfabética");
                    // Implementar a lógica para exibir palavras em ordem alfabética
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
