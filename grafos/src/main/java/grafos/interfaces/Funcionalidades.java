package grafos.interfaces;
import java.util.*;
import grafos.classes.Aresta;
import grafos.classes.Cidade;

public class Funcionalidades implements Funcoes {
  public void imprimirCaminho(Cidade origem, Cidade destino, Map<Cidade, Cidade> predecessores) {
    List<Cidade> caminho = new ArrayList<>();
    Cidade atual = destino;
    while (atual != null && !atual.equals(origem)) {
      caminho.add(atual);
      atual = predecessores.get(atual);
    }
    if (atual == null) {
      System.out.println("Caminho não encontrado.");
      return;
    }
    caminho.add(origem);
    Collections.reverse(caminho);
    for (int i = 0; i < caminho.size(); i++) {
      System.out.print(caminho.get(i).nome);
      if (i < caminho.size() - 1) {
        System.out.print(" -> ");
      }
    }
  }

  public Map<Cidade, Integer> calcularMenorCaminho(Cidade origem, Map<Cidade, Cidade> predecessores) {
    Map<Cidade, Integer> distancias = new HashMap<>();
    Set<Cidade> visitados = new HashSet<>();
    PriorityQueue<Cidade> fila = new PriorityQueue<>(Comparator.comparingInt(distancias::get));
    Queue<Cidade> inicial = new LinkedList<>();
    inicial.add(origem);
    while (!inicial.isEmpty()) {
      Cidade atual = inicial.poll();
      if (!distancias.containsKey(atual)) {
        distancias.put(atual, Integer.MAX_VALUE);
        for (Aresta a : atual.vizinhos) {
          inicial.add(a.destino);
        }
      }
    }
    distancias.put(origem, 0);
    fila.add(origem);
    while (!fila.isEmpty()) {
      Cidade atual = fila.poll();
      if (!visitados.add(atual)) continue;
      for (Aresta a : atual.vizinhos) {
        int novaDist = distancias.get(atual) + a.distancia;
        if (novaDist < distancias.getOrDefault(a.destino, Integer.MAX_VALUE)) {
          distancias.put(a.destino, novaDist);
          predecessores.put(a.destino, atual);
          fila.add(a.destino);
        }
      }
    }
    return distancias;
  }
}