// // LeitorArquivo.java
// import java.io.BufferedReader;
// import java.io.FileNotFoundException;
// import java.io.FileReader;
// import java.io.IOException;

// public class LeitorArquivo {
//     public void carregarDiscurso(String nomeArquivo, ABB abb) {
//     System.out.println("Carregando discurso...");
//     FileReader arq = null;
//     BufferedReader br = null;

//     try {
//         arq = new FileReader(nomeArquivo); // <- Use o parâmetro aqui!
//         br = new BufferedReader(arq);

//         String linha;

//         while ((linha = br.readLine())!= null) {
//             //System.out.println("Linha lida: " + linha); // para teste
            
//             linha = linha.trim().toLowerCase();
//             if(linha.isEmpty()) continue;

//             // Remove pontuações e divide em palavras
//             String[] palavras = linha.replaceAll("[^a-záéíóúãõâêôç\\s]", "")
//                 .split("\\s+");

//              for (String palavra : palavras) {
//                 if (!palavra.isEmpty()) {
//                     Palavra novaPalavra = new Palavra(palavra);
//                     abb.insere(novaPalavra); // Insere ou atualiza a ABB
//                     System.out.println("Inserindo palavra: " + palavra); // debug
//                 }
//              }
//         }

//         System.out.println("Discurso carregado com sucesso!");

//     } catch (FileNotFoundException e) {
//         System.out.println("Erro: O arquivo '" + nomeArquivo + "' não foi encontrado. " + e.getMessage());
//     } catch (IOException e) {
//         System.out.println("Erro de leitura do arquivo: " + e.getMessage());
//     } finally {
//         try {
//             if (br != null) br.close();
//             if (arq != null) arq.close();
//         } catch (IOException e) {
//             System.out.println("Erro ao fechar o arquivo: " + e.getMessage());
//         }
//       }
//     }
// }
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class LeitorArquivo {
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