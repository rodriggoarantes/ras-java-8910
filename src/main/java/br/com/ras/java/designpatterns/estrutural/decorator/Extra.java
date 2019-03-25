package br.com.ras.java.designpatterns.estrutural.decorator;

public abstract class Extra implements Pedido {

  protected Pedido pedido;
  protected String label;
  protected double preco;

  public Extra(String label, double preco, Pedido pedido) {
    this.label = label;
    this.preco = preco;
    this.pedido = pedido;
  }

  // O preço é delegado para a implementação concreta
  public abstract double getPreco();

  // Label default é fornecido
  public String getDescricao() {
    return pedido.getDescricao() + ", " + this.label;
  }

}
