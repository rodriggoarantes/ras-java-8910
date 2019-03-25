package br.com.ras.java.designpatterns.criacao.factory.abstrata;

public class Fiesta implements CarroHatch {
  @Override
  public void exibirInfoHatch() {
    System.out.println("Fiesta, 2P, Vidro, Trava, Flex, Ar");
  }
}
