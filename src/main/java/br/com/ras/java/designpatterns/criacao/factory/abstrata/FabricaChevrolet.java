package br.com.ras.java.designpatterns.criacao.factory.abstrata;

public class FabricaChevrolet implements FabricaDeCarros {

  @Override
  public CarroSedan criarSedan() {
    return new Prisma();
  }

  @Override
  public CarroHatch criarHatch() {
    return new Onix();
  }

}
