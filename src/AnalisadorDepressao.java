import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class AnalisadorDepressao {
    private final ABB arvore;
    private final List<String> palavrasChave;

    public AnalisadorDepressao(ABB arvore, String caminhoArquivo) throws IOException {
        this.arvore = arvore;
        this.palavrasChave = carregarPalavras(caminhoArquivo);
    }

    private List<String> carregarPalavras(String caminho) throws IOException {
        List<String> palavras = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(caminho))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                palavras.add(linha.trim().toLowerCase());
            }
        }
        return palavras;
    }

    public void analisar() {
        Map<String, Integer> resultados = new TreeMap<>(); // Ordena alfabeticamente
        
        for (String palavra : palavrasChave) {
            int count = arvore.busca(palavra); // Variável local única
            if (count > 0) {
                resultados.put(palavra, count);
            }
        }

        exibirRelatorio(resultados);
    }

    private void exibirRelatorio(Map<String, Integer> resultados) {
        System.out.println("\n=== RELATÓRIO DE SINAIS ===");
        System.out.println("Palavra              |       Ocorrências      ");
        System.out.println("---------------------------------------------");

        resultados.forEach((palavra, cont) -> 
            System.out.printf(" %-15s     |   %d ocorrência%s\n", 
                            palavra, cont, cont != 1 ? "s" : ""));
        
        double percentual = (double) resultados.size() / palavrasChave.size() * 100;
        System.out.println("\nPalavras relacionadas à depressão analisadas: " + palavrasChave.size());
        System.out.println("Sinais detectados no discurso: " + resultados.size());
        System.out.printf("\nTaxa de detecção: %.1f%%\n", percentual);
    }
}