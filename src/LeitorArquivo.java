import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class LeitorArquivo {
    // método para o discurso 
    public void carregarDiscurso(String nomeArquivo, ABB abb) {
        System.out.println("Carregando discurso...");
        
        try (BufferedReader br = new BufferedReader(
                new FileReader(nomeArquivo, StandardCharsets.UTF_8))) {
            
            String linha;
            while ((linha = br.readLine()) != null) {
                linha = linha.trim().toLowerCase();
                if (linha.isEmpty()) {
                    continue;
                }

                // Processamento mais robusto de caracteres especiais
                String[] palavras = linha.replaceAll("[^\\p{L}\\p{M}\\s]", "")
                                      .split("\\s+");
                
                for (String palavra : palavras) {
                    palavra = palavra.trim();
                    if (!palavra.isEmpty()) {
                       // System.out.println("Inserindo palavra: " + palavra);  //teste
                        abb.insere(new Palavra(palavra));
                    }
                }
            }
            System.out.println("Discurso carregado com sucesso!");
            
        } catch (IOException e) {
            System.out.println("Erro ao processar arquivo: " + e.getMessage());
            e.printStackTrace(); // Mostra o stack trace completo para diagnóstico
        }
    }

    public void analisarDepressao(String nomeArquivo, ABB abb){
        System.out.println("\n===== RELATÓRIO DE SINAIS =====");
                    System.out.println("Palavra              |       Ocorrências      ");
                    System.out.println("---------------------------------------------");

                    if (abb.isEmpty()) {
                        System.out.println("Árvore vazia. Carregue o discurso primeir(opção 1 do menu)).");
                    }

                    int totalPalavrasDepressivas = 0;
                    int palavrasEncontradas = 0;

                    try (BufferedReader br = new BufferedReader(
                            new FileReader(nomeArquivo))) {
                        
                        String palavra;
                        while ((palavra = br.readLine()) != null) {
                            palavra = palavra.trim().toLowerCase();

                            if (!palavra.isEmpty()) {
                                int ocorrencia = abb.busca(palavra);
                                if (ocorrencia > 0) {
                                    System.out.printf(" %-15s     |    %d ocorrências%n", palavra, ocorrencia);
                                    totalPalavrasDepressivas += ocorrencia;
                                    palavrasEncontradas++;

                                }
                            }
                        }

                        double percentual = (double) palavrasEncontradas/ 43 * 100;
                        System.out.println("\nPalavras relacionadas à depressão analisadas-> 43" );
                        System.out.println("Qtd de sinais de alerta detectados no discurso-> " + palavrasEncontradas);
                        System.out.printf("Qtd de sinais de alerta detectados com repetição-> %d%n", totalPalavrasDepressivas);
                        System.out.printf("Taxa de detecção-> %.1f%%\n", percentual);
                        

                    } catch (IOException e) {
                        System.out.println("Erro ao ler o arquivo de palavras depressivas: " + e.getMessage());
                    }
    }
}