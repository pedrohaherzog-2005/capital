package grafos.interfaces;
import java.util.Map;
import grafos.classes.Cidade;

public interface Funcoes {
  void imprimirCaminho(Cidade origem, Cidade destino, Map<Cidade, Cidade> predecessores);
  Map<Cidade, Integer> calcularMenorCaminho(Cidade origem, Map<Cidade, Cidade> predecessores);
}