package br.com.ras.java.designpatterns.criacao.factory.metodo;

public class MaquinaDeRefrigerante extends MaquinaDeBebidas {

  @Override
  public Bebida entregaBebiba() {
    return new Refrigerante();
  }

}
