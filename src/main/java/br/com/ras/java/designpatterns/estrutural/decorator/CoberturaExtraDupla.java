package br.com.ras.java.designpatterns.estrutural.decorator;

public class CoberturaExtraDupla extends Extra {

  public CoberturaExtraDupla(String label, double preco, Pedido pedido) {
    super(label, preco, pedido);
  }

  @Override
  public double getPreco() {
    return (this.preco * 2) + pedido.getPreco();
  }

  @Override
  public String getDescricao() {
    return pedido.getDescricao() + ", Dupla " + this.label;
  }

}
