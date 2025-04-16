package grafos;
import java.util.*;
import grafos.componentes.Graph;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] capitals = {
            "Aracaju", "Belém", "Belo Horizonte", "Boa Vista", "Brasília", 
            "Campo Grande", "Cuiabá", "Curitiba", "Florianópolis", "Fortaleza", 
            "Goiânia", "João Pessoa", "Macapá", "Maceió", "Manaus", 
            "Natal", "Palmas", "Porto Alegre", "Porto Velho", "Recife", 
            "Rio Branco", "Rio de Janeiro", "Salvador", "São Luís", 
            "São Paulo", "Teresina", "Vitória"
        };
        Graph graph = new Graph(27);
        graph.addEdge(0, 13, 322);
        graph.addEdge(0, 22, 501);
        graph.addEdge(1, 12, 1100);
        graph.addEdge(1, 23, 700);
        graph.addEdge(2, 21, 570);
        graph.addEdge(2, 24, 430);
        graph.addEdge(2, 26, 340);
        graph.addEdge(3, 14, 2100);
        graph.addEdge(4, 10, 430);
        graph.addEdge(4, 16, 880);
        graph.addEdge(5, 6, 730);
        graph.addEdge(5, 24, 690);
        graph.addEdge(6, 16, 1100);
        graph.addEdge(7, 8, 300);
        graph.addEdge(7, 24, 400);
        graph.addEdge(8, 17, 410);
        graph.addEdge(9, 15, 550);
        graph.addEdge(9, 25, 700);
        graph.addEdge(10, 16, 620);
        graph.addEdge(11, 15, 250);
        graph.addEdge(11, 19, 180);
        graph.addEdge(12, 14, 1600);
        graph.addEdge(13, 19, 280);
        graph.addEdge(14, 20, 2300);
        graph.addEdge(15, 19, 170);
        graph.addEdge(17, 24, 750);
        graph.addEdge(19, 22, 400);
        graph.addEdge(21, 24, 310);
        graph.addEdge(21, 26, 280);
        graph.addEdge(22, 26, 520);
        graph.addEdge(23, 25, 570);
        System.out.println("Capitais disponíveis:");
        for (int i = 0; i < capitals.length; i++) {
            System.out.println(i + ": " + capitals[i]);
        }
        System.out.print("Digite o índice da capital de origem: ");
        int src = scanner.nextInt();
        System.out.print("Digite o índice da capital de destino: ");
        int dest = scanner.nextInt();
        if (src < 0 || src >= 27 || dest < 0 || dest >= 27) {
            System.out.println("Índice inválido!");
            scanner.close();
            return;
        }
        graph.dijkstra(src, dest, capitals);
        scanner.close();
    }
}