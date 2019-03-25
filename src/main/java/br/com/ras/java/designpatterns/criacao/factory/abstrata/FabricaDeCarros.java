package br.com.ras.java.designpatterns.criacao.factory.abstrata;

public interface FabricaDeCarros {
  CarroSedan criarSedan();
  CarroHatch criarHatch();
}
