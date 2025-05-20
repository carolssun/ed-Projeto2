public class Palavra {
    //atrivutos
    private String palavra;
    private int ocorrencias;

    //construtor
    public Palavra(String palavra){
        this.palavra = palavra;
        this.ocorrencias = 1; // se a palavra foi criada, começa com 1

    }

    //métodos
    public String getPalavra() {
        return palavra;
    }
    public int getOcorrencias() {
        return ocorrencias;
    }
    //para somar ocorrencias (pedido no primeiro item)
    public void somarOcorrencias() {
        this.ocorrencias++;
    }

    public String toString() {
        return "Palavra: " + palavra + ", Ocorrências: " + ocorrencias;
    }

    
}

