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
}