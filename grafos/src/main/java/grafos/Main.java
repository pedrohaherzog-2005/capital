package grafos;

import java.util.*;
import grafos.componentes.Graph;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] nomesCapitais = {
                "Aracaju", "Belém", "Belo Horizonte", "Boa Vista", "Brasília",
                "Campo Grande", "Cuiabá", "Curitiba", "Florianópolis", "Fortaleza",
                "Goiânia", "João Pessoa", "Macapá", "Maceió", "Manaus",
                "Natal", "Palmas", "Porto Alegre", "Porto Velho", "Recife",
                "Rio Branco", "Rio de Janeiro", "Salvador", "São Luís",
                "São Paulo", "Teresina", "Vitória"
        };

        Graph grafoBrasil = new Graph(27);

        grafoBrasil.adicionarAresta(0, 13, 322);
        grafoBrasil.adicionarAresta(0, 22, 501);
        grafoBrasil.adicionarAresta(1, 12, 1100);
        grafoBrasil.adicionarAresta(1, 23, 700);
        grafoBrasil.adicionarAresta(2, 21, 570);
        grafoBrasil.adicionarAresta(2, 24, 430);
        grafoBrasil.adicionarAresta(2, 26, 340);
        grafoBrasil.adicionarAresta(3, 14, 2100);
        grafoBrasil.adicionarAresta(4, 10, 430);
        grafoBrasil.adicionarAresta(4, 16, 880);
        grafoBrasil.adicionarAresta(5, 6, 730);
        grafoBrasil.adicionarAresta(5, 24, 690);
        grafoBrasil.adicionarAresta(6, 16, 1100);
        grafoBrasil.adicionarAresta(7, 8, 300);
        grafoBrasil.adicionarAresta(7, 24, 400);
        grafoBrasil.adicionarAresta(8, 17, 410);
        grafoBrasil.adicionarAresta(9, 15, 550);
        grafoBrasil.adicionarAresta(9, 25, 700);
        grafoBrasil.adicionarAresta(10, 16, 620);
        grafoBrasil.adicionarAresta(11, 15, 250);
        grafoBrasil.adicionarAresta(11, 19, 180);
        grafoBrasil.adicionarAresta(12, 14, 1600);
        grafoBrasil.adicionarAresta(13, 19, 280);
        grafoBrasil.adicionarAresta(14, 20, 2300);
        grafoBrasil.adicionarAresta(15, 19, 170);
        grafoBrasil.adicionarAresta(17, 24, 750);
        grafoBrasil.adicionarAresta(19, 22, 400);
        grafoBrasil.adicionarAresta(21, 24, 310);
        grafoBrasil.adicionarAresta(21, 26, 280);
        grafoBrasil.adicionarAresta(22, 26, 520);
        grafoBrasil.adicionarAresta(23, 25, 570);

        System.out.println("Capitais disponíveis:");
        for (int i = 0; i < nomesCapitais.length; i++) {
            System.out.println(i + ": " + nomesCapitais[i]);
        }

        System.out.print("\nDigite o índice da capital de origem: ");
        int indiceOrigem = scanner.nextInt();

        System.out.print("Digite o índice da capital de destino: ");
        int indiceDestino = scanner.nextInt();

        if (indiceOrigem < 0 || indiceOrigem >= 27 || indiceDestino < 0 || indiceDestino >= 27) {
            System.out.println("Índice inválido!");
            scanner.close();
            return;
        }

        grafoBrasil.encontrarMenorCaminhoDijkstra(indiceOrigem, indiceDestino, nomesCapitais);
        scanner.close();
    }
}
