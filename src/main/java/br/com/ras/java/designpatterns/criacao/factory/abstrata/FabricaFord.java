package br.com.ras.java.designpatterns.criacao.factory.abstrata;

public class FabricaFord implements FabricaDeCarros {

  @Override
  public CarroSedan criarSedan() {
    return new Focus();
  }

  @Override
  public CarroHatch criarHatch() {
    return new Fiesta();
  }

}
