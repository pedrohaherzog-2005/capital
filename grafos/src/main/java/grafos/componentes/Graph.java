package grafos.componentes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Graph {
  private int V;
  private List<List<Node>> adj;
  class Node {
    int vertex;
    double weight;
    Node(int vertex, double weight) {
      this.vertex = vertex;
      this.weight = weight;
    }
  }
  public Graph(int V) {
    this.V = V;
    adj = new ArrayList<>();
    for (int i = 0; i < V; i++) {
      adj.add(new ArrayList<>());
    }
  }
  public void addEdge(int u, int v, double weight) {
    adj.get(u).add(new Node(v, weight));
    adj.get(v).add(new Node(u, weight));
  }
  public List<Integer> dijkstra(int src, int dest, String[] capitals) {
    double[] dist = new double[V];
    int[] prev = new int[V];
    Arrays.fill(dist, Double.POSITIVE_INFINITY);
    Arrays.fill(prev, -1);
    dist[src] = 0;
    PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> Double.compare(a.weight, b.weight));
    pq.offer(new Node(src, 0));
    while (!pq.isEmpty()) {
      Node node = pq.poll();
      int u = node.vertex;
      for (Node neighbor : adj.get(u)) {
        int v = neighbor.vertex;
        double weight = neighbor.weight;
        if (dist[u] + weight < dist[v]) {
          dist[v] = dist[u] + weight;
          prev[v] = u;
          pq.offer(new Node(v, dist[v]));
        }
      }
    }
    List<Integer> path = new ArrayList<>();
    for (int at = dest; at != -1; at = prev[at]) {
      path.add(at);
    }
    Collections.reverse(path);
    if (dist[dest] == Double.POSITIVE_INFINITY) {
      System.out.println("Não há caminho entre " + capitals[src] + " e " + capitals[dest]);
      return new ArrayList<>();
    }
    System.out.println("Menor distância entre " + capitals[src] + " e " + capitals[dest] + ": " + dist[dest] + " km");
    System.out.print("Caminho: ");
    for (int i = 0; i < path.size(); i++) {
      System.out.print(capitals[path.get(i)]);
      if (i < path.size() - 1) {
        System.out.print(" -> ");
      }
    }
    System.out.println();
    return path;
  }
}