package br.com.ras.java.designpatterns.criacao.factory.abstrata;

public class Prisma implements CarroSedan {
  @Override
  public void exibirInfoSedan() {
    System.out.println("Prisma, Sedan, 4P, Vidro, Trava, Flex, Couro");
  }
}
