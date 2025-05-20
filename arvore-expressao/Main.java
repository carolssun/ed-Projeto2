import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("---Menu---");
        System.out.println("1. Carregar discurso");
        System.out.println("2. Contador de palavras ");
        System.out.println("3. Buscar palavra");
        System.out.println("4. Exibir as palavras do discurso em ordem alfabética ");
        System.out.println("5. Verificar sinais de depressão");
        System.out.println("6. Estatísticas sobre o texto");
        System.out.println("7. Sair ");

        Scanner sc = new Scanner(System.in);

        int op = sc.nextInt();

        switch(op){
            case 1:
                System.out.println("Carregar discurso");
                // Implementar a lógica para carregar o discurso
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
        }
    sc.close();    
    }
    
}
