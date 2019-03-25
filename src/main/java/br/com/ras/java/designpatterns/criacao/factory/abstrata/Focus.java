package br.com.ras.java.designpatterns.criacao.factory.abstrata;

public class Focus implements CarroSedan {
  @Override
  public void exibirInfoSedan() {
    System.out.println("Focus, Sedan, 4P, Vidro, Trava, Flex, Couro, Ar, Dir.Eletrica");
  }
}
