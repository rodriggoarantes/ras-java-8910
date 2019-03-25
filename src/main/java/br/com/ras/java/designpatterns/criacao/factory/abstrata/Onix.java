package br.com.ras.java.designpatterns.criacao.factory.abstrata;

public class Onix implements CarroHatch {
  @Override
  public void exibirInfoHatch() {
    System.out.println("Onix, 4P, Vidro, Trava, Flex");
  }
}
