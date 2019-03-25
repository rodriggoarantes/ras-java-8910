package br.com.ras.java.designpatterns.estrutural.decorator;

public class CoberturaExtra extends Extra {

  public CoberturaExtra(String label, double preco, Pedido pedido) {
    super(label, preco, pedido);
  }

  @Override
  public double getPreco() {
    return this.preco + pedido.getPreco();
  }

}
