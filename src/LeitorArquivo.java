// LeitorArquivo.java
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class LeitorArquivo {
    public void carregarDiscurso(String nomeArquivo, ABB abb) {
    System.out.println("Carregando discurso...");
    FileReader arq = null;
    BufferedReader br = null;

    try {
        arq = new FileReader(nomeArquivo); // <- Use o parâmetro aqui!
        br = new BufferedReader(arq);

        String linha = br.readLine();
        while (linha != null) {
            //System.out.println("Linha lida: " + linha); // para teste
            
            linha = br.readLine();
        }

        System.out.println("Discurso carregado com sucesso!");

    } catch (FileNotFoundException e) {
        System.out.println("Erro: O arquivo '" + nomeArquivo + "' não foi encontrado. " + e.getMessage());
    } catch (IOException e) {
        System.out.println("Erro de leitura do arquivo: " + e.getMessage());
    } finally {
        try {
            if (br != null) br.close();
            if (arq != null) arq.close();
        } catch (IOException e) {
            System.out.println("Erro ao fechar o arquivo: " + e.getMessage());
        }
      }
    }
}