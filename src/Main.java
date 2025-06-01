import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
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
                    leitor.carregarDiscurso("/Users/talala/ed-Projeto2/Discurso.txt", abb); // Carrega o discurso na árvore
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
                    System.out.println("\n----- Verificar sinais de depressão -----\n");
                    if (abb.isEmpty()) {
                        System.out.println("Árvore vazia. Carregue o discurso primeiro.");
                        break;
                    }

                    int totalPalavrasDepressivas = 0;
                    int palavrasEncontradas = 0;

                    try (BufferedReader br = new BufferedReader(
                            new FileReader("/Users/talala/ed-Projeto2/PalavrasDepressao.txt"))) {
                        
                        String palavra;
                        while ((palavra = br.readLine()) != null) {
                            palavra = palavra.trim().toLowerCase();

                            if (!palavra.isEmpty()) {
                                int ocorrencia = abb.busca(palavra);
                                if (ocorrencia > 0) {
                                    System.out.printf("- Palavra encontrada: \"%s\" (%d ocorrência(s))%n", palavra, ocorrencia);
                                    totalPalavrasDepressivas += ocorrencia;
                                    palavrasEncontradas++;
                                }
                            }
                        }

                        System.out.printf("%nTotal de diferentes palavras associadas à depressão encontradas: %d%n", palavrasEncontradas);
                        System.out.printf("Total de ocorrências somadas: %d%n", totalPalavrasDepressivas);

                    } catch (IOException e) {
                        System.out.println("Erro ao ler o arquivo de palavras depressivas: " + e.getMessage());
                    }
                    break;
                case 6:
                    System.out.println("\n----- Estatísticas sobre o texto -----\n");

                    if (abb.isEmpty()) {
                        System.out.println("Árvore vazia. Carregue o discurso primeiro.");
                        break;
                    }

                    System.out.println("Total de palavras (com repetições): " + abb.contaTotalPalavras());
                    System.out.println("Total de palavras distintas: " + abb.contaNos());
                    System.out.println("Altura da árvore: " + abb.altura());

                    Palavra maisFrequente = abb.getMaisFrequente();
                    Palavra menosFrequente = abb.getMenosFrequente();

                    if (maisFrequente != null) {
                        System.out.printf("Palavra mais frequente: \"%s\" (%d ocorrência(s))%n",
                                maisFrequente.getPalavra(), maisFrequente.getOcorrencias());
                    }

                    if (menosFrequente != null) {
                        System.out.printf("Palavra menos frequente: \"%s\" (%d ocorrência(s))%n",
                                menosFrequente.getPalavra(), menosFrequente.getOcorrencias());
                    }
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
