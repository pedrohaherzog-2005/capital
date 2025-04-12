package grafos.classes;

import java.util.ArrayList;
import java.util.List;

public class Cidade {
  public String nome;
  public List<Aresta> vizinhos = new ArrayList<>();

  public Cidade(String nome) {
    this.nome = nome;
  }
  
  public String getNome() {
    return nome;
  }
  
  public void setNome(String nome) {
    this.nome = nome;
  }
}