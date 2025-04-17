package grafos.componentes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Graph {
  private int totalVertices; // Quantidade total de vértices
  private List<List<Adjacency>> listaAdjacencia; // Lista de adjacência

  // Classe interna representando um vizinho (nó adjacente)
  class Adjacency {
    int destino; // Vértice de destino
    double distancia; // Peso (distância) da aresta

    Adjacency(int destino, double distancia) {
      this.destino = destino;
      this.distancia = distancia;
    }
  }

  public Graph(int totalVertices) {
    this.totalVertices = totalVertices;
    listaAdjacencia = new ArrayList<>();
    for (int i = 0; i < totalVertices; i++) {
      listaAdjacencia.add(new ArrayList<>());
    }
  }

  public void adicionarAresta(int origem, int destino, double distancia) {
    listaAdjacencia.get(origem).add(new Adjacency(destino, distancia));
    listaAdjacencia.get(destino).add(new Adjacency(origem, distancia)); // grafo não-direcional
  }

  public List<Integer> encontrarMenorCaminhoDijkstra(int origem, int destino, String[] nomesCapitais) {
    double[] distancias = new double[totalVertices];
    int[] anteriores = new int[totalVertices]; // Para reconstrução do caminho
    Arrays.fill(distancias, Double.POSITIVE_INFINITY);
    Arrays.fill(anteriores, -1);
    distancias[origem] = 0;

    PriorityQueue<Adjacency> filaPrioridade = new PriorityQueue<>(
      (a, b) -> Double.compare(a.distancia, b.distancia)
    );
    filaPrioridade.offer(new Adjacency(origem, 0));

    while (!filaPrioridade.isEmpty()) {
      Adjacency atual = filaPrioridade.poll();
      int verticeAtual = atual.destino;

      for (Adjacency vizinho : listaAdjacencia.get(verticeAtual)) {
        int verticeVizinho = vizinho.destino;
        double pesoAresta = vizinho.distancia;

        if (distancias[verticeAtual] + pesoAresta < distancias[verticeVizinho]) {
          distancias[verticeVizinho] = distancias[verticeAtual] + pesoAresta;
          anteriores[verticeVizinho] = verticeAtual;
          filaPrioridade.offer(new Adjacency(verticeVizinho, distancias[verticeVizinho]));
        }
      }
    }

    // Reconstrução do caminho
    List<Integer> caminho = new ArrayList<>();
    for (int atual = destino; atual != -1; atual = anteriores[atual]) {
      caminho.add(atual);
    }
    Collections.reverse(caminho);

    // Verificação e exibição do resultado
    if (distancias[destino] == Double.POSITIVE_INFINITY) {
      System.out.println("Não há caminho entre " + nomesCapitais[origem] + " e " + nomesCapitais[destino]);
      return new ArrayList<>();
    }

    System.out.println("Menor distância entre " + nomesCapitais[origem] + " e " + nomesCapitais[destino] + ": " + distancias[destino] + " km");
    System.out.print("Caminho: ");
    for (int i = 0; i < caminho.size(); i++) {
      System.out.print(nomesCapitais[caminho.get(i)]);
      if (i < caminho.size() - 1) {
        System.out.print(" -> ");
      }
    }
    System.out.println();

    return caminho;
  }
}
