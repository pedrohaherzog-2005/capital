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

        // Adiciona as conexões entre as capitais (arestas com distâncias)
        grafoBrasil.adicionarAresta(0, 13, 322);     // Aracaju - Maceió
        grafoBrasil.adicionarAresta(0, 22, 501);     // Aracaju - Salvador
        grafoBrasil.adicionarAresta(1, 12, 1100);    // Belém - Macapá
        grafoBrasil.adicionarAresta(1, 23, 700);     // Belém - São Luís
        grafoBrasil.adicionarAresta(2, 21, 570);     // BH - RJ
        grafoBrasil.adicionarAresta(2, 24, 430);     // BH - SP
        grafoBrasil.adicionarAresta(2, 26, 340);     // BH - Vitória
        grafoBrasil.adicionarAresta(3, 14, 2100);    // Boa Vista - Manaus
        grafoBrasil.adicionarAresta(4, 10, 430);     // Brasília - Goiânia
        grafoBrasil.adicionarAresta(4, 16, 880);     // Brasília - Palmas
        grafoBrasil.adicionarAresta(5, 6, 730);      // Campo Grande - Cuiabá
        grafoBrasil.adicionarAresta(5, 24, 690);     // Campo Grande - SP
        grafoBrasil.adicionarAresta(6, 16, 1100);    // Cuiabá - Palmas
        grafoBrasil.adicionarAresta(7, 8, 300);      // Curitiba - Florianópolis
        grafoBrasil.adicionarAresta(7, 24, 400);     // Curitiba - SP
        grafoBrasil.adicionarAresta(8, 17, 410);     // Floripa - Porto Alegre
        grafoBrasil.adicionarAresta(9, 15, 550);     // Fortaleza - Natal
        grafoBrasil.adicionarAresta(9, 25, 700);     // Fortaleza - Teresina
        grafoBrasil.adicionarAresta(10, 16, 620);    // Goiânia - Palmas
        grafoBrasil.adicionarAresta(11, 15, 250);    // João Pessoa - Natal
        grafoBrasil.adicionarAresta(11, 19, 180);    // João Pessoa - Recife
        grafoBrasil.adicionarAresta(12, 14, 1600);   // Macapá - Manaus
        grafoBrasil.adicionarAresta(13, 19, 280);    // Maceió - Recife
        grafoBrasil.adicionarAresta(14, 20, 2300);   // Manaus - Rio Branco
        grafoBrasil.adicionarAresta(15, 19, 170);    // Natal - Recife
        grafoBrasil.adicionarAresta(17, 24, 750);    // Porto Alegre - SP
        grafoBrasil.adicionarAresta(19, 22, 400);    // Recife - Salvador
        grafoBrasil.adicionarAresta(21, 24, 310);    // Rio de Janeiro - SP
        grafoBrasil.adicionarAresta(21, 26, 280);    // Rio de Janeiro - Vitória
        grafoBrasil.adicionarAresta(22, 26, 520);    // Salvador - Vitória
        grafoBrasil.adicionarAresta(23, 25, 570);    // São Luís - Teresina

        // Exibe lista de capitais
        System.out.println("Capitais disponíveis:");
        for (int i = 0; i < nomesCapitais.length; i++) {
            System.out.println(i + ": " + nomesCapitais[i]);
        }

        // Leitura do usuário
        System.out.print("\nDigite o índice da capital de origem: ");
        int indiceOrigem = scanner.nextInt();

        System.out.print("Digite o índice da capital de destino: ");
        int indiceDestino = scanner.nextInt();

        // Validação
        if (indiceOrigem < 0 || indiceOrigem >= 27 || indiceDestino < 0 || indiceDestino >= 27) {
            System.out.println("Índice inválido!");
            scanner.close();
            return;
        }

        // Executa Dijkstra
        grafoBrasil.encontrarMenorCaminhoDijkstra(indiceOrigem, indiceDestino, nomesCapitais);
        scanner.close();
    }
}
