package grafos.classes;

public class Aresta {
  public Cidade destino;
  public int distancia;

  public Aresta(Cidade destino, int distancia) {
    this.destino = destino;
    this.distancia = distancia;
  }
}