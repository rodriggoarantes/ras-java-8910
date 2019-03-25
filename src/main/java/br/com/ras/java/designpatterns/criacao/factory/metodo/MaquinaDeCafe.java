package br.com.ras.java.designpatterns.criacao.factory.metodo;


public class MaquinaDeCafe extends MaquinaDeBebidas {
  
  public enum TipoDoCafe {EXPRESSO, COADO}

  @Override
  public Bebida entregaBebiba() {
    return new Cafe();
  }
  
  public Bebida entregaBebiba(TipoDoCafe tipo) {
    final Bebida cafe;
    switch (tipo) {
      case EXPRESSO: cafe = new CafeExpresso(); break;
      case COADO: cafe = new CafeCoado(); break;
      default: cafe = new Cafe();
    }
    return cafe;
  }

}
